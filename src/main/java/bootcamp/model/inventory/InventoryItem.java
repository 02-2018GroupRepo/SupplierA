package bootcamp.model.inventory;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InventoryItem {

    int id;
    int number_available;
    BigDecimal our_price;

    public InventoryItem(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber_available() {
        return number_available;
    }

    public void setNumber_available(int number_available) {
        this.number_available = number_available;
    }

    public BigDecimal getOur_price() {
        return our_price;
    }

    public void setOur_price(BigDecimal our_price) {
        this.our_price = our_price;
    }


}
