package bootcamp

import bootcamp.model.invoice.InvoiceList
import spock.lang.Specification


class InvoiceIdSpec extends Specification {

    def "testing invoiceId creation"(){
        given: "an invoice list class"
        InvoiceList invoice = new InvoiceList();

        when: "invoice Id is created"
        int result = invoice.invoiceIdCounter();

        then: "result is equal to 1"
        result == 1;
    }

    def "testing invoiceId creation with previous ids created"(){
        given: "an invoice class and two ids created"
        InvoiceList invoice = new InvoiceList();
        invoice.invoiceIdCounter();
        invoice.invoiceIdCounter();


        when: "invoice Id is created for 3rd time"
        int result = invoice.invoiceIdCounter();

        then: "result is equal to 1"
        result == 3;
    }
}