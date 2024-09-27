package lvn.ecommerce.impl;

import lvn.ecommerce.entity.Cart;
import lvn.ecommerce.repository.CartRepository;
import lvn.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart save(Cart cart) { return this.cartRepository.save(cart); }

    @Override
    public Cart findById(Long id) {
        return this.cartRepository.findById(id).orElse(null);
    }
}
