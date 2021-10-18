package com.blabber.blabber.services;

import com.blabber.blabber.dto.PostRequest;
import com.blabber.blabber.dto.PostsDto;
import com.blabber.blabber.mappers.PostMapper;
import com.blabber.blabber.models.User;
import com.blabber.blabber.repositories.PostRepository;
import com.blabber.blabber.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Transactional
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public void save(PostRequest postRequest){
        postRepository.save(postMapper.mapDtoToEntity(postRequest, authService.getCurrentUser()))
    }

    public List<PostsDto> getPostsByUser(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapEntityToDto)
                .collect(toList());

    }
    //Post createPost(Post post);
    //Post getPostById(int id);
    // void deletePost(int id);


}
