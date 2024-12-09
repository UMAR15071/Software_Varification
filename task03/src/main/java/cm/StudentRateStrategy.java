package cm;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StudentRateStrategy implements RateCalculationStrategy {
    @Override
    public BigDecimal calculate(BigDecimal total) {
        if (total.compareTo(BigDecimal.valueOf(5.50)) > 0) {
            BigDecimal discount = total.multiply(BigDecimal.valueOf(0.25));
            total = total.subtract(discount);
        }
        return total.setScale(2, RoundingMode.HALF_UP);
    }
}

