package business.entities;

public class Item {
    private int item_id;
    private String item_name;
    private String item_description;
    private String item_type;
    private int room_number;

    public Item(String item_name, String item_description, String item_type, int room_number) {
        this.item_name = item_name;
        this.item_description = item_description;
        this.item_type = item_type;
        this.room_number = room_number;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }
}
