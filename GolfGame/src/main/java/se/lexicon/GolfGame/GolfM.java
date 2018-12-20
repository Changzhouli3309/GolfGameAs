package se.lexicon.GolfGame;

public class GolfM {
	
	//make a arrays of all tolerance that can be
	public static double[] getSize(double mid,int size,int di) {
		double []re=new double[size*2+1];
		double t=-Math.pow(0.1, (double)di)*size;
		for (int i=0;i<re.length;i++){
			re[i]=mid+t;
			t+=0.1;	
		}
		return re;
	}
	
	//match two arrays if one element from both arrays is same, it will return true
	public static boolean isHit(double[] a,double[] b) {
		boolean hit=false;
		for (double n1:a) {
			for(double n2:b) {
				if (n1==n2) {
					hit=true;
				}
			}
		}
		return hit;
	}
	
	//send the score message
	public static String score(int tries,int par) {
		String re=null;
		switch(tries-par) {
		case -3:
			re="Albatross!!!Congratulations!!!";
			break;
		case -2:
			re="Eagle!!!Congratulations!!!";
			break;
		case -1:
			re="Birdie!!!Nice Work!";
			break;
		case -0:
			re="Par!!Nice Work!";
			break;
		case 1:
			re="Bogey!Good job!";
			break;
		case 2:
			re="Double-bogey!";
			break;
		case 3:
			re="Triple-bogey!";
			break;
		default:
			if((tries-par)<-4) {
				re="Condor!!!Amazing!!!";
			}else {
				re=(tries-par)+"-over-par.";
			}
		}
		return re;
	}
	
	public static double countD(double angle, double speed,double g) {
		return Math.pow(speed, 2) /g * Math.sin(2 * (Math.PI / 180) * angle);
	}
}
