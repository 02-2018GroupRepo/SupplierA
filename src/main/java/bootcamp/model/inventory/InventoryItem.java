package bootcamp.model.inventory;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InventoryItem {

    int id;
    int number_available;
    BigDecimal retail_price;

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

    public BigDecimal getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(BigDecimal retail_price) {
        this.retail_price = retail_price;
    }


}
