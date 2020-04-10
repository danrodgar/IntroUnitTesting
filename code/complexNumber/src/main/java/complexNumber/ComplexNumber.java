package complexNumber;

import java.util.Objects;

/**
 * A class for representing and manipulating complex numbers.
 *
 */
class ComplexNumber {

	// Private data fields for the complex number:
	// realPart + imagPart * i
	private double realPart;
	private double imagPart;

	/**
	 * Construct a new ComplexNumber that has the value 0 + 0i.
	 */
	public ComplexNumber() {
	}

	/**
	 * Construct a new ComplexNumber with the value realPart + 0i.
	 *
	 * @param realPart initial value for the real part of the new ComplexNumber.
	 */
	public ComplexNumber(double realPart) {
		this.realPart = realPart;
	}

	/**
	 * Construct a new ComplexNumber with the value realPart + imagPart*i.
	 *
	 * @param realPart initial value for the real part of the new ComplexNumber.
	 * @param imagPart initial value for the imaginary part of the new
	 *                 ComplexNumber.
	 */
	public ComplexNumber(double realPart, double imagPart) {
		this.realPart = realPart;
		this.imagPart = imagPart;
	}

	/**
	 * Return a reference to a new ComplexNumber with value equal to the sum of this
	 * ComplexNumber and the ComplexNumber theNum.
	 *
	 * @param theNum a ComplexNumber to be added to this ComplexNumber.
	 * @return a reference to a new ComplexNumber equal to the sum of this
	 *         ComplexNumber and theNum.
	 */
	public ComplexNumber add(ComplexNumber theNum) {
		return new ComplexNumber(realPart + theNum.realPart, imagPart + theNum.imagPart);
	}

	/**
	 * Return a reference to a new ComplexNumber with value equal to the difference
	 * between this ComplexNumber and the ComplexNumber theNum.
	 *
	 * @param theNum a ComplexNumber to be subtracted from this ComplexNumber.
	 * @return a reference to a new ComplexNumber equal to the difference between
	 *         this ComplexNumber and theNum.
	 */
	public ComplexNumber subtract(ComplexNumber theNum) {
		return new ComplexNumber(realPart - theNum.realPart, imagPart - theNum.imagPart);
	}

	/**
	 * Return a reference to a new ComplexNumber with value equal to the
	 * multiplication between this ComplexNumber and the ComplexNumber theNum.
	 *
	 * @param theNum a ComplexNumber to be subtracted from this ComplexNumber.
	 * @return a reference to a new ComplexNumber equal to the multiplication
	 *         between this ComplexNumber and theNum.
	 */
	public ComplexNumber multiply(ComplexNumber theNum) {
		double re = getRealPart() * theNum.getRealPart() - getImaginaryPart() * theNum.getImaginaryPart();
		double im = getImaginaryPart() * theNum.getRealPart() + getRealPart() * theNum.getImaginaryPart();
		return new ComplexNumber(re, im);
	}

	/**
	 * Get the real part of this ComplexNumber.
	 *
	 * @return the real part of this ComplexNumber.
	 */
	public double getRealPart() {
		return realPart;
	}

	/**
	 * Get the imaginary part of this ComplexNumber.
	 *
	 * @return the imaginary part of this ComplexNumber.
	 */
	public double getImaginaryPart() {
		return imagPart;
	}

	/**
	 * Convert this ComplexNumber into a String representation. The string
	 * representation is realPart + imagPart i.
	 *
	 * @return a String representation of this ComplexNumber.
	 */
	@Override
	public String toString() {

		// If the imagPart is >= 0 print out a + b i
		if (imagPart >= 0) {
			return realPart + " + " + imagPart + " i";
		}
		// If the imagPart is < 0 print out a - b i
		else {
			return realPart + " - " + (-imagPart) + " i";
		}
	}

	/**
	 * Calculates the hascode of a ComplexNumber instance.
	 *
	 * @return int with the hashcode.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.realPart, this.imagPart);
	}

	/**
	 * Test whether the <i>this</i> ComplexNumber and the ComplexNumber theNum are
	 * equal. Two ComplexNumbers are equal if their real parts are equal and their
	 * imaginary parts are equal.
	 *
	 * @param theNum the ComplexNumber to which this ComplexNumber is to be compared
	 *               for equality.
	 * @return true if the real and imaginary parts of this ComplexNumber are equal
	 *         to the real and imaginary parts of theNum, and false otherwise.
	 */
	@Override
	public boolean equals(Object o) {

		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		/*
		 * Check if o is an instance of Complex or not "null instanceof [type]" also
		 * returns false
		 */
		if (!(o instanceof ComplexNumber)) {
			return false;
		}

		// typecast o to Complex so that we can compare data members
		ComplexNumber c = (ComplexNumber) o;

		// Compare the data members and return accordingly
		return Double.compare(realPart, c.realPart) == 0 && Double.compare(imagPart, c.imagPart) == 0;
	}
	// The following code is not working as equals when doing testing
	// public boolean equals(ComplexNumber theNum) {
	// return ((realPart == theNum.realPart) &&
	// (imagPart == theNum.imagPart));
	// }
}
