package bootcamp.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Payment {

    private BigDecimal paymentForProduct;
    private int invoiceId;

    public BigDecimal getPaymentForProduct() {
        return paymentForProduct;
    }

    public void setPaymentForProduct(BigDecimal paymentForProduct) {
        this.paymentForProduct = paymentForProduct;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }
}
