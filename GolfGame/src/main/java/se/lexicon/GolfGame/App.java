package se.lexicon.GolfGame;

public class App 
{
    public static void main( String[] args )
    {
    	//decimal to show and count
    	int de=1,
    	c=0,tries=1,
    	//Tolerance/2 on ball and hole
    	ballSize=1,holeSize=2;
    	double angle=0,speed=0,g=9.8,ballM=0,holeM=0,min=90,max=230;
    	double []travel= new double[0];
    	double []par = {90,230,430,550};
    	boolean with=false,run=true;
    	
        while (run) {
        	
			if (tries == 1) {//Start a new game
				System.out.println("Welcome to golf Game");
				System.out.println("Courses: ");
				for (int i = 0; i < par.length - 1; i++) {
					System.out.println("Par " + (i + 3) + ": " + 
									FixInt.printN(par[i]) + "m-" + 
									FixInt.printN(par[i + 1])+"m");
				}
				
				System.out.println("Chose your Course:");
				//keep asking for number until you put right number from limit
				c = FixInt.getIntFromLimit(5, 3);
				min = par[c - 3];
				max = par[c - 2];
				
				//make a random hole in your chosen course
				holeM = FixDouble.randomDouble(max, min);
				System.out.println("Good Luck!");
				System.out.println();
			}
			
			System.out.println("Your goal is " + FixDouble.printD(holeM, de) + "m away.");
			System.out.println(tries + " Try(es)");
			System.out.print("Angle(0-90): ");
			angle = FixDouble.getDoubleFromLimit(90, 0, with);
			System.out.print("Velocity: ");
			speed = FixDouble.getDoubleFromLimit(99999, 0, with);
			//counting the distant
			ballM = GolfM.countD(angle, speed, g);
			//arrays that record every shot
			travel = FixArr.addToArr(travel, ballM);
			
			//match the position of ball and hole
			if (GolfM.isHit(GolfM.getSize(FixDouble.getRounding(ballM, de), ballSize,de),
					GolfM.getSize(FixDouble.getRounding(holeM, de), holeSize,de))) {
				System.out.println();
				
				//result message after you win
				if(tries==1) {
					System.out.println("Hole in one!!! Amazing!!! ");
				}else {
					System.out.println(GolfM.score(tries, c));
				}
				System.out.println();
				System.out.println("You made it in " + tries + " Try(es)");
				
				//show you distant of every tries
				for (int i = 0; i < travel.length; i++) {
					System.out.println((i + 1) + "   " + 
							FixDouble.printD(travel[i], de,(int)max)+"m");
				}
				System.out.println();
				run = YesOrNo.bool();

				if (run == true) {//yes to rest the game
					tries = 0;
					travel=new double[0];
					ballM=0;
				}
			
			//set new distant to goal when you miss
			} else if (ballM < holeM) {
				System.out.println("It travels " + FixDouble.printD(ballM, de)+"m");
				System.out.println();
				holeM -= ballM;
			} else {
				System.out.println("It travels " + FixDouble.printD(ballM, de)+
									"m and over the hole.");
				System.out.println();
				holeM -= ballM;
				holeM *= -1;
			}
			tries++;
		}
        System.out.println("Goodbye!");
        
    }  
}
