package com.codeup.Repositories;

import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by renecortez on 6/23/17.
 */

@Repository
public interface UsersRepositories extends CrudRepository<User, Long> {
}
