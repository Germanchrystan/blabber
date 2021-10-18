package com.blabber.blabber.controllers;

import com.blabber.blabber.dto.PostsDto;
import com.blabber.blabber.models.Post;
import com.blabber.blabber.services.PostService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/api/posts/")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @RequestMapping(value="/by-user/{userId}", method= RequestMethod.GET)
    public ResponseEntity<List<PostsDto>> getPostsByUser(@PathVariable("userId") String userId){
        if(userId.isEmpty()) return new ResponseEntity(NOT_FOUND);
        int userIdInt = parseInt(userId);
        List<PostsDto> postsList = postService.getPostsByUser(userIdInt);
        return ResponseEntity.status(OK).body(postsList);
    }

    @RequestMapping(value="post", method= RequestMethod.POST)
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }
}
