package com.bugjc.ea.jwt.core.security;

import java.util.Collection;
import java.util.Date;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by stephan on 20.03.16.
 */
@Data
public class JwtUser implements UserDetails {

    private final Long id;
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> roles;
    private final boolean isEnabled;
    private final Date lastPasswordResetDate;


    public JwtUser(
          Long id,
          String username,
          String password, Collection<? extends GrantedAuthority> roles,
          boolean isEnabled,
          Date lastPasswordResetDate
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.isEnabled = isEnabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }


    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
