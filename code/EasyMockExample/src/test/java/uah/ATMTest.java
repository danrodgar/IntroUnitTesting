package uah;/*
 * Easymock testing example: ATM and Gateway
 */
import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;*/


public class ATMTest {

    private ATM classUnderTest;
    private PaymentGateway mock ;


    public ATMTest() {
    }

   /* @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }*/

    @BeforeEach
    public void setUp() {
        classUnderTest = new ATM("1111111111");
        classUnderTest.startSession("1234");
        /* (1) Creates a mock for the collaborating class*/
        mock =  createMock(PaymentGateway.class);
    }

    @AfterEach
    public void tearDown() {
        classUnderTest.closeSession();
        reset(mock);
    }


    /**
     * Test of withdraw method, of class ATM.
     */
    @Test
    public void makeWithdrawalTestBasic() {//throws Exception {
        System.out.println("Make withdrawal - Basic");
   
         /* (2) "recording" mode. We record in the mock object what
          * call are expected and how to respond those calls.
          */
        expect(mock.isBlocked()).andReturn(false);
        expect(mock.hasCredit(500)).andReturn(true);
        mock.withdraw(500);
        
         /*
          * (3) Now, the simulated object starts waiting for calls 
          */
        replay(mock);

        boolean result = classUnderTest.withdraw(500, mock);
        assertTrue(result);
        
        /* We force that the lack of calls is also an error
         */
        verify(mock);
    }

    /**
     *
     */
    @Test
    public void makeWithdrawalTestComplex() { //throws Exception {
        System.out.println("Make withdrawal - Complex");

        /* (2) recording mode. We record in the mock object what
         * call are expected and how to respond those calls.
         */
        expect(mock.isBlocked()).andReturn(false);
        expect(mock.hasCredit(500)).andReturn(true);
        mock.withdraw(500);
        expect(mock.isBlocked()).andReturn(false);
        expect(mock.hasCredit(10000)).andReturn(false);

        expect(mock.isBlocked()).andReturn(true);
        

        /* (3) Simulated object starts reciving calls */
        replay(mock);

         boolean result = classUnderTest.withdraw(500, mock);
        assertTrue(result);
        // Trying to withdraw too much money:
        result = classUnderTest.withdraw(10000, mock);
        assertFalse(result);
        
        /* Then a new call with an amount that is valid but the 
         * but the account is now blocked
         */
        result = classUnderTest.withdraw(200, mock);
        assertFalse(result);

        verify(mock);
    }
}