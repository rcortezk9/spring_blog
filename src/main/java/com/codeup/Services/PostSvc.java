package com.codeup.Services;

import com.codeup.Repositories.PostsRepositories;
import com.codeup.Repositories.UsersRepositories;
import com.codeup.models.Post;
import com.codeup.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by renecortez on 6/20/17.
 */

@Service("postSvc")//make sure it is not the same as the class
public class PostSvc {
    private PostsRepositories postsDao; //step 1


    @Autowired
    public PostSvc(PostsRepositories postsDao){ //step 2
        this.postsDao = postsDao;

    }


    public Iterable<Post> findAll(){
        return postsDao.findAll();
    }


    public Post save(Post post){
        postsDao.save(post);
        return post;
    }

    public Post findOne(long id){
        return postsDao.findOne(id);
    }

    public void deletePost(long id){
        postsDao.delete(id);
    }
}
