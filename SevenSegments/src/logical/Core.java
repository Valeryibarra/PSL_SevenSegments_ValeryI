package logical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Core {

	/**
	 * Reader that get the inputs
	 */
	private static BufferedReader reader;

	/**
	 * Writer that shows the outputs
	 */
	private static BufferedWriter writer;

	private static String totalResult;

	/**
	 * Main method of the class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			// First line of input
			String line;
			line = reader.readLine();
			// Current digit that will be found
			Character currenDigit = ' ';
			totalResult = "";

			// Flag that indicates if the while sentence should follow or not
			boolean whileFlag = true;

			while (line != null && !line.equals(" ") && whileFlag) {
				if (!totalResult.equals("")) {
					totalResult += "\r\n";
				}

				String firstLine = line;
				int sizeFirstLine = firstLine.length();
				line = reader.readLine();

				String secondLine = line;
				int sizeSecondLine = secondLine.length();
				line = reader.readLine();

				String thirdLine = line;
				int sizethirdLine = thirdLine.length();

				if (sizeFirstLine != sizeSecondLine || sizeSecondLine != sizethirdLine) {
					// The lines has different size, can not find the numbers
					whileFlag = false;
					writer.write("For the input you must enter 3 lines of the same size");
					totalResult = "For the input you must enter 3 lines of the same size";
					writer.flush();

				} else {

					// Array with the high, middle and low part of the digit(number) respectively
					String[] digitArray = new String[3];

					// Every 4 characters read a new digit
					for (int i = 0; i < firstLine.length(); i += 4) {

						// Is the top part of the digit
						digitArray[0] = firstLine.substring(i, i + 3);
						// Is the middle part of the digit
						digitArray[1] = secondLine.substring(i, i + 3);
						// Is the bottom part of the digit
						digitArray[2] = thirdLine.substring(i, i + 3);

						// The digit is complete but divided into 3 parts.

						// Get the character of the digit
						currenDigit = getDigitNumber(digitArray);

						writer.write(currenDigit + "");
						totalResult += currenDigit;

					}

					writer.write("\n");
					writer.flush();
					line = reader.readLine();
					if (line == null || line.equals(" ")) {
						whileFlag = false;
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method that returns the number obtained by joining the array in which the
	 * digit is divided into parts
	 * 
	 * @param digitArray Array with the high, middle and low part of the
	 *                   digit(number) respectively
	 * @return Character Digit that represents the array
	 */
	public static Character getDigitNumber(String[] digitArray) {

		// Each digit has 3 lines and each line has a string of 3 Characters
		// Is the top part of the digit
		String firstLine = digitArray[0];
		// Is the middle part of the digit
		String secondLine = digitArray[1];
		// Is the bottom part of the digit
		String thirdLine = digitArray[2];

		// Is the digit obtained by joining each part of the array
		// It is assumed all digits are NaN(Not a Number) until it fits in a number, the
		// digit of NaN is x
		Character digit = 'x';

		switch (firstLine) {
		case "   ":
			// Digit is 1, 4 or NaN
			if (secondLine.equals("  |") && thirdLine.equals("  |")) {
				digit = '1';
			} else if (secondLine.equals("|_|") && thirdLine.equals("  |")) {
				digit = '4';
			}
			break;
		case " _ ":
			// Digit is 2,3,5,6,7,8,9,0 or NaN
			switch (secondLine) {
			case " _|":
				// Digit is 2, 3 or NaN
				switch (thirdLine) {
				case "|_ ":
					digit = '2';
					break;
				case " _|":
					digit = '3';
					break;
				}
				break;
			case "|_|":
				// Digit is 8, 9 or NaN
				switch (thirdLine) {
				case "|_|":
					digit = '8';
					break;
				case "  |":
					digit = '9';
					break;
				}
				break;
			case "|_ ":
				// Digit is 5, 6 or NaN
				switch (thirdLine) {
				case " _|":
					digit = '5';
					break;
				case "|_|":
					digit = '6';
					break;
				}
				break;
			case "  |":
				// Digit is 7 or NaN
				if (thirdLine.equals("  |")) {
					digit = '7';
				}
				break;
			case "| |":
				// Digit is 0 or NaN
				if (thirdLine.equals("|_|")) {
					digit = '0';
				}
				break;
			}
			break;
		}
		return digit;
	}

	/**
	 * Getter of the Result
	 * 
	 * @return string with the converted numbers
	 */
	public static String getTotalResult() {
		return totalResult;
	}

}
