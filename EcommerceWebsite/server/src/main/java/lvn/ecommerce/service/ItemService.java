package lvn.ecommerce.service;

import lvn.ecommerce.entity.Item;

import java.util.List;

public interface ItemService {
    Item save(Item item);
    Item findById(Long id);
    public List<Item> listAllItems();
    void deleteById(Long id);
}
