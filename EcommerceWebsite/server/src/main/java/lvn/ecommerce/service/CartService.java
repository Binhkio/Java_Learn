package lvn.ecommerce.service;

import lvn.ecommerce.entity.Cart;

public interface CartService {
    Cart save(Cart cart);
    Cart findById(Long id);
}
