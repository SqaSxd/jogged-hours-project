/**
 * File Name: AppBasics.java<br>
 * Deng, Stephanie(Xiaofan)<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Oct 2, 2017
 */
package com.sqa.sxd.helpers;

import java.util.Scanner;

import com.sqa.sxd.helpers.exceptions.RequestNumberNotWithinRangeException;
import com.sqa.sxd.helpers.exceptions.RequestNumberOverMaxException;
import com.sqa.sxd.helpers.exceptions.RequestNumberUnderMinException;

/**
 * AppBasics //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Deng, Stephanie(Xiaofan)
 * @version 1.0.0
 * @since 1.0
 */
public class AppBasics {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Helper method which farewells the user at the end of an application to
	 * say Thank you and widh them well.
	 *
	 * @param name
	 *            Name of user
	 * @param appName
	 *            Name of the Application
	 */
	public static void fareWellUser(String name, String appName) {
		System.out.println("Thank you " + name + ", for using the " + appName + " Application. Have a great Day!");
	}

	/**
	 * Helper method which greets the user and welcome them to the Application.
	 * This method then takes their name and return it to the calling method.
	 *
	 * @param appName
	 *            Name of the Application
	 * @return name Name of the user
	 */
	public static String greetUserAndGetName(String appName) {
		System.out.println("Welcome to my " + appName + " Application");
		System.out.print("Could I get your name please? ");
		return scanner.nextLine();
	}

	/**
	 * @param question
	 * @return boolean value
	 */
	public static boolean requestBoolean(String question) {
		boolean resultBool = false;
		String input = "";
		boolean valid = false;
		while (!valid) {
			try {
				System.out.print(question);
				input = scanner.nextLine();
				resultBool = Boolean.parseBoolean(input);
				if (resultBool == true || resultBool == false)
					valid = true;
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a valid boolean data [" + input + "]");
			}
		}
		return resultBool;
	}

	/**
	 * @param question
	 * @return byte value
	 */
	public static byte requestByte(String question) {
		int resultByte = 0;
		String input = "";
		boolean valid = false;
		while (!valid) {
			try {
				System.out.print(question);
				input = scanner.nextLine();
				resultByte = Integer.parseInt(input);
				if (resultByte >= 0 || resultByte <= 255)
					valid = true;
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a valid byte data [" + input + "]");
			}
		}
		return (byte) resultByte;
	}

	/**
	 * @param question
	 * @return char
	 */
	public static char requestChar(String question) {
		char resultChar = 0;
		String input = "";
		boolean valid = false;
		while (!valid) {
			try {
				System.out.print(question);
				resultChar = scanner.next().charAt(0);
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a valid char [" + input + "]");
			}
		}
		return resultChar;
	}

	/**
	 * @param question
	 * @param min
	 * @param max
	 * @return double
	 */
	public static double requestDouble(String question, double min, double max) {
		double resultNum = 0.0;
		String input = "";
		boolean valid = false;
		while (!valid) {
			try {
				System.out.print(question);
				input = scanner.nextLine();
				resultNum = Integer.parseInt(input);
				if (resultNum < min)
					throw new RequestNumberUnderMinException();
				else if (resultNum > max)
					throw new RequestNumberOverMaxException();
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a valid formatted number [" + input + "]");
			} catch (RequestNumberNotWithinRangeException e) {
				System.out.println(
						"You have not entered a number in range " + "(" + min + ")-(" + max + ") - [" + input + "]");
			}
		}
		return resultNum;
	}

	/**
	 * @param question
	 * @param min
	 * @param max
	 * @return float
	 */
	public static float requestFloat(String question, float min, float max) {
		float resultNum = 0;
		String input = "";
		boolean valid = false;
		while (!valid) {
			try {
				System.out.print(question);
				input = scanner.nextLine();
				resultNum = Integer.parseInt(input);
				if (resultNum < min)
					throw new RequestNumberUnderMinException();
				else if (resultNum > max)
					throw new RequestNumberOverMaxException();
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a valid formatted number [" + input + "]");
			} catch (RequestNumberNotWithinRangeException e) {
				System.out.println(
						"You have not entered a number in range " + "(" + min + ")-(" + max + ") - [" + input + "]");
			}
		}
		return resultNum;
	}

	/**
	 * @param question
	 * @param min
	 * @param max
	 * @return integer number
	 */
	public static int requestInt(String question, int min, int max) {
		int resultNum = 0;
		String input = "";
		boolean valid = false;
		while (!valid) {
			try {
				System.out.print(question);
				input = scanner.nextLine();
				resultNum = Integer.parseInt(input);
				if (resultNum < min)
					throw new RequestNumberUnderMinException();
				else if (resultNum > max)
					throw new RequestNumberOverMaxException();
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a valid formatted number [" + input + "]");
				/*
				 * } catch (RequestNumberUnderMinException e) { System.out.
				 * println("You have not entered a number lager than (" + min +
				 * ") - [" + input + "]"); } catch
				 * (RequestNumberOverMaxException e) { System.out.
				 * println("You have not entered a number less than (" + max +
				 * ") - [" + input + "]");
				 */
			} catch (RequestNumberNotWithinRangeException e) {
				System.out.println(
						"You have not entered a number in range " + "(" + min + ")-(" + max + ") - [" + input + "]");
			}
		}
		return resultNum;
	}

	// public static int requestInt(String question);
	// public static int requestInt(String question, int min, int max);
	// public static int requestInt(String question, int min, int max, String
	// errorMessage);
	/**
	 * @param question
	 * @return long
	 */
	public static float requestLong(String question) {
		long resultNum = 0;
		String input = "";
		boolean valid = false;
		while (!valid) {
			try {
				System.out.print(question);
				input = scanner.nextLine();
				resultNum = Long.parseLong(input);
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a valid formatted number [" + input + "]");
			}
		}
		return resultNum;
	}

	/**
	 * @param question
	 * @return short
	 */
	public static float requestShort(String question) {
		short resultNum = 0;
		String input = "";
		boolean valid = false;
		while (!valid) {
			try {
				System.out.print(question);
				input = scanner.nextLine();
				resultNum = Short.parseShort(input);
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a valid formatted number [" + input + "]");
			}
		}
		return resultNum;
	}

	/**
	 * @param question
	 * @return String
	 */
	public static String requestString(String question) {
		String resultStr = "";
		boolean valid = false;
		while (!valid) {
			try {
				System.out.print(question);
				resultStr = scanner.nextLine();
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a valid formatted String [" + resultStr + "]");
			}
		}
		return resultStr;
	}
}
