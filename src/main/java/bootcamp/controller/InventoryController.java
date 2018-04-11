package bootcamp.controller;

import java.util.List;

import bootcamp.model.inventory.Inventory;
import bootcamp.model.inventory.InventoryItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import bootcamp.model.products.Product;
import bootcamp.service.InventoryService;

@RestController
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("inventory/{id}")
	public InventoryItem showInventoryById(@PathVariable Integer id){
		return inventoryService.getInventoryItemById(id);
	}

	@RequestMapping("all/inventory")
	public Inventory showInventory(){
		return inventoryService.getInventory();
	}
	
	@RequestMapping(value = "/receive/inventory", method=RequestMethod.POST)
    public void getProduct(@RequestBody List<Product> products) {
		log.info("Receiving products");
//		log.info(products.toString());
    	inventoryService.receiveInventory(products); 
    }
	
}
