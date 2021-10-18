package com.blabber.blabber.repositories;

import com.blabber.blabber.models.Post;
import com.blabber.blabber.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUser(User user);

}
