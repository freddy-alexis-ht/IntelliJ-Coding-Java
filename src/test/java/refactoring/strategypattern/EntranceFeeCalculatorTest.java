package refactoring.strategypattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntranceFeeCalculatorTest {

    @Test
    void testChildFeeFullDay() {
        double calculated = EntranceFeeCalculator.calculateFee(new Visitor(12), TicketType.FULL_DAY);
        assertEquals(50.0, calculated, 0.001);
    }

    @Test
    void testChildFeeHalfDay() {
        double calculated = EntranceFeeCalculator.calculateFee(new Visitor(6), TicketType.HALF_DAY);
        assertEquals(20.0, calculated, 0.001);
    }

    @Test
    void testAdultFeeFullDay() {
        double calculated = EntranceFeeCalculator.calculateFee(new Visitor(26), TicketType.FULL_DAY);
        assertEquals(120.0, calculated, 0.001);
    }

    @Test
    void testAdultFeeHalfDay() {
        double calculated = EntranceFeeCalculator.calculateFee(new Visitor(36), TicketType.HALF_DAY);
        assertEquals(60.0, calculated, 0.001);
    }
}
