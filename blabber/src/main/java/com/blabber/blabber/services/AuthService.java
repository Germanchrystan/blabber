package com.blabber.blabber.services;

import com.blabber.blabber.models.User;

public interface AuthService {

    User verifyCredentials(User user);
    String registerUser(User user);
}
