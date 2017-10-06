/**
 * File Name: JogLog.java<br>
 * Deng, Stephanie(Xiaofan)<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Oct 6, 2017
 */
package com.sqa.sxd;

import com.sqa.sxd.helpers.AppBasics;

/**
 * JogLog 1. Welcome the user to the application. 2. Ask the user what the
 * registered jogger's name is. 3. Ask the user how many days the person being
 * logged or jogger has jogged this week (max 7). 4. For each day accounted for,
 * ask user how many hours the jogger has jogged. 5. Calculate the total hours
 * the jogger has jogged for the week. Let the user know how many hours are
 * logged for the week for that jogger. 6. Echo a farewell message to the user.
 * 7. Calculate the average number of hours jogged during this week for the
 * jogger. 8. Distinguish if the jogger is an Amateur Jogger/ Efficient Jogger/
 * or Extremist Jogger. Amateur is under 15 hours, Efficient is 15-40 hours, and
 * an Extremist is over 40. //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Deng, Stephanie(Xiaofan)
 * @version 1.0.0
 * @since 1.0
 */
public class JogLog {

	public enum Day {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}

	public enum JoggerType {
		Amateur, Efficient, Extremist
	}

	private static String appName = "Jog Log";

	/**
	 * Have the program continue execution until they do not want to log any
	 * more joggers into the system.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String name = "";
		while (AppBasics.requestBoolean("Anyone want to log your jogging info(true/false)? ")) {
			name = logOneJogger();
			AppBasics.fareWellUser(name, appName);
		}
	}

	/**
	 * @param name
	 * @return
	 */
	private static int daysJogged(String name) {
		System.out.println("Hello " + name + "!");
		int numOfDays = AppBasics.requestInt("How many days did you jog in last 7 days?", 0, 7);
		return numOfDays;
	}

	/**
	 * @param day
	 * @return
	 */
	private static double getJoggedHours(Day day) {
		return AppBasics.requestDouble("How many hours did you jog on " + day + "?", 0.0, 24.0);
	}

	/**
	 * @return
	 */
	private static String logOneJogger() {
		String name = "";
		int numOfDays = 0;
		int count = 0;
		double hours[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		name = AppBasics.greetUserAndGetName(appName);
		numOfDays = daysJogged(name);
		count = numOfDays;
		if (count > 0) {
			for (Day day : Day.values()) {
				hours[day.ordinal()] = getJoggedHours(day);
				if (hours[day.ordinal()] != 0.0)
					count--;
				if (count == 0)
					break;
			}
			sumJogLog(name, numOfDays, hours);
		} else
			System.out.println("You NEED to jog in the future!");
		return name;
	}

	/**
	 * @param name
	 * @param numOfDays
	 * @param hours
	 */
	private static void sumJogLog(String name, int numOfDays, double[] hours) {
		double totalHours = 0.0;
		for (Day day : Day.values()) {
			totalHours += hours[day.ordinal()];
		}
		System.out.print("Hello " + name + ",");
		System.out.println("you have jogged " + totalHours + " hours in " + numOfDays + " days last week!");
		System.out.println("Your jogged " + totalHours / numOfDays + " hours on average each day!");
		JoggerType joggerType;
		if (totalHours > 40.0)
			joggerType = JoggerType.Extremist;
		else if (totalHours < 15)
			joggerType = JoggerType.Amateur;
		else
			joggerType = JoggerType.Efficient;
		System.out.println("You are an " + joggerType + " jogger.");
	}
}
