package se.lexicon.GolfGame;

import java.util.*;

public class FixInt {
	private static Scanner scan = new Scanner(System.in);
	private static Random ran = new Random();

	public static int randomInt(int max, int min) {
		int re = ran.nextInt(max - min) + min;
		return re;
	}

	// Check the string is number or not, until you get a valid number
	public static int getInt() {
		boolean valid = false;
		int number = 0;
		while (!valid) {
			try {
				number = Integer.parseInt(scan.nextLine());
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("You did not enter a valid number(int)");
			}
		}
		return number;
	}

	// keep asking for number until you put right number from limit
	public static int getIntFromLimit(int max, int min) {
		int re = 0;
		boolean valid = false;
		while (!valid) {
			re = getInt();
			if (re >= min && re <= max) {
				valid = true;
			}
			if (!valid) {
				System.out.println("You did not enter a valid number(int)");
			}
		}
		return re;
	}

	public static int getIntFromLimit(int max, int min, boolean with) {
		int re = 0;
		boolean valid = false;
		while (!valid) {
			re = getInt();
			if (re >= min && re <= max) {
				valid = true;
				if (!with) {
					if (re == min || re == max) {
						valid = false;
					}
				}
			}
			if (!valid) {
				System.out.println("You did not enter a valid number(int)");
			}
		}
		return re;
	}

	// print integer part of doubled number
	public static String printN(double n) {
		String s = "" + (int) n;
		return s;
	}

	// add 0 before the number if it is too short
	public static String addZero(int n, int max) {
		String s = "";
		int b = n;

		for (; (max / 10) > 0; max /= 10) {
			b /= 10;
			if (b == 0) {
				s += "0";
			}
		}
		return s + n;
	}

	// add space after the number if it is too short
	public static String addSpace(int n, int max) {
		String s = "";
		int b = n;

		for (; (max / 10) > 0; max /= 10) {
			b /= 10;
			if (b == 0) {
				s += " ";
			}
		}
		return n + s;
	}
}
