package bootcamp.model.products;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Price {
    public BigDecimal calculateOurPrice(BigDecimal wholesalePrice){
    	double wholesale = wholesalePrice.doubleValue();
    	double ourPrice = wholesale + (wholesale*0.1);
        return BigDecimal.valueOf(ourPrice);
    }
    
    
    //THIS IS A NEW METHOD
    //add 10% to new price, if updated price <= do not update pricing
}
