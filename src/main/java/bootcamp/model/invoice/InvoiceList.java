package bootcamp.model.invoice;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceList {


    private int invoiceIdCount;

    private List<Invoice> invoiceList = new ArrayList<>();

    public int invoiceIdCounter(){
        int newInvoiceId = this.invoiceIdCount + 1;
        this.invoiceIdCount = newInvoiceId;
        return newInvoiceId;
    }

    public void addInvoiceToList(Invoice item){
        invoiceList.add(item);
    }

    public BigDecimal getInvoiceTotalById(int invoiceId) {
        BigDecimal total = null;
        for (Invoice item : invoiceList) {
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
