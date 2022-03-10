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
import com.dxc.qdang.ecommercedemo.model.CartDetail;
import com.dxc.qdang.ecommercedemo.repository.AppAuthorityRepository;
import com.dxc.qdang.ecommercedemo.repository.AppUserRepository;
import com.dxc.qdang.ecommercedemo.repository.CartRepository;

@Service
@Transactional
public class SignupService {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private AppAuthorityRepository authorityRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void postConstruct() {
        AppAuthority userAuthority = new AppAuthority("User");
        AppAuthority editorAuthority = new AppAuthority("Editor");
        AppAuthority adminAuthority = new AppAuthority("Admin");

        Set<AppUser> users = new HashSet<>();

        users.add(new AppUser("user1@example.com", passwordEncoder.encode("user1Pass"), "User1", userAuthority));
        users.add(new AppUser("user2@example.com", passwordEncoder.encode("user2Pass"), "User2", userAuthority));
        users.add(
                new AppUser("editor@example.com", passwordEncoder.encode("editorPass123"), "Editor", editorAuthority));
        users.add(new AppUser("admin@example.com", passwordEncoder.encode("adminPass123"), "Admin", adminAuthority));

        Iterable<AppUser> returnedUsers = userRepository.saveAll(users);
        Set<CartDetail> carts = new HashSet<>();

        returnedUsers.forEach(u -> {
            carts.add(new CartDetail(u));
        });
        cartRepository.saveAll(carts);
    }

    public AppUser registerNewUser(AppUserDto userDto)
            throws UserAlreadyExistsException {
        if (userExists(userDto.getEmail())) {
            throw new UserAlreadyExistsException(
                    "There is already an account with email address:" + userDto.getEmail());
        }

        AppUser user = new AppUser();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setDisplayName(userDto.getDisplayName());

        user.setAuthority(authorityRepository.findByNameIgnoreCase("user"));

        AppUser returnedUser = userRepository.save(user);
        CartDetail cart = new CartDetail(returnedUser);
        cartRepository.save(cart);

        return returnedUser;
    }

    private boolean userExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

}
