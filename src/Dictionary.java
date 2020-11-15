import java.util.Random;

public class Dictionary {
	
	
		
	public Dictionary() {		
			
	}
	
	public String getWord(int index) {
		
		switch (index) {
		
		case 0	: return "UNIVERSITY";
		case 1	: return "COMPUTERS";
		case 2	: return "LAPTOP";
		case 3	: return "HEADPHONES";
		case 4	: return "FUZYY";
		case 5	: return "DOG";
		case 6	: return "KEYHOLE";
		case 7	: return "TELEPHONE";
		case 8	: return "PRINTER";
		case 9	: return "BUILDING";
		case 10	: return "BOX"; 
		case 11	: return "TREE";
		case 12	: return "BIKE";
		case 13	: return "TELEGRAPH"; 
		case 14	: return "PILLOW";
		case 15	: return "SOCKS";
		case 16	: return "SPOON";
		case 17	: return "TABLE";
		case 18	: return "PEN";
		case 19	: return "FORK";
		case 20	: return "KNIFE";
		case 21	: return "TOMATO";
		case 22	: return "CAR";
		case 23	: return "BENCH";
		case 24	: return "BALL";
		case 25	: return "NAIL";
		case 26	: return "MENU";
		case 27	: return "FIREWORKS";
		case 28	: return "TRAP";
		case 29	: return "BOTTLE";
		default: return "Illegal Index";

		}		
	}
	
	public int getRandomInt(int min, int max){
	    Random random = new Random();
	    return random.ints(min,(max)).findFirst().getAsInt();
	}	

}
