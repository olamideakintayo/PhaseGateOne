// MenstruationCycleTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenstruationCycleTest {

    @BeforeEach
    void clearList() {
        MenstruationCycle.cycleDetails.clear();
    }

    @Test
    void testThatAddSingleUser() {
        MenstruationCycle cycle = new MenstruationCycle("Marvellous", LocalDate.of(2024, 5, 1), LocalDate.of(2024, 5, 29), 5);
        MenstruationCycle.cycleDetails.add(cycle);
        assertEquals(1, MenstruationCycle.cycleDetails.size());
    }

   
    @Test
    void testThatChecksCycleLengthCalculation() {
        MenstruationCycle cycle = new MenstruationCycle("Ella", LocalDate.of(2024, 5, 1), LocalDate.of(2024, 5, 31), 6);
        long days = cycle.currentPeriodDate.toEpochDay() - cycle.previousPeriodDate.toEpochDay();
        assertEquals(30, days);
    }

    @Test
    void testThatChecksValidPeriodDuration() {
        MenstruationCycle cycle = new MenstruationCycle("Kemi", LocalDate.of(2024, 4, 10), LocalDate.of(2024, 5, 5), 4);
        assertTrue(cycle.periodDurationDays > 0);
    }

    @Test
    void testThatChecksInvalidCurrentBeforePrevious() {
        LocalDate previous = LocalDate.of(2024, 5, 10);
        LocalDate current = LocalDate.of(2024, 5, 5);
        assertTrue(current.isBefore(previous));
    }

    @Test
    void testThatChecksCycleLengthInNormalRange() {
        MenstruationCycle cycle = new MenstruationCycle("Nimi", LocalDate.of(2024, 5, 1), LocalDate.of(2024, 5, 28), 5);
        long length = cycle.currentPeriodDate.toEpochDay() - cycle.previousPeriodDate.toEpochDay();
        assertTrue(length >= 21 && length <= 35);
    }

    @Test
    void testThatChecksSafePeriodCalculation() {
        MenstruationCycle cycle = new MenstruationCycle("Nimi", LocalDate.of(2024, 5, 1), LocalDate.of(2024, 5, 28), 5);
        long cycleLength = cycle.currentPeriodDate.toEpochDay() - cycle.previousPeriodDate.toEpochDay();
        LocalDate ovulationDate = cycle.currentPeriodDate.plusDays(cycleLength - 14);
        LocalDate safeEnd = ovulationDate.minusDays(6); 
                assertTrue(safeEnd.isBefore(ovulationDate));
    }

    @Test
    void testThatAddsMultipleUsers() {
        MenstruationCycle.cycleDetails.add(new MenstruationCycle("User1", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 28), 5));
        MenstruationCycle.cycleDetails.add(new MenstruationCycle("User2", LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 27), 4));
        assertEquals(2, MenstruationCycle.cycleDetails.size());
    }

    @Test
    void testThatUpdatesUserPeriodDuration() {
        MenstruationCycle user = new MenstruationCycle("Nimi", LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 27), 5);
        MenstruationCycle.cycleDetails.add(user);
        user.periodDurationDays = 6;
        assertEquals(6, user.periodDurationDays);
    }

    @Test
    void testThatChecksPeriodPredictionDates() {
        MenstruationCycle user = new MenstruationCycle("Nimi", LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 28), 4);
        LocalDate next = user.currentPeriodDate;
        for (int i = 0; i < 5; i++) {
            next = next.plusDays(27);         }
        assertNotNull(next);
    }

    @Test
    void testThatChecksPMSRangeCalculation() {
        MenstruationCycle user = new MenstruationCycle("Ana", LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 28), 5);
        long length = ChronoUnit.DAYS.between(user.previousPeriodDate, user.currentPeriodDate);
        LocalDate pmsStart = user.currentPeriodDate.plusDays(length - 10);
        LocalDate pmsEnd = user.currentPeriodDate.plusDays(length - 1);
        assertTrue(pmsStart.isBefore(pmsEnd));
    }

    @Test
    void testThatChecksOvulationDateCalculation() {
        MenstruationCycle user = new MenstruationCycle("Kim", LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 29), 4);
        long cycleLength = ChronoUnit.DAYS.between(user.previousPeriodDate, user.currentPeriodDate);
        LocalDate ovulation = user.currentPeriodDate.plusDays(cycleLength - 14);
        assertNotNull(ovulation);
    }

    @Test
    void testThatChecksFertilityWindowStart() {
        MenstruationCycle user = new MenstruationCycle("Nimi", LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 28), 5);
        long cycleLength = ChronoUnit.DAYS.between(user.previousPeriodDate, user.currentPeriodDate);
        LocalDate ovulation = user.currentPeriodDate.plusDays(cycleLength - 14);
        LocalDate fertileStart = ovulation.minusDays(5);
        assertTrue(fertileStart.isBefore(ovulation));
    }

    @Test
    void testThatChecksSafePeriodEndAfterFertilityWindow() {
        MenstruationCycle user = new MenstruationCycle("Mira", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 29), 5);
        long length = ChronoUnit.DAYS.between(user.previousPeriodDate, user.currentPeriodDate);
        LocalDate ovulation = user.currentPeriodDate.plusDays(length - 14);
        LocalDate safeAfterEnd = user.currentPeriodDate.plusDays(length - 1);
        assertTrue(safeAfterEnd.isAfter(ovulation));
    }

    @Test
    void testThatChecksGetNameMethod() {
        MenstruationCycle user = new MenstruationCycle("Ella", LocalDate.of(2024, 4, 2), LocalDate.of(2024, 4, 30), 5);
        assertEquals("Ella", user.getName());
    }
}
