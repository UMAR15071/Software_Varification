import cm.*;
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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate, new VisitorRateStrategy());

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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate, new VisitorRateStrategy());

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
        BigDecimal reducedRate = new BigDecimal("4.00");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate, new VisitorRateStrategy());

        Period stayPeriod = new Period(10, 14);
        BigDecimal expectedCharge = new BigDecimal("5.00");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "If charge is greater than 10 there should be a 50 percent discount on anything above 10");
    }
    @Test
    public void testCalculateWhereManagementIsLessThanFour() {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("3.00");
        BigDecimal reducedRate = new BigDecimal("2.00");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate, new ManagementRateStrategy());

        Period stayPeriod = new Period(10, 11);
        BigDecimal expectedCharge = new BigDecimal("4.00");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "Minimum payable amount for management is four");
    }
    @Test
    public void testCalculateWhereManagementIsEqualsToFour() {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("4.00");
        BigDecimal reducedRate = new BigDecimal("3.00");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate, new ManagementRateStrategy());

        Period stayPeriod = new Period(10, 11);
        BigDecimal expectedCharge = new BigDecimal("4.00");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "Minimum payable amount for management is four");
    }
    @Test
    public void testCalculateWhereManagementIsGreaterThanFour() {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.00");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate, new ManagementRateStrategy());

        Period stayPeriod = new Period(10, 11);
        BigDecimal expectedCharge = new BigDecimal("5.00");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "Minimum payable amount for management is four");
    }
    @Test
    public void testCalculateWhereStudentDiscountIsLessThanFiveEuroFiftyCents() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("2.50");
        BigDecimal reducedRate = new BigDecimal("2.00");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate, new StudentRateStrategy());

        Period stayPeriod = new Period(10, 12);
        BigDecimal expectedCharge = new BigDecimal("5.00");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "25 percent discount for student above 5.50");
    }
    @Test
    public void testCalculateWhereStudentDiscountIsEqualToFiveEuroFiftyCents() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("2.75");
        BigDecimal reducedRate = new BigDecimal("2.00");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate, new StudentRateStrategy());

        Period stayPeriod = new Period(10, 12);
        BigDecimal expectedCharge = new BigDecimal("5.50");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "25 percent discount for student above 5.50");
    }
    @Test
    public void testCalculateWhereStudentDiscountIsGreaterThanFiveEuroFiftyCents() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("2.50");
        BigDecimal reducedRate = new BigDecimal("2.00");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate, new StudentRateStrategy());

        Period stayPeriod = new Period(10, 14);
        BigDecimal expectedCharge = new BigDecimal("7.50");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "25 percent discount for student above 5.50");
    }

    @Test
    public void testCalculateWhereStaffIsLessThanSixteen() {
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("3.00");
        BigDecimal reducedRate = new BigDecimal("2.00");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate, new StaffRateStrategy());

        Period stayPeriod = new Period(10, 11);
        BigDecimal expectedCharge = new BigDecimal("16.00");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "Minimum payable amount for staff is 16");
    }
    @Test
    public void testCalculateWhereStudentIsEqualsToSixteen() {
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("4.00");
        BigDecimal reducedRate = new BigDecimal("3.00");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate, new StaffRateStrategy());

        Period stayPeriod = new Period(10, 14);
        BigDecimal expectedCharge = new BigDecimal("16.00");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "Minimum payable amount for staff is 16");
    }
    @Test
    public void testCalculateWhereStudentIsGreaterThanSixteen() {
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.00");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate, new StaffRateStrategy());

        Period stayPeriod = new Period(10, 14);
        BigDecimal expectedCharge = new BigDecimal("20.00");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "Minimum payable amount for staff is 16");
    }

}
