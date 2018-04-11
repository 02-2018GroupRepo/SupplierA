package bootcamp.model;

import bootcamp.model.invoice.InvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class InvoiceList {


    private int invoiceIdTracker;

    private List<InvoiceItem> list;

    public int invoiceIdCounter(){
        int newInvoiceId = this.invoiceIdTracker + 1;
        this.invoiceIdTracker = newInvoiceId;
        return newInvoiceId;
    }

    public void addInvoiceToList(InvoiceItem item){
        list.add(item);
    }

//    public BigDecimal getInvoiceTotalById(int invoiceId){
//        for(InvoiceItem item: list){
//            if(invoiceId == item.getInvoiceId()){
//                BigDecimalitem.getProduct().getRetail_price()
//            }
//        }
//
//        return
//    }
}
