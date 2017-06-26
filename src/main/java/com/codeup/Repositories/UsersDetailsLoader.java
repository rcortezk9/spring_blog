package com.codeup.Repositories;

import com.codeup.Services.UsersWithRoles;
import com.codeup.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by renecortez on 6/26/17.
 */
@Service("customUserDetailsService")
public class UsersDetailsLoader implements UserDetailsService {

    private final UsersRepositories users;
    private final Roles roles;

    @Autowired
    public UsersDetailsLoader(UsersRepositories users, Roles roles) {
        this.users = users;
        this.roles = roles;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        List<String> userRoles = roles.ofUserWith(username);
        return new UsersWithRoles(user, userRoles);
    }
}
