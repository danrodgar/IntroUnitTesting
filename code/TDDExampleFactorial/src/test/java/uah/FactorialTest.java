package uah;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTest {

  private Factorial factorial;

  /* We can refactor the Junits with new Factorial as setUp()
  @BeforeEach
  public void setUp() {
    factorial = new Factorial();
  }
  */

  @Test
  public void shouldFactorialOf0Return1() {
    Factorial factorial = new Factorial();
    int expected = 1;
    int actual = factorial.compute(0);
    assertEquals(expected, actual);
   }

  @Test
  public void shouldFactorialOf1Return1() {
    Factorial factorial = new Factorial();
    int expected = 1;
    int actual = factorial.compute(1);
    assertEquals(expected, actual);
  }

  @Test
  public void shouldFactorialOf2Return2() {
    Factorial factorial = new Factorial();
    int expected = 2;
    int actual = factorial.compute(2);
    assertEquals(expected, actual);
  }

  @Test
  public void shouldFactorialOf3Return6() {
    Factorial factorial = new Factorial();
    int expected = 6;
    int actual = factorial.compute(3);
    assertEquals(expected, actual);
  }

  @Test
  public void shouldFactorialOf5Return120() {
    Factorial factorial = new Factorial();
    int expected = 120;
    int actual = factorial.compute(5);
    assertEquals(expected, actual);
  }



  // Factorial factorial = new Factorial() ;
    //int expectedValue = 1;
    //int obtainedValue = factorial.compute(0);
    //assertEquals(expectedValue, obtainedValue);
  //}

  /*
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
*/
  // There is also an overflow Exception
  // The following can be done as exercises:
  // 1. Overflow, check the maximum number before the input is too large
  // 2. Implement the iterative version and check it
  // Another similar example that can be done is with Fibonacci


  /*
   1. fact(0) = 0;
   2. fact(1) = 1;
   3. fact(2) = 2;
   4. fact(3) = 6;
   5. fact(5) = 120;
   */

}
