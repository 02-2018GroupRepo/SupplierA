package bootcamp.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Price {
    public BigDecimal setOurPrice(BigDecimal wholesalePrice){
        return BigDecimal.valueOf(1.11);
    }

    //THIS IS A NEW METHOD
    //add 10% to new price, if updated price <= do not update pricing
}
