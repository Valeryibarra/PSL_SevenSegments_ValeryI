package test;

	
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


import logical.Core;

/**
 * Test class of Core class
 */
class CoreTest {

	/**
	 * Class to be tested
	 */
	private Core core;
	
	
	/**
	 * Scenario that has all numbers from 0 to 9
	 */
	private String scenario1Main = "data/scenario1.txt";

	/**
	 * Scenario that has segments that are not numbers
	 */
	private String scenario2Main = "data/scenario2.txt";

	/**
	 * Scenario where the lines do not have the same size
	 */
	private String scenario3Main = "data/scenario3.txt";

	/**
	 * Scenario with only one digit
	 */
	private String scenario4Main = "data/scenario4.txt";

	/**
	 * Scenario with more than 3 lines, but multiple of 3 therefore correct
	 */
	private String scenario5Main = "data/scenario5.txt";

	/**
	 * Test that all possible digits are converted to string correctly
	 */
	@org.junit.jupiter.api.Test
	public void testScenario1() {
		String[] args = null;
		final InputStream original = System.in;
		FileInputStream fips;
		try {
			fips = new FileInputStream(new File(scenario1Main));
			System.setIn(fips);
			core.main(args);
			String res = Core.getTotalResult();
			System.setIn(original);
			assertNotNull(res);
			assertEquals("1234567890", res);
			res = "";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test if a segment is not a number, in this case must show x
	 */
	@org.junit.jupiter.api.Test
	public void testScenario2() {
		String[] args = null;
		final InputStream original = System.in;
		FileInputStream fips;
		try {
			fips = new FileInputStream(new File(scenario2Main));
			System.setIn(fips);
			core.main(args);
			String res = Core.getTotalResult();
			System.setIn(original);
			assertNotNull(res);
			assertEquals("12345678xx", res);
			res = "";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	* Test if the 3 lines have different size 
	*/
	@org.junit.jupiter.api.Test
	public void testScenario3() {
		String[] args = null;
		final InputStream original = System.in;
		FileInputStream fips;
		try {
			fips = new FileInputStream(new File(scenario3Main));
			System.setIn(fips);
			core.main(args);
			String res = Core.getTotalResult();
			System.setIn(original);
			assertNotNull(res);
			assertEquals("For the input you must enter 3 lines of the same size", res);
			res = "";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test only one digit
	 */
	@org.junit.jupiter.api.Test
	public void testScenario4() {
		String[] args = null;
		final InputStream original = System.in;
		FileInputStream fips;
		try {
			fips = new FileInputStream(new File(scenario4Main));
			System.setIn(fips);
			core.main(args);
			String res = Core.getTotalResult();
			System.setIn(original);
			assertNotNull(res);
			assertEquals("0", res);
			res = "";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Test for cases where there are more than 3 lines
	 */
	@org.junit.jupiter.api.Test
	public void testScenario5() {
		String[] args = null;
		final InputStream original = System.in;
		FileInputStream fips;
		try {
			fips = new FileInputStream(new File(scenario5Main));
			System.setIn(fips);
			core.main(args);
			String res = Core.getTotalResult();
			System.setIn(original);
			assertNotNull(res);
			assertEquals("433805825433805825\r\n" + "1234567890\r\n" + "0", res);
			res = "";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
