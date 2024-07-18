package calculator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeClass
    public static void init() {
        calculator = new Calculator();
    }

    @Test
    public void addTwoNumbersTest() {
        Assert.assertEquals(3, calculator.addTwoNumbers(2,1));
    }

    @Test
    public void subTwoNumbersTest() {
        Assert.assertEquals(4, calculator.subTwoNumbers(5, 1));
    }

    @Test
    public void multiplyTwoNumbersTest() {
        Assert.assertEquals(6, calculator.multiplyTwoNumbers(3, 2));
    }

    @Test
    public void divTwoNumbersTest() {
        Assert.assertEquals(2, calculator.divTwoNumbers(6, 3));
    }


}
