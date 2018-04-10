package bootcamp.controller;


import bootcamp.model.invoice.InvoiceItem;
import bootcamp.model.order.Order;
import bootcamp.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private InvoiceService invoiceService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

        @RequestMapping(value = "/order", method= RequestMethod.POST)
        public InvoiceItem receiveOrder(@RequestBody Order order) {
            log.debug("Receiving orders");
            return invoiceService.createInvoice(order);
        }

        // used for testing with order json format
//        @RequestMapping(name = "/getorder")
//        public Order getOrder(){
//            Order order = new Order();
//            order.setId(1);
//            order.setQuantity(2);
//            return order;
//
//    }


}
