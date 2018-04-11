//package bootcamp
//
//import bootcamp.model.invoice.Invoice
//import bootcamp.model.invoice.InvoiceItem
//import bootcamp.model.products.Product
//import bootcamp.service.InvoiceService
//import spock.lang.Specification
//
//class CheckPaymentSpec extends Specification {
//
//
//    def "Check that payment from Vendor is correct"(){
//        given: "An Invoice"
//        InvoiceService invoiceService = new InvoiceService();
//
//        //making a fake product
//        Product fakeProduct = new Product();
//        BigDecimal newValue = new BigDecimal(3) //each item costs $3
//        fakeProduct.setWholesale_price(newValue);
//
//        //making a fake invoiceitem list
//        InvoiceItem invoiceItem = new InvoiceItem(fakeProduct, 5); //There are 5 items
//        List<InvoiceItem> fakeListOfItems = new ArrayList<>();
//        fakeListOfItems.add(invoiceItem);
//
//        //making a fake invoice
//        Invoice invoice = new Invoice(1, fakeListOfItems);
//
//        and: "a payment"
//        BigDecimal payment = new BigDecimal("15");
//        when: "the payment is checked"
//        boolean result = invoiceService.isPaymentCorrect(payment, invoice);
//
//        then: "the check will return true if the payment is correct and false otherwise"
//        result.equals(true);
//
//    }
//}