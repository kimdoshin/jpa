package com.springboot.jpa.data.entity;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public interface UserDetail extends Serializable {

    Collection<? extends GrantedAuthority> getAuthorities();

    String getPassword();

    String getName();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();
}
