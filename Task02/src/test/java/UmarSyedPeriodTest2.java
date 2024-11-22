import cm.Period;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UmarSyedPeriodTest2 {

    @Test
    public void testPeriodConstructorCreatesObject() {

        Period period = new Period(8, 12);
        assertNotNull(period, "The org.example.Period object should not be null when valid inputs are provided.");
    }
    @Test
    public void testPeriodConstructorEndTimeIsLessThanStartTime(){


        assertThrows(IllegalArgumentException.class, () -> {
            Period period = new Period(12,8);
        }, "Expected constructor to throw IllegalArgumentException for invalid period.");
    }
    @Test
    public void testPeriodConstructorEndTimeIsEqualToStartTime(){


        assertThrows(IllegalArgumentException.class, () -> {
            Period period = new Period(12,12);
        }, "Expected constructor to throw IllegalArgumentException for invalid period.");
    }
    @Test
    public void testPeriodConstructorWhenStartTimeIsLessThanZero(){


        assertThrows(IllegalArgumentException.class, () -> {
            Period period = new Period(-1,12);
        }, "Expected constructor to throw IllegalArgumentException for invalid period.");
    }
    @Test
    public void testPeriodConstructorWhenStartTimeEqualsZero() {

        Period period = new Period(0, 12);
        assertNotNull(period, "The org.example.Period object should not be null when valid inputs are provided.");
    }
    @Test
    public void testPeriodWithStartTimeGreaterThanZero() {

        Period period = new Period(8, 12);
        assertNotNull(period, "The org.example.Period object should not be null when valid inputs are provided.");
    }
    @Test
    public void testPeriodConstructorWhenEndTimeIsGreaterThanTwentyFour(){


        assertThrows(IllegalArgumentException.class, () -> {
            Period period = new Period(10,25);
        }, "Expected constructor to throw IllegalArgumentException for invalid period.");
    }
    @Test
    public void testPeriodConstructorWhereEndTimeEqualsTwentyFour() {

        Period period = new Period(0, 24);
        assertNotNull(period, "The org.example.Period object should not be null when valid inputs are provided.");
    }
    @Test
    public void testPeriodConstructorWhereEndTimeIsLessThanTwentyFour() {

        Period period = new Period(8, 19);
        assertNotNull(period, "The org.example.Period object should not be null when valid inputs are provided.");
    }
    @Test
    public void testPeriodDuration() {
        // Create a period with start time 8 and end time 12
        Period period = new Period(8, 12);

        // Check that the duration is correctly calculated (12 - 8 = 4)
        assertEquals(4, period.duration(), "The duration should be 4 hours.");
    }
    @Test
    public void testPeriodDurationStartOfDay() {
        // Create a period with start time 8 and end time 12
        Period period = new Period(0, 1);

        // Check that the duration is correctly calculated (12 - 8 = 4)
        assertEquals(1, period.duration(), "The duration should be 1 hour.");
    }
    @Test
    public void testPeriodDurationEndOfDay() {
        // Create a period with start time 8 and end time 12
        Period period = new Period(23, 24);

        // Check that the duration is correctly calculated (12 - 8 = 4)
        assertEquals(1, period.duration(), "The duration should be 1 hour.");
    }
    @Test
    public void testPeriodDurationMaximum() {
        // Create a period with start time 8 and end time 12
        Period period = new Period(0, 24);

        // Check that the duration is correctly calculated (12 - 8 = 4)
        assertEquals(24, period.duration(), "The duration should be 24 hours.");
    }
    @Test
    public void testPeriodDurationMinimum() {
        // Create a period with start time 8 and end time 12
        Period period = new Period(0, 1);

        // Check that the duration is correctly calculated (12 - 8 = 4)
        assertEquals(1, period.duration(), "The duration should be 1 hour.");
    }
    @Test
    public void testPeriodsOverlap() {

        Period period1 = new Period(8, 12);
        Period period2 = new Period(10, 14);

        assertTrue(period1.overlaps(period2), "The periods overlap.");
    }
    @Test
    public void testPeriodsDoNotOverlap() {

        Period period1 = new Period(8, 12);
        Period period2 = new Period(13, 15);

        assertFalse(period1.overlaps(period2), "The periods should not overlap.");
    }
    @Test
    public void testPeriodsHaveSameTime() {

        Period period1 = new Period(8, 12);
        Period period2 = new Period(8, 12);

        assertTrue(period1.overlaps(period2), "The periods overlap.");
    }
    @Test
    public void testPeriodsWhereBothArgumentsAreTrue() {

        Period period1 = new Period(8, 12);
        Period period2 = new Period(5, 7);

        assertFalse(period1.overlaps(period2), "The periods should not overlap.");
    }
}

