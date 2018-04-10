package bootcamp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import bootcamp.dao.InventoryDao;
import bootcamp.dao.ProductDao;
import bootcamp.model.inventory.Inventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import bootcamp.model.products.Product;

@Component
public class InventoryService {
	
	@Autowired
	private InventoryDao inventoryDao;

	//we thought about creating a new class that would communicate to product service but in the interest of time
	//we created an instance of the product service class here
	@Autowired
	private ProductService productService;
//	private List<Product> inventoryList;
	private static final Logger log = LoggerFactory.getLogger(InventoryService.class);
	 
	 @Autowired
	 private SimpleDateFormat dateFormat;
	
	public void receiveInventory(List<Product> products) {
//		inventoryList.addAll(products);
		for(Product p: products){
			productService.updateProductWholesalePrice(p);
			int quantity = inventoryDao.getInventoryItemById(p).getNumber_available();
			if(quantity>0){
				inventoryDao.updateInventory(p, quantity);
			}else{
				inventoryDao.addInventory(p);
			}
		}
	}

	public Inventory getInventory(){
		return inventoryDao.getInventory();
	}
	
	@Scheduled(cron = "${inventory.status.schedule}")
    public void inventoryStatus() {
        log.info("Checking on inventory status at {}", dateFormat.format(new Date()));
        log.debug("Debug goes here");
    }
}
