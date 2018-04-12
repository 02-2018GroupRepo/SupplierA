package bootcamp.service;

import bootcamp.model.InvoiceList;
import bootcamp.model.Payment;
import bootcamp.model.finance.Finance;
import bootcamp.model.invoice.Invoice;
import bootcamp.model.invoice.InvoiceItem;
import bootcamp.model.order.Order;
import bootcamp.model.products.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;

@Component
public class InvoiceService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Finance finance;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private InvoiceList invoiceList;

    public BigDecimal payInvoice(Invoice invoice){
        BigDecimal invoiceTotal = getInvoiceTotal(invoice);
        finance.setOperatingCash(finance.getOperatingCash().subtract(invoiceTotal));
        return invoiceTotal;
    }


    public Invoice createInvoice(Order order){
        int invoiceId = invoiceList.invoiceIdCounter();
        int count = order.getQuantity();
        Product product = productService.getProductById(order.getId());
        Invoice invoice = new Invoice(invoiceId, product, count);
        invoiceList.addInvoiceToList(invoice);
        inventoryService.removeFromInventory(order);
        return invoice;
    }

    public Boolean checkPayment (Payment payment){
        double paymentFromVendor = payment.getPaymentForProduct().doubleValue();
        int invoiceId = payment.getInvoiceId();
        BigDecimal invoiceTotal = invoiceList.getInvoiceTotalById(invoiceId);
        double invoicePrice = invoiceTotal.doubleValue();
//        BigDecimal invoicePayment = invoiceList.getInvoiceTotalById(invoiceId);

        if(paymentFromVendor >= invoicePrice){
            addMoneyToOperatingCash(BigDecimal.valueOf(paymentFromVendor));
            return true;
        }else{
        	//quick fix for stock test
            addMoneyToOperatingCash(BigDecimal.valueOf(paymentFromVendor));

            return false;
        }
    }

    public void addMoneyToOperatingCash(BigDecimal cashToAdd){
        finance.setOperatingCash(finance.getOperatingCash().add(cashToAdd));
    }

    public boolean isPaymentCorrect(BigDecimal payment, Invoice invoice){
        BigDecimal invoiceTotal =  getInvoiceTotal(invoice);
        return invoiceTotal.equals(payment);
    }

    public BigDecimal getInvoiceTotal(Invoice invoice){
        //BigDecimal invoiceTotal = new BigDecimal(0.00);
        double invoiceTotal = 0;
        for(InvoiceItem item : invoice.getItems()){
            log.info("invoice price = " + item.getProduct().getWholesale_price());
            log.info("invoice product = " + item.getProduct());

            invoiceTotal += item.getCount() * item.getProduct().getWholesale_price().doubleValue();
            log.info("invoice total = " + invoiceTotal);
        }
        return new BigDecimal(invoiceTotal);
    }

}
