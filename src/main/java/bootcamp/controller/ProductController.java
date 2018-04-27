package bootcamp.controller;

import bootcamp.model.products.Product;
import bootcamp.service.InvoiceService;
import bootcamp.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private InvoiceService invoice;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/product/{id}")
    public List<Product> getProductById(@PathVariable Integer id) {
		List<Product> productList = new ArrayList<>();
		productList.add(productService.getProductById(id));
		productList.add(productService.getProductById(id));
		productList.add(productService.getProductById(id));
		productList.add(productService.getProductById(id));
		log.debug("Retreiving product " + id);
    	return productList;
    }
	
//	@RequestMapping(name = "/order", method = RequestMethod.POST)
//	public InvoiceItem getProductList(@RequestBody Order order){
//		return invoice.createInvoice(order);
//		}
	
}

