package com.blabber.blabber.controllers;

import com.blabber.blabber.models.Post;
import com.blabber.blabber.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value="post/{userId}", method= RequestMethod.GET)
    public List<Post> getPostsByUser(@PathVariable("userId") String userId){
        if(userId.isEmpty()) return null;
        int userIdInt = parseInt(userId);
        return postService.getPostsByUser(userIdInt);
    }

    @RequestMapping(value="post", method= RequestMethod.POST)
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }
}
