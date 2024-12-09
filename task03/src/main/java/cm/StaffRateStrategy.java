package cm;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StaffRateStrategy implements RateCalculationStrategy {
    @Override
    public BigDecimal calculate(BigDecimal total) {
        if (total.compareTo(BigDecimal.valueOf(16.00)) < 0) {
            return BigDecimal.valueOf(16.00).setScale(2, RoundingMode.HALF_UP);
        }
        return total.setScale(2, RoundingMode.HALF_UP);
    }
}

