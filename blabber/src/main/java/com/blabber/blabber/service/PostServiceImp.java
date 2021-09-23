package com.blabber.blabber.service;

import com.blabber.blabber.models.Post;
import com.blabber.blabber.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class PostServiceImp implements PostService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Post> getPostsByUser(int userId){
        String query="From Post WHERE userId = :userId";
        List<Post> postList = entityManager.createQuery(query)
                .setParameter("userId", userId)
                .getResultList();
        return postList;
    }

    @Override
    public Post createPost(Post post){
        String checkUserQuery="FROM User WHERE id = :id";

        List<User> userList = entityManager.createQuery(checkUserQuery)
              .setParameter("id", post.getUserId())
              .getResultList();
        if(userList.isEmpty()) return null;

        System.out.println(userList);
        Date date = new Date();

        post.setEdited(false);
        post.setPublishDate(date);
        post.setLikes(0);

        entityManager.merge(post);
        return post;
    }

}
