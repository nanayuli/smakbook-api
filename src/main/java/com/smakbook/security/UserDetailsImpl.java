package com.smakbook.security;

import com.smakbook.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class UserDetailsImpl
 * @since 28/11/2024 — 22.32
 **/
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {
    @Getter
    private final Integer id;
    private final String username;
    private final String password;
    @Getter
    private final String role;
    private final Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));
        return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(), user.getRole().getName(), authorities);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
