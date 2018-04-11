//package bootcamp
//
//import bootcamp.model.InvoiceList
//import bootcamp.model.invoice.InvoiceItem
//import bootcamp.model.order.Order
//import bootcamp.model.products.Product
//import bootcamp.service.InvoiceService
//import bootcamp.service.ProductService
//import spock.lang.Specification
//
//
//class InvoiceServiceSpec extends Specification {
//
//    def "testing creating an invoice"(){
//        given: " an invoice service class"
//        InvoiceService service = new InvoiceService();
//
//        Product product = new Product ()
//        product.setId(1);
//        product.setName("Cola");
//
//        and: "an order object"
//        Order order = new Order();
//        order.setId(1);
//        order.setQuantity(2);
//
//        and:"a product service and invoice list"
//        ProductService p = Stub(ProductService.class)
//        p = service.productService
//        p.getProductById(1) >> product;
//
//        InvoiceList l = Stub(InvoiceList.class)
//        l = service.invoiceList;
//        l.invoiceIdCounter() >> 1;
//
//        when: "an invoice is create"
//        InvoiceItem item = service.createInvoice(order);
//
//        then: "an invoice is created with the given attributes"
//        item.getCount() == 2;
//        item.getProduct().getName().equals("Cola");
//        item.getInvoiceId() == 1;
//    }
//
//}