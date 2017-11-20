/*
 * Shah Jaynish
 * Comlex Numbers
 * CSCI211
 * Feb 9, 2015
 * Assignment 3 (updated)
 * shahjaynish@gmail.com
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Complex2 {
	private double real;
	private double imag;

	// Constructor
	public Complex2(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public Complex2(double real) {
		this.real = real;
	}

	public Complex2(String complexNumber) { // This Constructor can read string.
		// String to be scanned to find the pattern.
		String pattern = "^\\s*([+-]?)\\s*((\\d*\\.?\\d+)|(\\d+\\.))\\s*([+-])\\s*((\\d*\\.?\\d+)|(\\d+\\.))\\s*i\\s*$";
		String realPattern = "^\\s*([+-]?)\\s*((\\d*\\.?\\d+)|(\\d+\\.))$";
		String imagPattern = "^\\s*([+-]?)\\s*((\\d*\\.?\\d+)|(\\d+\\.))\\s*i\\s*$";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);
		Pattern real1 = Pattern.compile(realPattern);
		Pattern imag1 = Pattern.compile(imagPattern);

		// Now create matcher object.
		Matcher m = r.matcher(complexNumber);
		Matcher re = real1.matcher(complexNumber);
		Matcher im = imag1.matcher(complexNumber);

		if (m.find()) {
			int realSign = m.group(1).equals("-") ? -1 : 1;
			double realNo = Double.parseDouble(m.group(2));
			this.real = realSign * realNo;
			int imgSign = m.group(5).equals("-") ? -1 : 1;
			double imagNo = Double.parseDouble(m.group(6));
			this.imag = imgSign * imagNo;
		} else if (re.find()) {
			int realSign = re.group(1).equals("-") ? -1 : 1;
			double realNo = Double.parseDouble(re.group(2));
			this.real = realSign * realNo;
			this.imag = 0;
		} else if (im.find()) {
			int imagSign = im.group(1).equals("-") ? -1 : 1;
			double imagNo = Double.parseDouble(im.group(2));
			this.imag = imagSign * imagNo;
			this.real = 0;
		} else {
			System.err.println("Bad Complex Number Specified in Constructor: "
					+ complexNumber);
		}
	}

	// Default Constructor or the zeroth Complex number ie. 0 + 0i
	public Complex2() {

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
	public Complex2 add(Complex2 b) { // This method adds two
										// complex numbers.
		Complex2 a = this;
		double real = a.real + b.real;
		double imag = a.imag + b.imag;
		return new Complex2(real, imag);
	}

	public Complex2 subtract(Complex2 b) { // This method subtracts
											// two complex numbers
		Complex2 a = this;
		double real = a.real - b.real;
		double imag = a.imag - b.imag;
		return new Complex2(real, imag);
	}

	public Complex2 multiply(Complex2 b) { // This method multiplies
											// two complex numbers
		Complex2 a = this;
		double real = a.real * b.real - a.imag * b.imag;
		double imag = a.real * b.imag + a.imag * b.real;
		return new Complex2(real, imag);
	}

	public Complex2 divide(Complex2 b) { // This method divides two
											// complex numbers
		Complex2 a = this;
		double real = (a.real * b.real + a.imag * b.imag)
				/ (b.real + b.real + b.imag + b.imag);
		double imag = (a.imag * b.real - a.real * b.imag)
				/ (b.real + b.real + b.imag + b.imag);
		return new Complex2(real, imag);
	}

	public double abs() { // This method finds the absolute value of a complex
							// number
		Complex2 a = this;
		return Math.sqrt(a.real * a.real + a.imag + a.imag);
	}

	public Complex2 negate() { // This method negates the complex number
		return new Complex2(-real, -imag);
	}

	public Complex2 conjugate() { // This methods find the conjugate of
									// the complex number
		return new Complex2(real, -imag);
	}

	public double distance(Complex2 b) { // This method finds the distance
											// between two complex numbers
		Complex2 a = this;
		double magnitude = Math.sqrt((a.real - b.real) * (a.real - b.real)
				+ (a.imag - b.imag) * (a.imag - b.imag));
		return magnitude;
	}

	public boolean isgreaterThan(Complex2 b) {
		Complex2 a = this;
		if (a.abs() > b.abs())
			return true;
		else
			return false;
	}

	public boolean islessThan(Complex2 b) {

		Complex2 a = this;
		if (a.abs() < b.abs())
			return true;
		else
			return false;
	}

	public boolean isequal(Complex2 b) { // This method finds if two
											// complex numbers are equal or
											// not
		Complex2 a = this;
		boolean ans = false;
		if (a.isgreaterThan(b)) {
			if ((a.abs() - b.abs()) / a.abs() < 0.000001)
				return ans = true;
		} else {
			if ((b.abs() - a.abs()) / b.abs() < 0.000001)

				return ans = true;
		}
		return ans;
	}

	public static void main(String args[]) {

		final String title = "Complex Numbers";

		Complex2 x, y, z;

		// Demonstrate addition function
		x = new Complex2(1, 2);
		y = new Complex2(3, 4);
		z = x.add(y);
		JOptionPane.showMessageDialog(null, z, "Addition of Complex Numbers",
				JOptionPane.PLAIN_MESSAGE);

		x = new Complex2(2, 4);
		y = new Complex2(3, 6);
		z = x.add(y);
		JOptionPane.showMessageDialog(null, z, "Addition of Complex Numbers",
				JOptionPane.PLAIN_MESSAGE);

		// Demonstrate Subtraction function
		x = new Complex2(3, 5);
		y = new Complex2(4, 3);
		z = x.subtract(y);
		JOptionPane.showMessageDialog(null, z,
				"Subtraction of Complex Numbers", JOptionPane.PLAIN_MESSAGE);

		x = new Complex2(8, 2);
		y = new Complex2(3, 4);
		z = x.subtract(y);
		JOptionPane.showMessageDialog(null, z,
				"Subtraction of Complex Numbers", JOptionPane.PLAIN_MESSAGE);

		// Demonstrate multiplication function
		x = new Complex2(1, 2);
		y = new Complex2(3, 4);
		z = x.multiply(y);
		JOptionPane.showMessageDialog(null, z,
				"Multiplication of Complex Numbers", JOptionPane.PLAIN_MESSAGE);

		x = new Complex2(4, 10);
		y = new Complex2(8, 5);
		z = x.multiply(y);
		JOptionPane.showMessageDialog(null, z,
				"Multiplication of Complex Numbers", JOptionPane.PLAIN_MESSAGE);

		// Demonstrate division function
		x = new Complex2(1, 2);
		y = new Complex2(3, 4);
		z = x.divide(y);
		JOptionPane.showMessageDialog(null, z, "Division of Complex Numbers",
				JOptionPane.PLAIN_MESSAGE);

		// Demonstrate negation of Complex Numbers
		x = new Complex2(2, 4);
		z = x.negate();
		JOptionPane.showMessageDialog(null, z, "Negation of Complex Numbers",
				JOptionPane.PLAIN_MESSAGE);

		// Demonstrate Conjugate of Complex Numbers
		x = new Complex2(2, 4);
		z = x.conjugate();
		JOptionPane.showMessageDialog(null, z, "Conjugate of Complex Numbers",
				JOptionPane.PLAIN_MESSAGE);

		// Asking the user for input and the operation user wishes to do

		JOptionPane.showMessageDialog(null, "Entering Interactive mode!!",
				title, JOptionPane.INFORMATION_MESSAGE);

		do {

			String ex = JOptionPane.showInputDialog(null,
					" Enter the first complex number: ", title,
					JOptionPane.INFORMATION_MESSAGE);
			if (ex == null)
				break;
			Complex2 a = new Complex2(ex);

			ex = JOptionPane.showInputDialog(null,
					" Enter the second complex number: ", title,
					JOptionPane.INFORMATION_MESSAGE);
			if (ex == null)
				break;
			Complex2 b = new Complex2(ex);

			Complex2 ans = null;
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