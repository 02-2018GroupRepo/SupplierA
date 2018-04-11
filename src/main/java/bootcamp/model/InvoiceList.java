package bootcamp.model;

import bootcamp.model.invoice.InvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceList {


    private int invoiceIdTracker;

    private List<InvoiceItem> invoiceList = new ArrayList<>();

    public int invoiceIdCounter(){
        int newInvoiceId = this.invoiceIdTracker + 1;
        this.invoiceIdTracker = newInvoiceId;
        return newInvoiceId;
    }

    public void addInvoiceToList(InvoiceItem item){
        invoiceList.add(item);
    }

    public BigDecimal getInvoiceTotalById(int invoiceId) {
        BigDecimal total = null;
        for (InvoiceItem item : invoiceList) {
            if (invoiceId == item.getInvoiceId()) {
                BigDecimal price = item.getProduct().getRetail_price();
//                double price = bd.doubleValue();
                int quantity = item.getCount();
                BigDecimal quant = new BigDecimal(quantity);
                total = price.multiply(quant);
//                BigDecimal totalPrice = new BigDecimal(total, MathContext.DECIMAL64);
            }
        }
        return total;
    }
}
