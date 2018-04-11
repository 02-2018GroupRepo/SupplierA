package bootcamp.service;

import bootcamp.model.finance.Finance;
import bootcamp.model.invoice.Invoice;
import bootcamp.model.invoice.InvoiceItem;
import bootcamp.model.order.Order;
import bootcamp.model.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;

@Component
public class InvoiceService {

    @Autowired
    private Finance finance;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ProductService productService;

    public BigDecimal payInvoice(Invoice invoice){
        BigDecimal invoiceTotal = new BigDecimal(0.00);
        for(InvoiceItem item : invoice.getItems()){
            BigDecimal bigCount = new BigDecimal(item.getCount());
            invoiceTotal = invoiceTotal.add(item.getProduct().getWholesale_price().multiply(bigCount)); //addition between invoicetotal and the price of each item
        }
        finance.setOperatingCash(finance.getOperatingCash().subtract(invoiceTotal));
        return invoiceTotal;
    }


    public InvoiceItem createInvoice(Order order){
        int count = order.getQuantity();
        Product product = productService.getProductById(order.getId());
        InvoiceItem invoice = new InvoiceItem(product, count);
        return invoice;
    }
    public void addMoneyToOperatingCash(BigDecimal cashToAdd){
        finance.setOperatingCash(finance.getOperatingCash().add(cashToAdd));
    }
}
