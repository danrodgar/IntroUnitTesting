package complexNumber;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Disabled;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class ComplexNumberTest {

    private ComplexNumber cOneZero;
    private ComplexNumber cZeroOne;
    private ComplexNumber cOneOne;

//    public ComplexNumberTest() {
//    }

//    @BeforeAll
//    public static void setUpClass() {
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
//    }

    @BeforeEach
    public void setUp() {
        System.out.println("Set up");
        cOneZero = new ComplexNumber(1, 0);
        cZeroOne = new ComplexNumber(0, 1);
        cOneOne = new ComplexNumber(1, 1);
    }

//    @AfterEach
//    public void tearDown() {
//        cOneZero = null;
//        cZeroOne = null;
//        cOneOne = null;
//    }

    /**
     * Test of getReal method, of class ComplexNumber.
     */
    @Test
    public void testGetRealPart() {
        System.out.println("getRealPart");
        double expResult = 0;
        double result = cZeroOne.getRealPart();
        assertEquals(expResult, result);
    }

    /**
     * Test of getImaginary method, of class ComplexNumber.
     */
    @Test
    public void testGetImaginaryPart() {
        System.out.println("getImaginaryPart");
        double expResult = 1.0;
        double result = cZeroOne.getImaginaryPart();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class ComplexNumber.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ComplexNumber result = cZeroOne.add(cOneZero);
        //assertEquals(cOneOne.toString(), result.toString()); //Funciona
        assertEquals(cOneOne, result); 
        //assertThat(cOneOne, equalTo(result)); 
    }

    /**
     * Test of multiply method, of class ComplexNumber.
     */
    @Test
    @Order(1)
    public void testMultiply() {
        System.out.println("multiply");
        ComplexNumber result = cZeroOne.multiply(cOneZero);
        
        System.out.println("We compare that the strings of " 
				+ cZeroOne.toString() + " is equal to " 
				+ result.toString() + ".");

        if (cZeroOne.equals(result)) 
        	System.out.println("equals yes");
        
        assertEquals(cZeroOne, result);
        //assertThat(cZeroOne, equalTo(result)); 
    }

    /**
     * Test of equals method, of class ComplexNumber.
     */
    @Test
    public void testEqualsFalse() {
        System.out.println("equalsFalse");
        boolean expResult = false;
        boolean result = cZeroOne.equals(cOneZero);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEqualsFalseWithNotEquals() {
        System.out.println("equals");
        boolean expResult = true;
        boolean result = cOneOne.equals(cOneZero);
        assertNotEquals(expResult, result);
    }

}
