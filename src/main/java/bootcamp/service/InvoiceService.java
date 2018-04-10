package bootcamp.service;

import bootcamp.model.finance.Finance;
import bootcamp.model.invoice.Invoice;
import bootcamp.model.invoice.InvoiceItem;
import bootcamp.model.order.Order;
import bootcamp.model.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;

//@Service//Component?
@Component
public class InvoiceService {

    @Autowired
    private Finance finance;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ProductService productService;
//    private Finance finance = new Finance();

    public BigDecimal payInvoice(Invoice invoice){

        BigDecimal invoiceTotal = new BigDecimal(0.00);

        for(InvoiceItem item : invoice.getItems()){
            BigDecimal bigCount = new BigDecimal(item.getCount());
            invoiceTotal = invoiceTotal.add(item.getProduct().getWholesale_price().multiply(bigCount)); //addition between invoicetotal and the price of each item
        }

        //subtract invoicetotal from opperatingcash
//        BigDecimal gb = finance.getOperatingCash();
//        finance.setOperatingCash(finance.getOperatingCash().subtract(invoiceTotal));
//        finance.setOperatingCash(gb);
        System.out.println(finance.getOperatingCash());
        return invoiceTotal;
    }


    public InvoiceItem createInvoice(Order order){
        int count = order.getQuantity();
        Product product = productService.getProductById(order.getId());
        InvoiceItem invoice = new InvoiceItem(product, count);
        return invoice;
    }
}
