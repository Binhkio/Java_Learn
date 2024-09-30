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

@RequestMapping("/api/v1/item")
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    /**
     * Add an item into user's cart
     * @param pId Product ID
     * @param quantity Quantity
     */
    @PostMapping("/add")
    public Item addItem(@RequestParam Long pId, @RequestParam(defaultValue = "1") int quantity, Authentication authentication) {
        User u = (User) authentication.getPrincipal();
        User user = userService.findById(u.getId());
        Product product = productService.findById(pId);
        Cart cart = cartService.findById(user.getCart().getId());
        Item newItem = new Item();
        newItem.setProduct(product);
        newItem.setQuantity(quantity);
        newItem.setCart(cart);
        return itemService.save(newItem);
    }

    /**
     * Update item status
     * @param newItem New item
     */
    @PutMapping("/update")
    public Item updateItem(@RequestBody Item newItem) {
        Item oldItem = itemService.findById(newItem.getId());
        oldItem.setQuantity(newItem.getQuantity());
        return itemService.save(oldItem);
    }

    /**
     * Remove item from cart
     * @param id of item
     */
    @DeleteMapping("/delete/{id}")
    public void removeItem(@PathVariable Long id) {
        itemService.deleteById(id);
    }
}
