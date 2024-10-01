package com.luvina.la.controller;

import com.luvina.la.config.jwt.AuthUserDetails;
import com.luvina.la.entity.Cart;
import com.luvina.la.entity.Item;
import com.luvina.la.entity.Product;
import com.luvina.la.entity.User;
import com.luvina.la.repository.CartRepository;
import com.luvina.la.repository.ItemRepository;
import com.luvina.la.repository.ProductRepository;
import com.luvina.la.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/item")
@RestController
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * Add an item into user's cart
     * @param pId Product ID
     * @param quantity Quantity
     */
    @PostMapping("/add")
    public Item addItem(@RequestParam Long pId, @RequestParam(defaultValue = "1") int quantity, Authentication authentication) {
        AuthUserDetails u = (AuthUserDetails) authentication.getPrincipal();
        User user = u.getUser();
        Product product = productRepository.findById(pId).orElse(null);
        assert user != null;
        Cart cart = user.getCart();
        Item newItem = new Item();
        newItem.setProduct(product);
        newItem.setQuantity(quantity);
        newItem.setCart(cart);
        return itemRepository.save(newItem);
    }

    /**
     * Update item status
     * @param newItem New item
     */
    @PutMapping("/update")
    public Item updateItem(@RequestBody Item newItem) {
        Item oldItem = itemRepository.findById(newItem.getId()).orElse(null);
        assert oldItem != null;
        oldItem.setQuantity(newItem.getQuantity());
        return itemRepository.save(oldItem);
    }

    /**
     * Remove item from cart
     * @param id of item
     */
    @DeleteMapping("/delete/{id}")
    public void removeItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }
}
