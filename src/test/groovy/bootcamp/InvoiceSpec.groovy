//package bootcamp;
//
//import bootcamp.model.finance.Finance
//import bootcamp.model.invoice.Invoice
//import bootcamp.model.invoice.InvoiceItem
//import bootcamp.model.products.Product
//import bootcamp.service.InvoiceService
//import spock.lang.Specification
//
//class InvoiceSpec extends Specification {
//
//    def "remove money from total cash"(){
//        given:"the total amount of cash"
//        BigDecimal operatingCash = new BigDecimal(5000.00);
//        //Finance.operatingCash = 5000.00;
//
//        Finance finance = new Finance();
//
//        and: "an invoice"
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
//        when:"an invoice is paid for"
//        InvoiceService invoiceService = new InvoiceService();
//        invoiceService.finance = finance;
//        BigDecimal invoiceCost = invoiceService.payInvoice(invoice);
//        BigDecimal newOperatingCash = operatingCash.subtract(invoiceCost);
//
//        then:"total amount of cash paid in the invoice is removed from the operating cash"
//        //it should cost $15
//        newOperatingCash == new BigDecimal(4985);
//
//    }
//
//}