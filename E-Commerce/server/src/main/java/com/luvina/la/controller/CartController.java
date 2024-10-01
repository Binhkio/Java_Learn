package com.luvina.la.controller;

import com.luvina.la.entity.Cart;
import com.luvina.la.entity.User;
import com.luvina.la.repository.CartRepository;
import com.luvina.la.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/cart")
@RestController
public class CartController {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * Get cart info
     * @return Cart
     */
    @GetMapping("")
    public Cart getCart(Authentication authentication) {
        User u = (User) authentication.getPrincipal();
        User user = userRepository.findById(u.getId()).orElse(null);
        assert user != null;
        return cartRepository.findById(user.getCart().getId()).orElse(null);
    }
}
