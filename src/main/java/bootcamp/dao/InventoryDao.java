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
        String sql = "SELECT * FROM INVENTORY where id = " + product.getId() ;
        System.out.println(sql);
        List<InventoryItem> item =jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(InventoryItem.class));
        return item.get(0);
    }

    public Inventory getInventory(){
        String sql = "SELECT * FROM INVENTORY" ;
        List<InventoryItem> inventoryList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(InventoryItem.class));
        inventory = new Inventory(inventoryList);
        return inventory;
    }

    public InventoryItem getInventoryItemById(Integer id){
        String sql = "SELECT * FROM INVENTORY where id = " + id;
        List<InventoryItem> item = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(InventoryItem.class));
        return item.get(0);
    }

    public void updateInventory(Product product, int numberAvailable) {
        //todo add new our price method
        //ourPrice = price.setOurPrice(product.getWholesale_price()); ///this needs to be changed

        String sql = "update INVENTORY set number_available = " + numberAvailable + "where id = " + product.getId();
        jdbcTemplate.update(sql);
        //return ourPrice; // this needs to be changed
    }

    public BigDecimal addInventory(Product product){
        ourPrice = price.setOurPrice(product.getWholesale_price());
        String sql = "INSERT into INVENTORY values (?,?,?)";
        jdbcTemplate.update(sql, new Object[] {product.getId(), 1, ourPrice});
        return ourPrice;
    }
    
    public void removeFromInventory(int id, int quantity) {
    	 String sql = "update INVENTORY set number_available = " + quantity + "where id = " + id;
         jdbcTemplate.update(sql);
    	
    }
}

