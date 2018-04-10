package bootcamp.dao;

import bootcamp.model.Price;
import bootcamp.model.inventory.Inventory;
import bootcamp.model.inventory.InventoryItem;
import bootcamp.model.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class InventoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Price price = new Price();

    @Autowired
    private Inventory inventory;

    private BigDecimal ourPrice;

    public InventoryItem getInventoryItemById(Product product){
        String sql = "SELECT number_available FROM INVENTORY where id = ?" ;
        int id = product.getId();
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(InventoryItem.class));
    }

    public Inventory getInventory(){
        String sql = "SELECT * FROM INVENTORY";
        List<InventoryItem> inventoryList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(InventoryItem.class));
        inventory = new Inventory(inventoryList);
        return inventory;
    }

    public void updateInventory(Product product, int numberAvailable) {
        //todo add new our price method
        String sql = "update INVENTORY set number_available = " + numberAvailable + "where id = " + product.getId();
        jdbcTemplate.update(sql);
    }

    public void addInventory(Product product){
        ourPrice = price.setOurPrice(product.getWholesale_price());
        String sql = "INSERT into INVENTORY values (?,?,?)";
        jdbcTemplate.update(sql, new Object[] {product.getId(), 1, ourPrice});
    }
}

