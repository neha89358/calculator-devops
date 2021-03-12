import calculator.Calculator;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    Calculator calc = new Calculator();

    @Test
    public void sqrtTruePositive(){
        assertEquals("Calculating square root of a non-negative number for True Positive",4.0,calc.sqrt(16.0), DELTA);
        assertEquals("Calculating square root of a negative number for True Positive", Double.NaN, calc.sqrt(-16.0), DELTA);
    }

    @Test
    public void sqrtFalsePositive(){
        assertNotEquals("Calculating square root of a non-negative number for False Positive",2.0,calc.sqrt(16.0), DELTA);
        assertNotEquals("Calculating square root of a negative number for False Positive",1.0,calc.sqrt(-16.0), DELTA);
    }

    @Test
    public void factTruePositive(){
        assertEquals("Calculating factorial of a non-negative number for True Positive",120.0,calc.fact(5.0), DELTA);
        assertEquals("Calculating factorial of a negative number for True Positive", Double.NaN, calc.fact(-5.0), DELTA);
    }

    @Test
    public void factFalsePositive(){
        assertNotEquals("Calculating factorial of a non-negative number for False Positive",24.0,calc.fact(5.0), DELTA);
        assertNotEquals("Calculating factorial of a negative number for False Positive",20.0,calc.fact(-5.0), DELTA);
    }

    @Test
    public void nlogTruePositive(){
        assertEquals("Calculating natural log of a non-zero positive number for True Positive",0.0,calc.nlog(1.0), DELTA);
        assertEquals("Calculating natural log of a negative number for True Positive", Double.NaN, calc.nlog(-5.0), DELTA);
    }

    @Test
    public void nlogFalsePositive(){
        assertNotEquals("Calculating natural log of a non-negative number for False Positive",1.0, calc.nlog(1.0), DELTA);
        assertNotEquals("Calculating natural log of a negative number for False Positive",0.0, calc.nlog(-5.0), DELTA);
    }

    @Test
    public void powTruePositive(){
        assertEquals("Calculating power function on two numbers for True Positive",125.0,calc.pow(5,3), DELTA);
        assertEquals("Calculating power function on two numbers for True Positive", Double.NaN, calc.pow(0,0), DELTA);
    }

    @Test
    public void powFalsePositive(){
        assertNotEquals("Calculating power function on two numbers for False Positive",25.0,calc.pow(5,3), DELTA);
        assertNotEquals("Calculating power function on two numbers for False Positive",0.0,calc.pow(0,0), DELTA);
    }
}
