package se.lexicon.GolfGame;

import java.util.Scanner;
//get the yes or no answer, don't accept anything else.
public class YesOrNo {
	private static Scanner scan = new Scanner(System.in);
	
	public static boolean bool() {
		System.out.println("Again? (y/n)");
		
		boolean valid = false, res=true;
		
		while(!valid) {
			String sr = scan.nextLine();
			String s = sr.toLowerCase();
			switch (s) {
			case "y":
				valid = true;
				res=true;
				break;
			case "n":
				valid = true;
				res=false;
				break;
			default:
				System.out.println("Not enter avalidable enter.(y/n)");
				
			}
		}
		return res;
			
	}
}
