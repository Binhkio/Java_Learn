package com.luvina.la.controller;

import com.luvina.la.entity.User;
import com.luvina.la.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * Get user detail
     * @return User detail
     */
    @GetMapping("")
    public User getUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return userRepository.findById(user.getId()).orElse(null);
    }

    /**
     * Change password
     * @param password New password
     * @return Overwrite user
     */
    @PutMapping("/change-password")
    public User updateUser(@RequestBody String password, Authentication authentication) {
        User u = (User) authentication.getPrincipal();
        User user = userRepository.findById(u.getId()).orElse(null);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        assert user != null;
        user.setPassword(encoder.encode(password));
        return userRepository.save(user);
    }

    /**
     * Delete a user from database
     * @param id of user
     */
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
}
