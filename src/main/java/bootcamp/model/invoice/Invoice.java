package bootcamp.model.invoice;

import bootcamp.model.products.Product;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Invoice {

	private int id;
	List<InvoiceItem> items;

	public int getId() {
		return id;
	}

	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}

	public Invoice(){}

	public List<InvoiceItem> getItems() {
		return items;
	}

	private int invoiceId;
	private Product product;
	private int count;



	public Invoice(int invoiceId, Product product, Integer count) {
		this.invoiceId = invoiceId;
		this.product = product;
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}


}
