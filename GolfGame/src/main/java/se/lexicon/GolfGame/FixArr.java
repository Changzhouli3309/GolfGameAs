package se.lexicon.GolfGame;

import java.util.Arrays;

public class FixArr {

	public static double averageArr(int[] source) {
		return (double) sumArr(source) / source.length;
	}

	public static double averageArr(double[] source) {
		return (double) sumArr(source) / source.length;
	}

	public static int sumArr(int[] source) {
		int re = 0;
		for (int n : source) {
			re += n;
		}
		return re;
	}

	public static double sumArr(double[] source) {
		double re = 0;
		for (double n : source) {
			re += n;
		}
		return re;
	}

	public static void printArr(double[] toPrint) {
		for (double n : toPrint) {
			System.out.print(FixInt.printN(n) + " ");
		}
	}

	public static void printArr(String[] toPrint) {
		for (String s : toPrint) {
			System.out.print(s + " ");
		}
	}

	public static void printArr(char[] toPrint) {
		for (char c : toPrint) {
			System.out.print(c + " ");
		}
	}

	public static int[] expandArr(int[] source) {
		return Arrays.copyOf(source, source.length + 1);
	}

	public static double[] expandArr(double[] source) {
		return Arrays.copyOf(source, source.length + 1);
	}

	public static String[] expandArr(String[] source) {
		return Arrays.copyOf(source, source.length + 1);
	}

	// add one new element to arrays
	public static int[] addToArr(int[] source, int toAdd) {
		int[] re = Arrays.copyOf(source, source.length);
		boolean isAdded = false;
		for (int i = 0; i < re.length; i++) {
			if (re[i] == 0) {
				re[i] = toAdd;
				isAdded = true;
				break;
			}
		}
		if (isAdded == false) {
			re = expandArr(re);
			re[re.length - 1] = toAdd;
		}
		return re;
	}

	public static double[] addToArr(double[] source, double toAdd) {
		double[] re = Arrays.copyOf(source, source.length);
		boolean isAdded = false;
		for (int i = 0; i < re.length; i++) {
			if (re[i] == 0) {
				re[i] = toAdd;
				isAdded = true;
				break;
			}
		}
		if (isAdded == false) {
			re = expandArr(re);
			re[re.length - 1] = toAdd;
		}
		return re;
	}

	public static String[] addToArr(String[] source, String toAdd) {
		String[] re = Arrays.copyOf(source, source.length);
		boolean isAdded = false;

		for (int i = 0; i < re.length; i++) {
			if (re[i].equals(null)) {
				re[i] = toAdd;
				isAdded = true;
				break;
			}
		}
		if (isAdded == false) {
			re = expandArr(source);
			re[re.length - 1] = toAdd;
		}
		return re;
	}

	// Check if element is in arrays or not

	public static boolean isInArr(int[] source, int cn) {
		boolean isIn = true;
		int index = Arrays.binarySearch(source, cn);
		if (index == -1) {
			isIn = false;
		}
		return isIn;
	}

	public static boolean isInArr(double[] source, double cn) {
		boolean isIn = true;
		int index = Arrays.binarySearch(source, cn);
		if (index == -1) {
			isIn = false;
		}

		return isIn;
	}

	public static boolean isInArr(String[] source, String cs) {
		boolean isIn = false;
		int index = Arrays.binarySearch(source, cs);
		if (index != -1) {
			isIn = true;
		}
		return isIn;
	}

	// arrays with odd or even numbers only
	public static double[] getOddNum(double[] source) {
		double[] re = new double[0];
		for (double n : source) {
			if (n % 2 == 1) {
				re = FixArr.addToArr(re, n);
			}
		}
		return re;
	}

	public static double[] getEvenNum(double[] source) {
		double[] re = new double[0];
		for (double n : source) {
			if (n % 2 == 0) {
				re = FixArr.addToArr(re, n);
			}
		}
		return re;
	}

