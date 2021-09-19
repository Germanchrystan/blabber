package com.blabber.blabber.service;

import com.blabber.blabber.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserServiceImp implements UserService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getFollowers(int id){
        String query = "FROM follow GET * WHERE followedId = :id";// INNER JOIN
        List<User> followersList = entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();
        return followersList;
    }

    @Override
    public List<User> getFollowings(int id){
        String query = "From follow GET * WHERE followerId = :id"; // INNER JOIN
        List<User> followingsList = entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();
        return followingsList;
    }
    public User getUserById(int id){
        User user = entityManager.find(User.class, id);
        return null;
    }
}
