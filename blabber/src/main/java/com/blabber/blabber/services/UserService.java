package com.blabber.blabber.services;

import com.blabber.blabber.models.User;

import java.util.List;

public interface UserService {

    List<User> getFollowers(int id);
    List<User> getFollowings(int id);
    User getUserById(int id);

}
