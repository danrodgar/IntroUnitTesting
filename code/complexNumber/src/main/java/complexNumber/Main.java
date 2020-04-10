package complexNumber;


public class Main {

	public static void main(String[] args) {
		
        ComplexNumber cOneZero = new ComplexNumber(1, 0);
        ComplexNumber cZeroOne = new ComplexNumber(0, 1);
        ComplexNumber cOneOne = new ComplexNumber(1, 1);
        
        ComplexNumber a = cOneZero.add(cZeroOne);
        
        System.out.println(cOneOne);
        System.out.println(a);
        
        // with (cOneOne==a) this two are different (not the same reference)
        if (cOneOne.equals(a)) {
        	System.out.println("These complex numbers are equal.");
        } else {
        	System.out.println("Different!!");
        }
        
        

	}

}
