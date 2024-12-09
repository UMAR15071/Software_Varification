package cm;

import java.math.BigDecimal;

public interface RateCalculationStrategy {
    BigDecimal calculate(BigDecimal total);
}
