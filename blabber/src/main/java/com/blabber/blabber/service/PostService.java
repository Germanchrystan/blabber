package com.blabber.blabber.service;

import com.blabber.blabber.models.Post;
import com.blabber.blabber.models.User;
import javassist.compiler.ast.Pair;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PostService {

    List<Post> getPostsByUser(int userId);
    Post createPost(Post post);
    Post getPostById(int id);
    // void deletePost(int id);


}
