package com.todo.service;

import com.todo.domain.User;
import com.todo.dto.UserDTO;
import com.todo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    public User create(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
        log.info("Saved new user - " + userDTO.getUsername());

        return user;
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
