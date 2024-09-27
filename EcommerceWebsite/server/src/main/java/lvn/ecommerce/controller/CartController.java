package lvn.ecommerce.controller;

import lvn.ecommerce.entity.Cart;
import lvn.ecommerce.entity.Item;
import lvn.ecommerce.entity.Product;
import lvn.ecommerce.entity.User;
import lvn.ecommerce.service.CartService;
import lvn.ecommerce.service.ItemService;
import lvn.ecommerce.service.ProductService;
import lvn.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
@RestController
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    /**
     * Get cart info
     * @return Cart
     */
    @GetMapping("")
    public Cart getCart(Authentication authentication) {
        User u = (User) authentication.getPrincipal();
        User user = userService.findById(u.getId());
        return cartService.findById(user.getCart().getId());
    }
}
