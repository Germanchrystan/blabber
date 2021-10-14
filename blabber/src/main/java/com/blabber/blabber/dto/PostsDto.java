package com.blabber.blabber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsDto {
    private Long id;
    private Long postId;
    private Instant createdDate;
    private String content;
    private String username;
}
