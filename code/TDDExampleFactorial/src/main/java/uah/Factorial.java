package uah;

import java.util.Scanner;

public class Factorial {
  public static void main(String[] args) {
    System.out.print("Enter an integer: ");
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
    Factorial fact = new Factorial();
    try {
      System.out.println(fact.compute(num));
    } catch (Exception e) {
      System.out.print(e.toString());
    }
  }

  /* Initial version after the first JUnit */
  /*   public int compute(int i) {
          return 1;
  }*/

  /* After adding second, third, etc. JUnit */
  /*      public int compute(int i) {
      int result = 0;
      if (i==0 || i ==1)
          result = 1;
      else
          if (i==2)
            result = 2;
          else
            if (i==3)
              result = 6;
            else
              result = i*compute(i-1);
      return result;
  }*/

  /*After refactoring   */
/*  public int compute(int i) {
    int result = 0;
    if (i == 0 || i == 1) result = 1;
    else result = i * compute(i - 1);
    return result;
  }*/

  /*  public int compute(int i) {
    if (i<0)
      throw new IllegalArgumentException("No negatives: " + i);
    int result = 0;
      if (i==0 || i ==1)
        result = 1;
      else
        if (i==2)
          result = 2;
        else
          if (i==3)
            result = 6;
          else
            result = i*compute(i-1);
    return result;
  }*/

  public int compute(int i) {
    if (i<0)
      throw new IllegalArgumentException("No negatives: " + i);
    int result = 0;
    if (i == 0 || i == 1) result = 1;
    else result = i * compute(i - 1);
    return result;
  }
}