	// Remove 0 from number arrays or null from string arrays
	public static double[] remove0(double[] source) {
		double[] re = new double[0];
		for (double s : source) {
			if (s != 0) {
				re = addToArr(re, s);
			}
		}
		return re;
	}

	public static String[] remove0(String[] source) {
		String[] re = new String[0];
		for (String s : source) {
			if (!s.equals(null)) {
				re = addToArr(re, s);
			}
		}
		return re;
	}

	// remove element with that index of arrays
	public static double[] removeIndex(double[] source, int n1) {
		double[] re = Arrays.copyOf(source, source.length);
		n1 -= 1;
		if (n1 < 0 || n1 >= re.length) {
			System.out.println("Not a vaild index.(strat with 1)");
			return re;
		} else {
			re[n1] = 0;
		}
		re = remove0(re);
		return re;
	}

	public static String[] removeIndex(String[] source, int n1) {
		String[] re = Arrays.copyOf(source, source.length);
		n1 -= 1;
		if (n1 < 0 || n1 >= re.length) {
			System.out.println("Not a vaild index.(strat with 1)");
			return re;
		} else {
			re[n1] = null;
		}
		re = remove0(re);
		return re;
	}

	// remove a type of all same known elements from arrays
	public static double[] removeElement(double[] source, double n1) {
		double[] re = Arrays.copyOf(source, source.length);
		boolean inArr = false;
		for (double n : re) {
			if (n == n1) {
				inArr = true;
			}
		}

		if (inArr == false) {
			System.out.println(n1 + " is not in the arrays");
			return re;
		} else {
			for (int i = 0; i < re.length; i++) {
				if (re[i] == n1) {
					re[i] = 0;
				}
			}
			re = remove0(re);
			return re;
		}
	}

	public static String[] removeElement(String[] source, String s) {
		String[] re = Arrays.copyOf(source, source.length);
		boolean inArr = false;
		for (String s2 : re) {
			if (s2.equals(s)) {
				inArr = true;
			}
		}

		if (inArr == false) {
			System.out.println(s + " is not in the arrays");
			return re;
		} else {
			for (int i = 0; i < re.length; i++) {
				if (re[i].equals(s)) {
					re[i] = null;
				}
			}
			re = remove0(re);
			return re;
		}
	}

	// reduce amount of a type of same known elements to 1
	public static double[] removeDu(double[] source) {
		double[] re = Arrays.copyOf(source, source.length);
		;
		for (int i = 0; i < re.length; i++) {
			for (int j = i + 1; j < re.length; j++) {
				if (re[i] == re[j]) {
					re[j] = 0;
				}
			}
		}
		re = remove0(re);
		return re;
	}

	public static String[] removeDu(String[] source) {
		String[] re = Arrays.copyOf(source, source.length);
		for (int i = 0; i < re.length; i++) {
			for (int j = i + 1; j < re.length; j++) {
				if (re[i].equals(re[j])) {
					re[j] = null;
				}
			}
		}
		re = remove0(re);
		return re;
	}

	// reverse the order of elements in arrays
	public static double[] reverseArr(double[] source) {
		double[] re = Arrays.copyOf(source, source.length);
		for (int i = 0; i <= (re.length / 2); i++) {
			double temt = re[i];
			re[i] = re[re.length - 1 - i];
			re[re.length - 1 - i] = temt;
		}
		return re;
	}

	public static String[] reverseArr(String[] source) {
		String[] re = Arrays.copyOf(source, source.length);
		for (int i = 0; i <= (re.length / 2); i++) {
			String temt = re[i];
			re[i] = re[re.length - 1 - i];
			re[re.length - 1 - i] = temt;
		}
		return re;
	}

	// make String to charArr
	public static char[] toCharArr(String s) {
		char[] re = new char[s.length()];
		for (int i = 0; i < re.length; i++) {
			re[i] = s.charAt(i);
		}
		return re;
	}
}
