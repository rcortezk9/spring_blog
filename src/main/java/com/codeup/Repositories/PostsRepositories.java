package com.codeup.Repositories;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by renecortez on 6/22/17.
 */

@Repository
public interface PostsRepositories extends CrudRepository<Post, Long> {
    // All the custom methods can be declared in here.

}
