package bootcamp.model.invoice;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Invoice {


	int id = 0;
	List<InvoiceItem> items;

	public Invoice(){}



	public int getId() {
		return id;
	}

	public List<InvoiceItem> getItems() {
		return items;
	}

	public Invoice(int id, List<InvoiceItem> items){
		//Does operating cash need to be set here?
		this.id = id;
		this.items = items;

	}


}
