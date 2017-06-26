package com.codeup.Services;

import com.codeup.Repositories.Roles;
import com.codeup.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by renecortez on 6/26/17.
 */

public class UsersWithRoles extends User implements UserDetails {
    private List<String> userRoles;

    public UsersWithRoles(User user, List<String> userRoles) {
        super(user);
        this.userRoles = userRoles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


