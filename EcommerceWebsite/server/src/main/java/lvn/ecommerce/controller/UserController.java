package lvn.ecommerce.controller;

import lvn.ecommerce.entity.User;
import lvn.ecommerce.service.CartService;
import lvn.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Get user detail
     * @return User detail
     */
    @GetMapping("")
    public User getUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return userService.findById(user.getId());
    }

    /**
     * Change password
     * @param password New password
     * @return Overwrite user
     */
    @PutMapping("/change-password")
    public User updateUser(@RequestBody String password, Authentication authentication) {
        User u = (User) authentication.getPrincipal();
        User user = userService.findById(u.getId());
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        return userService.save(user);
    }

    /**
     * Delete a user from database
     * @param id of user
     */
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
