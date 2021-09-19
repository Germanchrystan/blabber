package com.blabber.blabber.service;

import com.blabber.blabber.models.Post;

import java.util.List;

public interface PostService {

    void createPost(Post post);
    void deletePost(int id);
    List<Post> getPostsByUser(int userId);
    Post getPostById(int id);


}
