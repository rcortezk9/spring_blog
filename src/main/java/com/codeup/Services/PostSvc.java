package com.codeup.Services;

import com.codeup.Repositories.PostsRepositories;
import com.codeup.controllers.PostsController;
import com.codeup.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;//don't not import the one with sun

/**
 * Created by renecortez on 6/20/17.
 */

@Service("postSvc")//make sure it is not the same as the class
public class PostSvc {

    private PostsRepositories postsDao;

    @Autowired
    public PostSvc(PostsRepositories postsDao){
        this.postsDao = postsDao;
    }


    private List<Post> posts;

    public PostSvc(){
        createPost();
    }

    public List<Post> findAll(){
        return posts;
    }

    public Post save(Post post){
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(long id){
        return posts.get((int) id - 1);
    }

    private void createPost(){
        posts = new ArrayList<>();

        save(new Post("One more posts", "lorem ipsum, etc...."));
        save(new Post("One more posts", "lorem ipsum, etc...."));
    }

}
