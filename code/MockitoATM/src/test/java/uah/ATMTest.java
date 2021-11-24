package uah;

/*
 * Mocking testing example: ATM and Gateway
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ATMTest {

  private ATM classUnderTest;
  private PaymentGateway mock;

  public ATMTest() {}

  @BeforeEach
  public void setUp() {
    classUnderTest = new ATM("1111111111");
    classUnderTest.startSession("1234");
    /* (1) Creates a mock for the collaborating class*/
    mock = mock(PaymentGateway.class);
  }

  @AfterEach
  public void tearDown() {
    classUnderTest.closeSession();
  }

  /** Test of withdraw method, of class ATM. */
  @Test
  public void makeWithdrawalTestBasic() {
    System.out.println("Make withdrawal - Basic");

    /* Expectations in the mock object, i.e., what
     * calls are expected and how to respond those calls.
     */
    when(mock.isBlocked()).thenReturn(false);
    when(mock.hasCredit(500)).thenReturn(true);

    boolean result = classUnderTest.withdraw(500, mock);
    assertTrue(result);

    boolean result2 = classUnderTest.withdraw(500, mock);
    assertTrue(result2);

    /* We force that the lack of calls is also an error
     */
    verify(mock, times(2)).withdraw(500);
  }

  /** */
  @Test
  public void makeWithdrawalTestComplex() {
    System.out.println("Make withdrawal - Complex");

    /* We record in the mock object what
     * call are expected and how to respond those calls.
     */
    when(mock.isBlocked()).thenReturn(false);
    when(mock.hasCredit(500)).thenReturn(true);
    // mock.withdraw(500);
    when(mock.isBlocked()).thenReturn(false);
    when(mock.hasCredit(10000)).thenReturn(false);

    boolean result = classUnderTest.withdraw(500, mock);
    System.out.println("Result: " + result);
    assertTrue(result);

    // Trying to withdraw too much money:
    result = classUnderTest.withdraw(10000, mock);
    assertFalse(result);

    /* Then a new call with an amount that is valid but the
     * but the account is now blocked
     */
    when(mock.isBlocked()).thenReturn(true);
    result = classUnderTest.withdraw(200, mock);
    assertFalse(result);

    verify(mock, atLeast(1)).withdraw(500);
  }
}
