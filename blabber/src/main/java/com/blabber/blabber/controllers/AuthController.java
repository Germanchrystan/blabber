package com.blabber.blabber.controllers;

import com.blabber.blabber.models.User;
import com.blabber.blabber.services.AuthService;
import com.blabber.blabber.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="auth/login", method= RequestMethod.POST)
    public String login(@RequestBody User user){
        User userFound = authService.verifyCredentials(user);
        if(userFound != null){
            String token = jwtUtil.create(String.valueOf(userFound.getId()),userFound.getEmail());
            return token;
        } else {
            return "Wrong Credentials";
        }
    }
    @RequestMapping(value="auth/register", method=RequestMethod.POST)
    public String registerUser(@RequestBody User user){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hashedPassword = argon2.hash(1,1024, 1, user.getPassword());
        user.setPassword(hashedPassword);
        return authService.registerUser(user);
    }
}
