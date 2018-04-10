package bootcamp.model.inventory;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Inventory {

    int id;
    List<InventoryItem> items;

    public Inventory(List<InventoryItem> items){
        this.items = items;
    }

    public List<InventoryItem> getItems() {
        return items;
    }

    public void setItems(List<InventoryItem> items) {
        this.items = items;
    }
}
