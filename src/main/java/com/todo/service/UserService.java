package com.todo.service;

import com.todo.domain.User;
import com.todo.dto.UserDTO;
import com.todo.repository.UserRepository;
import com.todo.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserResponse create(UserDTO userDTO) {
        UserDetails userDetails = userRepository.findByUsername(userDTO.getUsername());
        if (userDetails != null) {
            log.info("User " + userDTO.getUsername() + " already exists");
            return new UserResponse(HttpStatus.BAD_REQUEST);
        }

        User user = new User(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
        log.info("Saved new user - " + userDTO.getUsername());

        return new UserResponse(user, HttpStatus.CREATED);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByUsername(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException("User - " + username + " does not exist");
        }
        return userDetails;
    }

    public User getCurrentUser() {
        return userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
