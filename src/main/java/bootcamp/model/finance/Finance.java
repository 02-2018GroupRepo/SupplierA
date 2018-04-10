package bootcamp.model.finance;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Finance {

    private BigDecimal operatingCash = new BigDecimal("5000.00");

    public Finance(){

    }

    public BigDecimal getOperatingCash() {
        return this.operatingCash;
    }

    public void setOperatingCash(BigDecimal operatingCash) {
        this.operatingCash = operatingCash;
    }
}
