package com.dxc.qdang.ecommercedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.qdang.ecommercedemo.exception.UserAlreadyExistsException;
import com.dxc.qdang.ecommercedemo.model.AppUser;
import com.dxc.qdang.ecommercedemo.model.AppUserDto;
import com.dxc.qdang.ecommercedemo.repository.AppUserRepository;

@Service
@Transactional
public class SignupService {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

        return userRepository.save(user);
    }

    private boolean userExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

}
