import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RateTest {
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

        // Create Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The Rate object should not be null when valid inputs are provided.");
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

        // Create Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The Rate object should not be null when valid inputs are provided.");
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

        // Create Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The Rate object should not be null when valid inputs are provided.");
    }
    @Test
    public void testConstructorWithManager() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGER;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(7, 10));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        // Create Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The Rate object should not be null when valid inputs are provided.");
    }
    @Test
    public void testConstructorWithCollectionOfPeriodsNoOverlapping() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGER;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("2.50");

        // Create Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The Rate object should not be null when valid inputs are provided.");
    }
    @Test
    public void testConstructorWithReducedRateEqualsNormalRate() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGER;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("5.00");

        // Create Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The Rate object should not be null when valid inputs are provided.");
    }
    @Test
    public void testConstructorWithReducedRateGreaterThanZero() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGER;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("1.00");

        // Create Rate object using the constructor

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Check that the object is not null
        assertNotNull(rate, "The Rate object should not be null when valid inputs are provided.");
    }
    @Test
    public void testConstructorWithReducedRateEqualsZero() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGER;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(4,7));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 14));

        BigDecimal normalRate = new BigDecimal("5.00");
        BigDecimal reducedRate = new BigDecimal("0.00");

        // Check that the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        }, "An IllegalArgumentException should be thrown for an invalid reducedRate.");
    }
    @Test
    public void testConstructorWithReducedRateIsLessThanZero() {
        // Create valid inputs
        CarParkKind kind = CarParkKind.MANAGER;
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
        CarParkKind kind = CarParkKind.MANAGER;
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
        CarParkKind kind = CarParkKind.MANAGER;
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
        CarParkKind kind = CarParkKind.MANAGER;
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
        CarParkKind kind = CarParkKind.MANAGER;
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
        CarParkKind kind = CarParkKind.MANAGER;
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
        CarParkKind kind = CarParkKind.MANAGER;
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
        CarParkKind kind = CarParkKind.MANAGER;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(0,4));
        reducedPeriods.add(new Period(3,11));
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


}
