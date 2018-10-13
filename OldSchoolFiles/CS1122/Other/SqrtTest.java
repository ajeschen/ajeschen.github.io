import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SqrtTest extends TestCase{
	
	public static final double NumOfDecimals = 1e-6; //THIS IS FOR ACCURACY PURPOSES FOR THE METHOD BELOW
	
	public void testSqrtBasic() { //THIS CHECKS TO SEE WHAT HAPPENS WHEN IT IS THE NUMBER 2.O
		double sqrt2 = Math.sqrt(2.0);
		assertEquals(0.0, Math.sqrt(+0.0), 0.0);
		assertEquals(0.0, Math.sqrt(-0.0), 0.0);
		assertEquals(2.0, sqrt2 * sqrt2, NumOfDecimals);
    }
	
	public void testPositiveInfinity() { //THIS CHECKS TO SEE WHAT HAPPENS WHEN IT IS POSITIVE INFINITY
		double positiveInfinity = Double.POSITIVE_INFINITY;	
		assertEquals(positiveInfinity, Math.sqrt(positiveInfinity), 0.0);
    }
	
	public void testNegativeInfinity() { //THIS CHECKS TO SEE WHAT HAPPENS WHEN IT IS NEGATIVE INFINITY
		double negativeInfinity = Double.NEGATIVE_INFINITY;	
		assertTrue(Double.isNaN(Math.sqrt(negativeInfinity)));
    }
	
	public void testNotANumber() { //THIS CHECKS TO SEE WHAT HAPPENS IF IT IS NOT A NUMBER
		double NotANumber = Double.NaN;	
		assertTrue(Double.isNaN(Math.sqrt(NotANumber)));
    }
	
	public void testNegativeUnderRoot() { //THIS CHECKS TO SEE WHAT HAPPENS IF THERE IS A NEGATIVE UNDER THE ROOT
		assertTrue(Double.isNaN(Math.sqrt(-2.0)));
    }
	
	public static Test suite() { //THIS IS WHAT TESTS THE CODE!
		return new TestSuite(SqrtTest.class);
    }
	
	public SqrtTest (String name) { //THIS RETURNS THE NAME
		super(name);
    }
}
