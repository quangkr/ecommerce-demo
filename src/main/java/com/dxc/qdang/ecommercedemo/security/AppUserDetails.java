package com.dxc.qdang.ecommercedemo.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dxc.qdang.ecommercedemo.model.AppUser;
import com.dxc.qdang.ecommercedemo.util.SerializableVersion;

import lombok.Getter;

@Getter
public class AppUserDetails implements UserDetails {

    private static final long serialVersionUID = SerializableVersion.SERIAL_VERSION_UID;

    private Long userId;

    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;

    public AppUserDetails(AppUser user) {
        super();

        this.userId = user.getId();

        this.username = user.getEmail();
        this.password = user.getPassword();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = user.isEnabled();

        Set<SimpleGrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + user.getAuthority().getName().toUpperCase()));
        this.authorities = roles;
    }

}
