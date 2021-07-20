package business.services;

import business.entities.Item;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.ItemMapper;

import java.util.List;

public class ItemFacade {
    ItemMapper itemMapper;

    public ItemFacade(Database database) {
        this.itemMapper = new ItemMapper(database);
    }

    public List<Item> listOfItems() throws UserException {
        return itemMapper.listOfItems();
    }
}
