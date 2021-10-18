package com.blabber.blabber.mappers;


import com.blabber.blabber.dto.PostRequest;
import com.blabber.blabber.dto.PostsDto;
import com.blabber.blabber.models.Post;
import com.blabber.blabber.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "content", source = "postRequest.getContent()")
    @Mapping(target = "likeCount", constant = "0")
    @Mapping(target = "edited", constant = "false")
    @Mapping(target = "userId", source = "user")
    public abstract Post mapDtoToEntity(PostRequest postRequest, User user);

    public abstract PostsDto mapEntityToDto();
}
