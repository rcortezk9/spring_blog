package com.codeup.Services;

import com.codeup.Repositories.PostsRepositories;
import com.codeup.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public Iterable<Post> findAll(){
        return postsDao.findAll();
    }

    public Post save(Post post){
        return postsDao.save(post);
    }

    public Post findOne(long id){
        return postsDao.findOne(id);
    }
}
