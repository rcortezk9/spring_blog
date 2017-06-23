package com.codeup.Repositories;

import com.codeup.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by renecortez on 6/23/17.
 */
public interface Roles extends CrudRepository<UserRole, Long>{

    //using HQL
    @Query("select ur.role from UserRole ur, User u where u.username=?1 and ur.userId = u.id")
    public List<String> ofUserWith(String username);

}
