package com.codeup.Repositories;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * Created by renecortez on 6/22/17.
 */

public interface PostsRepositories extends CrudRepository {
    // All the custom methods can be declared in here.

    Post findByTitle(String title);

    List<Post> findByTitleIsLike(String title);
}
