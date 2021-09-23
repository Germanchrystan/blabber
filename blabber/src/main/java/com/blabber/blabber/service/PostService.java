package com.blabber.blabber.service;

import com.blabber.blabber.models.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PostService {

    List<Post> getPostsByUser(int userId);
    Post createPost(Post post);
    // void deletePost(int id);
   // Post getPostById(int id);


}
