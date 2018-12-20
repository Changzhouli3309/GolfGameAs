package se.lexicon.GolfGame;

public class App 
{
    public static void main( String[] args )
    {
    	//decimal to show and count
    	int de=1,
    	c=0,tries=1,dif=1,
    	//Tolerance arrays for positions of ball and hole
    	//Example size=2 means ball-position-arrays will be {-0.2,-0.1,ball position,0.1,0.2}
    	ballSize=1,holeSize=2;
    	// mid position of ball or hole
    	double ballM=0,holeM=0,
    	//basic state
    	angle=0,speed=0,g=9.8,max=1,min=0,
    	wef=0,wmax=0,wmin=0;
    	double []travel= new double[0];
    	double []togoal= new double[0];
    	double []par = {90,230,430,550};
    	double []weff = {0,1.5,3};
    	boolean with=false,run=true;
    	
        while (run) {
        	
			if (tries == 1) {//Start a new game
				System.out.println("Welcome to golf Game");
				System.out.println("Courses: ");
				for (int i = 0; i < par.length - 1; i++) {
					System.out.println(i+"-Par " + (i + 3) + ": " + 
									FixInt.printN(par[i]) + "m-" + 
									FixInt.printN(par[i + 1])+"m");
				}
				
				System.out.println("Choose your Course:");
				//keep asking for number until you put right number from limit
				c = FixInt.getIntFromLimit(3, 0)+3;
				max = par[c-2];
				min = par[c-3];
								
				System.out.println("0-get no wind effect");
				System.out.println("1-get max +or-2m/s wind effect");
				System.out.println("2-get max +or-4m/s wind effect");
				System.out.println("Choose the difficul: ");
				dif = FixInt.getIntFromLimit(2, 0);
				wmax = weff[dif];
				wmin =-weff[dif];
				
				//make a random position of the hole in your chosen course
				holeM = FixDouble.randomDouble(max, min);
				System.out.println("Good Luck!");
				
			}
			System.out.println();
			System.out.println("Your goal is " + FixDouble.printD(holeM, de) + "m away.");
			System.out.println(tries + " Try(es)");
			System.out.print("Angle(0-90): ");
			angle = FixDouble.getDoubleFromLimit(90, 0, with);
			System.out.print("Velocity(Max 60m/s): ");
			speed = FixDouble.getDoubleFromLimit(60, 1);
			//random wind effect
			wef=FixDouble.randomDouble(wmax, wmin);
			if(wef<0.0) {System.out.println("The wind is against you,  "+FixDouble.printD(wef, de)+"m/s");}
			if(wef>0.0) {System.out.println("The wind is towards goal, +"+FixDouble.printD(wef, de)+"m/s");}
			speed+=wef;
			
			//counting the distant
			ballM = GolfM.countD(angle, speed, g);
			System.out.print("It travels " + FixDouble.printD(ballM, de)+"m");
			
			//arrays that record every shot
			togoal = FixArr.addToArr(togoal, holeM);
			travel = FixArr.addToArr(travel, ballM);
			
			//match the position of ball and hole
			if (GolfM.isHit(GolfM.getSize(FixDouble.getRounding(ballM, de), ballSize,de),
					GolfM.getSize(FixDouble.getRounding(holeM, de), holeSize,de))
					||tries>(c+2)) 
			{
				System.out.println();
				
				//result message after you win
				if(tries==1) {
					
					System.out.println("Hole in one!!! Amazing!!! ");
					System.out.println();
					System.out.println("You made it in " + tries + " Tries");
				}else if(tries>(c+2)){
					System.out.println();
					System.out.println("Out of Shots!");
				}else{
					
					System.out.println(GolfM.score(tries, c));
					System.out.println();
					System.out.println("You made it in " + tries + " Tries");
				}
				
				//show the distant of every tries
				for (int i = 0; i < travel.length; i++) {
					System.out.println((i + 1) + "   " 
							+FixDouble.printD(togoal[i], de,(int)max)
							+"m to goal, you shot "
							+FixDouble.printD(travel[i], de,(int)max)+"m");
				}
				System.out.println();
				run = YesOrNo.bool();
				
				//yes to rest the game
				if (run == true) {
					tries = 0;
					travel=new double[0];
					ballM=0;
				}
			
			//set new distant to goal when you miss
			} else if (ballM < holeM) {
				System.out.println();
				holeM -= ballM;
			} else {
				System.out.print(" and over the hole.");
				System.out.println();
				holeM -= ballM;
				holeM *= -1;
			}
			tries++;
			wmax *=1/tries ;
			wmin *=1/tries ;
		}
        System.out.println("Goodbye!");
        
    }  
}
