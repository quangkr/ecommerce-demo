package com.dxc.qdang.ecommercedemo.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dxc.qdang.ecommercedemo.model.AppUser;
import com.dxc.qdang.ecommercedemo.repository.AppUserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        AppUser user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new User(user.getEmail(), user.getPassword(),
                user.getIsEnabled().equals(AppUser.EnabledStatus.Y),
                accountNonExpired,
                credentialsNonExpired, accountNonLocked,
                getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            AppUser user) {
        return user.getAuthorities().stream()
                .map(a -> new SimpleGrantedAuthority(a.getName()))
                .collect(Collectors.toList());
    }
}
