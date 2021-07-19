package business.persistence;

import business.entities.Item;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemMapper {
    Database database;

    public ItemMapper(Database database){
        this.database = database;
    }

    public List<Item> listOfItems() throws UserException {
        List<Item> itemList = new ArrayList<>();
        try (Connection connection = database.connect()){
            String sql = "SELECT * FROM item";

            try (PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int itemId = rs.getInt("item_id");
                    String itemName = rs.getString("item_name");
                    String itemDescription = rs.getString("item_description");
                    String itemType = rs.getString("item_type");
                    int roomNumber = rs.getInt("fk_room_number");

                    Item item = new Item(itemName,itemDescription, itemType, roomNumber);
                    item.setItem_id(itemId);
                    itemList.add(item);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return itemList;
    }
}
