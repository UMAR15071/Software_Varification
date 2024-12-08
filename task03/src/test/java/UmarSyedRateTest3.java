import cm.CarParkKind;
import cm.Period;
import cm.Rate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class UmarSyedRateTest3 {

    @Test
    public void testCalculateWithVisitorChargeLessThanTen() {
        CarParkKind kind = CarParkKind.VISITOR;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("4.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period stayPeriod = new Period(10, 12);
        BigDecimal expectedCharge = new BigDecimal("0");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "less tha 10 charge should be zero");
    }
    @Test
    public void testCalculateWithVisitorChargeEqualsToTen() {
        CarParkKind kind = CarParkKind.VISITOR;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period stayPeriod = new Period(10, 12);
        BigDecimal expectedCharge = new BigDecimal("0");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "If charge equals 10 it should be zero for visitor");
    }
    @Test
    public void testCalculateWithVisitorChargeGreaterThanTen() {
        CarParkKind kind = CarParkKind.VISITOR;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("5.00");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period stayPeriod = new Period(10, 14);
        BigDecimal expectedCharge = new BigDecimal("2.50");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "If charge is greater than 10 there should be a 50 percent discount on anything above 10");
    }

}
