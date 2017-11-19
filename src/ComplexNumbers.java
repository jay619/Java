/*
 * Shah Jaynish
 * Comlex Numbers
 * CSCI211
 * Feb 9, 2015
 * Assignment 3
 * shahjaynish@gmail.com
 */

import javax.swing.JOptionPane;

public class ComplexNumbers {
	private double real;
	private double imag;

	// Constructor
	public ComplexNumbers(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public ComplexNumbers(double real) {
		this.real = real;
	}

	// Default Constructor or the zeroth Complex number ie. 0 + 0i
	public ComplexNumbers() {

	}

	// Accessors
	public double getReal() {
		return real;
	}

	public double getImag() {
		return imag;
	}

	// Mutators
	public void setReal(double real) {
		this.real = real;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public String toString() {
		if (imag == 0)
			return real + " ";
		if (real == 0)
			return imag + " i ";
		if (imag < 0)
			return real + " - " + -imag + " i ";
		else
			return real + " + " + imag + " i ";
	}

	// Utility Methods
	public ComplexNumbers add(ComplexNumbers b) { // This method adds two
													// complex numbers.
		ComplexNumbers a = this;
		double real = a.real + b.real;
		double imag = a.imag + b.imag;
		return new ComplexNumbers(real, imag);
	}

	public ComplexNumbers subtract(ComplexNumbers b) { // This method subtracts
														// two complex numbers
		ComplexNumbers a = this;
		double real = a.real - b.real;
		double imag = a.imag - b.imag;
		return new ComplexNumbers(real, imag);
	}

	public ComplexNumbers multiply(ComplexNumbers b) { // This method multiplies
														// two complex numbers
		ComplexNumbers a = this;
		double real = a.real * b.real - a.imag * b.imag;
		double imag = a.real * b.imag + a.imag * b.real;
		return new ComplexNumbers(real, imag);
	}

	public ComplexNumbers divide(ComplexNumbers b) { // This method divides two
														// complex numbers
		ComplexNumbers a = this;
		double real = (a.real * b.real + a.imag * b.imag)
				/ (b.real + b.real + b.imag + b.imag);
		double imag = (a.imag * b.real - a.real * b.imag)
				/ (b.real + b.real + b.imag + b.imag);
		return new ComplexNumbers(real, imag);
	}

	public double abs() { // This method finds the absolute value of a complex
							// number
		ComplexNumbers a = this;
		return Math.sqrt(a.real * a.real + a.imag + a.imag);
	}

	public ComplexNumbers negate() { // This method negates the complex number
		return new ComplexNumbers(-real, -imag);
	}

	public ComplexNumbers conjugate() { // This methods find the conjugate of
										// the complex number
		return new ComplexNumbers(real, -imag);
	}

	public double distance(ComplexNumbers b) { // This method finds the distance
												// between two complex numbers
		ComplexNumbers a = this;
		double magnitude = Math.sqrt((a.real - b.real) * (a.real - b.real)
				+ (a.imag - b.imag) * (a.imag - b.imag));
		return magnitude;
	}

	public boolean isgreaterThan(ComplexNumbers b) {
		ComplexNumbers a = this;
		if (b.abs() > a.abs())
			return true;
		else
			return false;
	}

	public boolean islessThan(ComplexNumbers b) {

		ComplexNumbers a = this;
		if (b.abs() < a.abs())
			return true;
		else
			return false;
	}

	public boolean isequal(ComplexNumbers b) { // This method finds if two
												// complex numbers are equal or
												// not
		ComplexNumbers a = this;
		if (a.real == b.real && a.imag == b.imag)
			return true;
		else
			return false;
	}

	public static void main(String args[]) {

		final String title = "Complex Numbers";

		ComplexNumbers x, y, z;

		// Demonstrate addition function
		x = new ComplexNumbers(1, 2);
		y = new ComplexNumbers(3, 4);
		z = x.add(y);
		JOptionPane.showMessageDialog(null, z, "Addition of Complex Numbers",
				JOptionPane.PLAIN_MESSAGE);

		x = new ComplexNumbers(2, 4);
		y = new ComplexNumbers(3, 6);
		z = x.add(y);
		JOptionPane.showMessageDialog(null, z, "Addition of Complex Numbers",
				JOptionPane.PLAIN_MESSAGE);

		// Demonstrate Subtraction function
		x = new ComplexNumbers(3, 5);
		y = new ComplexNumbers(4, 3);
		z = x.subtract(y);
		JOptionPane.showMessageDialog(null, z,
				"Subtraction of Complex Numbers", JOptionPane.PLAIN_MESSAGE);

		x = new ComplexNumbers(8, 2);
		y = new ComplexNumbers(3, 4);
		z = x.subtract(y);
		JOptionPane.showMessageDialog(null, z,
				"Subtraction of Complex Numbers", JOptionPane.PLAIN_MESSAGE);

		// Demonstrate multiplication function
		x = new ComplexNumbers(1, 2);
		y = new ComplexNumbers(3, 4);
		z = x.multiply(y);
		JOptionPane.showMessageDialog(null, z,
				"Multiplication of Complex Numbers", JOptionPane.PLAIN_MESSAGE);

		x = new ComplexNumbers(4, 10);
		y = new ComplexNumbers(8, 5);
		z = x.multiply(y);
		JOptionPane.showMessageDialog(null, z,
				"Multiplication of Complex Numbers", JOptionPane.PLAIN_MESSAGE);

		// Demonstrate division function
		x = new ComplexNumbers(1, 2);
		y = new ComplexNumbers(3, 4);
		z = x.divide(y);
		JOptionPane.showMessageDialog(null, z, "Division of Complex Numbers",
				JOptionPane.PLAIN_MESSAGE);

		// Demonstrate negation of Complex Numbers
		x = new ComplexNumbers(2, 4);
		z = x.negate();
		JOptionPane.showMessageDialog(null, z, "Negation of Complex Numbers",
				JOptionPane.PLAIN_MESSAGE);

		// Demonstrate Conjugate of Complex Numbers
		x = new ComplexNumbers(2, 4);
		z = x.conjugate();
		JOptionPane.showMessageDialog(null, z, "Conjugate of Complex Numbers",
				JOptionPane.PLAIN_MESSAGE);

		// Asking the user for input and the operation user wishes to do

		JOptionPane.showMessageDialog(null, "Entering Interactive mode!!",
				title, JOptionPane.INFORMATION_MESSAGE);

		do {
			double real, imag;
			String temp;
			temp = JOptionPane.showInputDialog(null,
					"Enter Real part of the Complex Number 1", title,
					JOptionPane.INFORMATION_MESSAGE);
			if (temp == null)
				break;
			real = Double.parseDouble(temp);
			temp = JOptionPane.showInputDialog(null,
					"Enter imaginary part of the Complex Number 1", title,
					JOptionPane.PLAIN_MESSAGE);
			if (temp == null)
				break;
			imag = Double.parseDouble(temp);
			ComplexNumbers a = new ComplexNumbers(real, imag);

			temp = JOptionPane.showInputDialog(null,
					"Enter Real part of the Complex Number 2", title,
					JOptionPane.INFORMATION_MESSAGE);
			if (temp == null)
				break;
			real = Double.parseDouble(temp);
			temp = JOptionPane.showInputDialog(null,
					"Enter imaginary part of the Complex Number 2", title,
					JOptionPane.PLAIN_MESSAGE);
			if (temp == null)
				break;
			imag = Double.parseDouble(temp);
			ComplexNumbers b = new ComplexNumbers(real, imag);

			ComplexNumbers ans = null;
			String options[] = { "Add", "Subtract", "Multiply", "Divide",
					"Quit" };
			int option = JOptionPane.showOptionDialog(null, "Choose Operation",
					title, JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, 4);
			String output = "" + a;

			switch (option) {
			case 0:
				ans = a.add(b);
				output += " + ";
				break;
			case 1:
				ans = a.subtract(b);
				output += " - ";
				break;
			case 2:
				ans = a.multiply(b);
				output += " * ";
				break;
			case 3:
				ans = a.divide(b);
				output += " / ";
				break;
			default:
				break;
			}
			if (option > 3)
				break;
			output += b + " = " + ans;
			JOptionPane.showMessageDialog(null, output, title,
					JOptionPane.PLAIN_MESSAGE);

			option = JOptionPane.showConfirmDialog(null,
					"Do you want to do this again?", title,
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (option != JOptionPane.YES_OPTION)
				break;
		} while (true);

	}

}