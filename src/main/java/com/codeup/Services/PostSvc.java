package com.codeup.Services;

import com.codeup.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renecortez on 6/20/17.
 */

@Service("PostSvc")
public class PostSvc {
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

        save(new Post("One more post", "lorem ipsum, etc...."));
        save(new Post("One more post", "lorem ipsum, etc...."));
    }
}
