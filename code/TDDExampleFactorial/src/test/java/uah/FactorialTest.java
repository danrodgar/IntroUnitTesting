package uah;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

  private Factorial factorial;

  /* We can refactor the Junits with new Factorial as setUp()*/
  @BeforeEach
  public void setUp() {
    factorial = new Factorial();
  }

  @Test
  public void shouldFactorialOf0Return1() {
    // Factorial factorial = new Factorial() ;
    int expectedValue = 1;
    int obtainedValue = factorial.compute(0);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void shouldFactorialOf1Return1() {
    // Factorial factorial = new Factorial() ;
    int expectedValue = 1;
    int obtainedValue = factorial.compute(1);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void shouldFactorialOf2Return2() {
    // Factorial factorial = new Factorial() ;
    int expectedValue = 2;
    int obtainedValue = factorial.compute(2);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  void testExpectedExceptionWithSuperType() {
      Assertions.assertThrows(IllegalArgumentException.class, () -> {
          int compute = factorial.compute(-1);
          ;
      });
  }

  // There is also an overflow Exception
  // The following can be done as exercises:
  // 1. Overflow, check the maximum number before the input is too large
  // 2. Implement the iterative version and check it
  // Another similar example that can be done is with Fibonacci

}
