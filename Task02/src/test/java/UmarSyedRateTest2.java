import cm.CarParkKind;
import cm.Period;
import cm.Rate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class UmarSyedRateTest2 {
    @Test
    public void testConstructorCreatesValidRateObject() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(7, 10));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        // Create org.example.Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The org.example.Rate object should not be null when valid inputs are provided.");
    }
    @Test
    public void testConstructorWithVisitor() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.VISITOR;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(7, 10));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        // Create org.example.Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The org.example.Rate object should not be null when valid inputs are provided.");
    }
    @Test
    public void testConstructorWithStaff() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(7, 10));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        // Create org.example.Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The org.example.Rate object should not be null when valid inputs are provided.");
    }
    @Test
    public void testConstructorWithManagement() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(7, 10));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        // Create org.example.Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The org.example.Rate object should not be null when valid inputs are provided.");
    }
    @Test
    public void testConstructorWithStudent() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(7, 10));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        // Create org.example.Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The org.example.Rate object should not be null when valid inputs are provided.");
    }
    @Test
    public void testConstructorWithCollectionOfPeriodsNoOverlapping() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        // Create org.example.Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The org.example.Rate object should not be null when valid inputs are provided.");
    }
    @Test
    public void testConstructorWithReducedRateEqualsNormalRate() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("5.00");

        // Create org.example.Rate object using the constructor

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        }, "An IllegalArgumentException should be thrown for an invalid reducedRate.");
    }
    @Test
    public void testConstructorWithReducedRateGreaterThanZero() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("1.00");

        // Create org.example.Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The org.example.Rate object should not be null when valid inputs are provided.");
    }
    @Test
    public void testConstructorWithReducedRateEqualsZero() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("0");

        // Check that the constructor throws an IllegalArgumentException
        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The org.example.Rate object should not be null when valid inputs are provided.");
    }
    @Test
    public void testConstructorWithReducedRateIsLessThanZero() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("-1.00");

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        }, "An IllegalArgumentException should be thrown for an invalid reducedRate.");
    }
    @Test
    public void testConstructorWithNormalRateIsGreaterThanTen() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("11.00");
        BigDecimal reducedRate = new BigDecimal("5.00");

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        }, "An IllegalArgumentException should be thrown for an invalid NormalRate.");
    }
    @Test
    public void testConstructorWithNormalRateIsEqualToZero() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("0.00");
        BigDecimal reducedRate = new BigDecimal("2.00");

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        }, "An IllegalArgumentException should be thrown for an invalid NormalRate.");
    }
    @Test
    public void testConstructorWithNormalRateIsLessThanZero() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("-1.00");
        BigDecimal reducedRate = new BigDecimal("2.00");

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        }, "An IllegalArgumentException should be thrown for an invalid NormalRate.");
    }
    @Test
    public void testConstructorWithNormalPeriodsOverlapping() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(11, 14));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.00");

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        }, "An IllegalArgumentException should be thrown for an invalid NormalRate.");
    }
    @Test
    public void testConstructorWithReducedPeriodsOverlapping() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(3,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.00");

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        }, "An IllegalArgumentException should be thrown for an invalid reducedRate.");
    }
    @Test
    public void testConstructorWithReducedRateIsGreaterThanNormalRate() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(3,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("2.00");
        BigDecimal reducedRate = new BigDecimal("5.00");

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        }, "An IllegalArgumentException should be thrown for an invalid reducedRate.");
    }
    @Test
    public void testConstructorWithReducedPeriodOverlapsNormalPeriod() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,11));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.00");

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        }, "An IllegalArgumentException should be thrown for an normal period overlapping reduced period");
    }
    //New test cases
    @Test
    public void testConstructorWithReducedRateIsNull() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("-1.00");
        BigDecimal reducedRate = null;

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, normalRate, null);
        }, "An IllegalArgumentException should be thrown for an invalid reducedRate.");
    }
    @Test
    public void testConstructorWithNormalRateIsNull() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = null;
        BigDecimal reducedRate = new BigDecimal("3.00");

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, null, null);
        }, "An IllegalArgumentException should be thrown for an invalid reducedRate.");
    }
    @Test
    public void testConstructorWithReducedRateAndNormalRateIsNull() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = null;
        BigDecimal reducedRate = null;

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, null, null);
        }, "An IllegalArgumentException should be thrown for an invalid reducedRate.");
    }

    @Test
    public void testConstructorWithReducedPeriodEqualsNull() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = null;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.00");

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, null, normalPeriods,normalRate,reducedRate);
        }, "An IllegalArgumentException should be thrown for an invalid reducedPeriod.");
    }
    @Test
    public void testConstructorWithNormalPeriodEqualsNull() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,7));
        ArrayList<Period> normalPeriods = null;


        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.00");

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, null,normalRate,reducedRate);
        }, "An IllegalArgumentException should be thrown for an invalid reducedPeriod.");
    }
    @Test
    public void testConstructorWithReducedPeriodAndNormalPeriodEqualsNull() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = null;

        ArrayList<Period> normalPeriods = null;


        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.00");

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, null, null,normalRate,reducedRate);
        }, "An IllegalArgumentException should be thrown for an invalid reducedPeriod.");
    }
    @Test
    public void testCalculateWithNormalRatesOnly() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period stayPeriod = new Period(8, 12);
        BigDecimal expectedCharge = new BigDecimal("20.00");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "Charge should be calculated based on normal rates only.");
    }
    @Test
    public void testCalculateWithReducedAndNormal() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.00");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period stayPeriod = new Period(3, 10);
        BigDecimal expectedCharge = new BigDecimal("23.00");
        BigDecimal actualCharge = rate.calculate(stayPeriod);
        assertEquals(expectedCharge, actualCharge, "Charge should be calculated based on reduced and normal rates.");
    }
    @Test
    public void testCalculateWithNormalRatesAndFree() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period stayPeriod = new Period(13, 18);
        BigDecimal expectedCharge = new BigDecimal("20.00");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "Charge should be calculated based on normal and free rates only.");
    }
    @Test
    public void testCalculateWithReducedRatesAndFree() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period stayPeriod = new Period(4,6);
        BigDecimal expectedCharge = new BigDecimal("2.50");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "Charge should be calculated based on reduced and free rates only.");
    }
    @Test
    public void testCalculateWithFree() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));
        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period stayPeriod = new Period(5,7);
        BigDecimal expectedCharge = new BigDecimal("0.00");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "Charge should be calculated based on reduced and free rates only.");
    }
    //new test cases
    @Test
    public void testCalculateWithReducedRatesAndNormalRates() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(5, 17));
        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period stayPeriod = new Period(4,6);
        BigDecimal expectedCharge = new BigDecimal("7.50");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "Charge should be calculated based on reduced and free rates only.");
    }
    @Test
    public void testCalculateWithCarParkKindEqualsVisitor() {
        CarParkKind kind = CarParkKind.VISITOR;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0, 5));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(5, 17));
        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period stayPeriod = new Period(4,6);
        BigDecimal expectedCharge = new BigDecimal("0");
        BigDecimal actualCharge = rate.calculate(stayPeriod);

        assertEquals(expectedCharge, actualCharge, "Charge should be calculated based on reduced and free rates only.");
    }

}
