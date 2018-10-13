import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class DivisorCalcTest extends TestCase{
	public void test(){
		DivisorCalc x = new DivisorCalc();
		System.out.println(x.gcd(5,5));
		assertEquals(5, x.gcd(5,5));	
	}
	public void test2(){
		DivisorCalc x = new DivisorCalc();
		System.out.println(x.gcd(10,4));
		assertEquals(2, x.gcd(10,4));
	}
	public void test3(){
		DivisorCalc x = new DivisorCalc();
		System.out.println(x.gcd(3,6));
		assertEquals(3, x.gcd(3,6));
	}		
	public static Test suite() { 
		return new TestSuite(DivisorCalcTest.class);
    }
	
}
