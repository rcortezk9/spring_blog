package com.codeup.Repositories;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by renecortez on 6/22/17.
 */

public interface PostsRepositories extends CrudRepository<Post, Long> {
    // All the custom methods can be declared in here.

}
