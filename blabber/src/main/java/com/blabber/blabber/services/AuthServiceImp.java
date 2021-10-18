package com.blabber.blabber.services;

import com.blabber.blabber.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AuthServiceImp implements AuthService{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public User verifyCredentials(User user){
        String query = "FROM User WHERE email = :email";

        List<User> userList = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();
        if(userList.isEmpty()) return null;

        String passwordHashed = userList.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        boolean isPasswordCorrect= argon2.verify(passwordHashed, user.getPassword());
        if(isPasswordCorrect){
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public String registerUser(User user){
        String query = "FROM User WHERE email = :email";

        List<User> userList = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();
        if(!userList.isEmpty()) return "Email taken";
        entityManager.merge(user);
        return "User Registered";
    }
}
