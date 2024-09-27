package lvn.ecommerce.service;

import lvn.ecommerce.entity.User;

public interface UserService {
    User save(User user);
    User findById(Integer id);
    void deleteById(Integer id);
}
