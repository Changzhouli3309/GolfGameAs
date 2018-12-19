package se.lexicon.GolfGame;

import java.util.*;

public class FixDouble {
	private static Scanner scan= new Scanner(System.in);
	private static Random ran= new Random();
	
	public static double randomDouble (double max,double min) {
		double re = ran.nextDouble()*(max-min)+min;
		return re;
	}
	
	//Check the enter string is number or not, until you get a valid number
	public static double getDouble() {
    	boolean valid = false;
    	double number = 0;
    	while(!valid) {
    		try {
        		number = Double.parseDouble(scan.nextLine());
        		valid = true;
        	}catch(NumberFormatException e) {
        		System.out.println("You did not enter a valid number(double)");
        	}
    	}
    	return number;    	
    }
	
	//keep asking for number until you put right number from limit
	public static double getDoubleFromLimit(double max, double min) {
		double re=0;
		boolean valid = false;
		while(!valid) {
			re=FixDouble.getDouble();
			if (re>=min&&re<=max) {
				valid=true;				
			}
			if(!valid) {
				System.out.println("You did not enter a valid number(double)");
			}
    	}
		return re;
	}
	public static double getDoubleFromLimit(double max, double min,boolean with) {
		double re=0;
		boolean valid = false;
		while(!valid) {
			re=FixDouble.getDouble();
			if (re>=min&&re<=max) {
				valid=true;
				if (!with) {
					if (re==min||re==max) {
						valid=false;
					}
				}					
			}
			if(!valid) {
				System.out.println("You did not enter a valid number(double)");
			}
    	}
		return re;
	}
	
	//Print decimal with better looking
	public static String printD(double n, int de,int max) {
		String sD = Double.toString(FixDouble.rounding(n, de));
		String re="",inP=FixInt.addZero((int)n, max);
		for (int i=sD.indexOf(".");i<=sD.indexOf(".")+de;i++) {
			re+=sD.charAt(i);
		}		
		
		if (de==0) {
			return inP;
		}else {
			return inP+re;
		}
	}
	
	public static String printD(double n, int de) {
		String sD = Double.toString(FixDouble.rounding(n, de));
		String re="",inP=FixInt.printN(n);
		for (int i=sD.indexOf(".");i<=sD.indexOf(".")+de;i++)  {
			re+=sD.charAt(i);
		}
		
		if (de==0) {
			return inP;
		}else {
			return inP+re;
		}

	}
	
	public static double getRounding(double n,int de) {
		double re = Double.parseDouble(printD( n, de));
		return re;
		
	}
	public static double rounding(double n, int de) {
		double re = 5*Math.pow(0.1, (de+1))+n;	
		return re;
		
	}
}
