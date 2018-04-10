package bootcamp.controller;

import java.util.List;

import bootcamp.model.invoice.InvoiceItem;
import bootcamp.model.order.Order;
import bootcamp.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import bootcamp.model.products.Product;
import bootcamp.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private InvoiceService invoice;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id) {
		log.debug("Retreiving product " + id);
    	return productService.getProductById(id); 
    }
	
//	@RequestMapping(name = "/order", method = RequestMethod.POST)
//	public InvoiceItem getProductList(@RequestBody Order order){
//		return invoice.createInvoice(order);
//		}
	
}

