package com.dxc.qdang.ecommercedemo.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.qdang.ecommercedemo.exception.UserAlreadyExistsException;
import com.dxc.qdang.ecommercedemo.model.AppAuthority;
import com.dxc.qdang.ecommercedemo.model.AppUser;
import com.dxc.qdang.ecommercedemo.model.AppUserDto;
import com.dxc.qdang.ecommercedemo.repository.AppAuthorityRepository;
import com.dxc.qdang.ecommercedemo.repository.AppUserRepository;

@Service
@Transactional
public class SignupService {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private AppAuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void postConstruct() {
        if (authorityRepository.findByName("User") == null) {
            Set<AppAuthority> authorities = new HashSet<>();
            authorities.add(new AppAuthority("User"));
            authorities.add(new AppAuthority("Editor"));
            authorities.add(new AppAuthority("Admin"));

            authorityRepository.saveAll(authorities);
        }

        Set<AppUser> users = new HashSet<>();
        Set<AppAuthority> userAuthorities = authorityRepository
                .findDistinctByNameIgnoreCaseIn("user");
        Set<AppAuthority> adminAuthorities = authorityRepository
                .findDistinctByNameIgnoreCaseIn("user", "admin");

        users.add(new AppUser("user1@example.com",
                passwordEncoder.encode("user1Pass"), "User1"));
        users.add(new AppUser("user2@example.com",
                passwordEncoder.encode("user2Pass"), "User2"));

        for (AppUser u : users) {
            u.setAuthorities(userAuthorities);
        }

        AppUser admin = new AppUser("admin@example.com",
                passwordEncoder.encode("adminPass123"), "Admin");
        admin.setAuthorities(adminAuthorities);
        users.add(admin);

        userRepository.saveAll(users);
    }

    public AppUser registerNewUser(AppUserDto userDto)
            throws UserAlreadyExistsException {
        if (userExists(userDto.getEmail())) {
            throw new UserAlreadyExistsException(
                    "There is already an account with email address:"
                            + userDto.getEmail());
        }

        AppUser user = new AppUser();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setDisplayName(userDto.getDisplayName());

        user.setAuthorities(authorityRepository
                .findDistinctByNameIgnoreCaseIn("user"));

        return userRepository.save(user);
    }

    private boolean userExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

}
