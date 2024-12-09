package cm;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VisitorRateStrategy implements RateCalculationStrategy {
    @Override
    public BigDecimal calculate(BigDecimal total) {
        if (total.compareTo(BigDecimal.valueOf(10)) <= 0) {
            return BigDecimal.ZERO;
        } else {
            BigDecimal amountAboveTen = total.subtract(BigDecimal.valueOf(10));
            BigDecimal discount = amountAboveTen.multiply(BigDecimal.valueOf(0.5));
            return amountAboveTen.subtract(discount).setScale(2, RoundingMode.HALF_UP);
        }
    }
}

