package bootcamp

import bootcamp.model.finance.Finance
import bootcamp.service.InvoiceService
import spock.lang.Specification


class AddMoneySpec extends Specification {

    def "add money to total cash"(){
        given:"a total amount of cash"
        Finance finance = new Finance();
        when:"a payment collected from an invoice"
        InvoiceService invoiceService = new InvoiceService();
        invoiceService.finance = finance;
        invoiceService.addMoneyToOperatingCash(2.50)



        then:"collected money is added to total cash"
    finance.operatingCash == 5002.50;
    }

}