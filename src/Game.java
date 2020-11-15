import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
	
	private String playerName;
	private int gamesPlayed;
	private int score;
	private String wordForLap;
	private int guesses;
	private int correctGuesses;
	private int wrongGuesses;
	
	
	
	public Game() {
		
		playerName = "";
		gamesPlayed = 0;
		score = 0;
		wordForLap = "";
		guesses = 8;
		correctGuesses = 0;
		wrongGuesses = 0;
		
	}	
	
	
	public void startGame() {
		
		System.out.println("Please enter your name: ");		
		playerName = read();
		
		boolean moreGame = true;
		
		while(moreGame) {
			
						
			menuGame();
			
			String userChoice = read();
			
			if(userChoice.equalsIgnoreCase("E"))
				moreGame = false;
			
			else if(userChoice.equalsIgnoreCase("S"))
				printStatistics();
			
			else if(userChoice.equalsIgnoreCase("N")) {				
				gamesPlayed++;
				correctGuesses = 0;
				wrongGuesses = 0;
				playGame();
				
			}			
		
		}
		
		System.out.println("Goodbye!!!");
		
		
	}
	
	
	public void playGame() {
		
		Set<String> previousGuesses = new HashSet<>();		
		wordForLap = takeWordFromDictionary();
		
		
		int lenghtWord = wordForLap.length();
		
		char[] wordForLapInvertToChar = wordForLap.toCharArray();
		
		char[] secretWord = wordForLap.toCharArray();

        for (int i = 0; i < lenghtWord; i++) {
        	secretWord[i] = '-';
        }
        
        int currentGuesses = guesses;
        
        while (!String.valueOf(secretWord).equals(wordForLap) && currentGuesses > 0) {
        	
        	System.out.print("The random word is now: ");
        	for (int i = 0; i < lenghtWord; i++) {
        		
                System.out.print(secretWord[i]);
            }
        	
        	System.out.println("\nYou have " +currentGuesses +" guesses left.");
        	
        	System.out.print("Your guess: ");
        	String currentGuess = read().toUpperCase();
        	
            char userGuess = currentGuess.charAt(0);
            
            boolean lettersWhichRepeated = false;
            if (previousGuesses.contains(currentGuess)) {
            	
                System.out.println("You already guessed this letter! Guess again. Your previous guesses were: ");
                System.out.println(previousGuesses.stream().reduce("", String::concat));
                lettersWhichRepeated = true;
                
            }
            
            previousGuesses.add(currentGuess);
            
            boolean isCorrectTheGuess = false;
            
            if (!lettersWhichRepeated) {
            	
                for (int index = 0; index < lenghtWord; index++) {
                	
                    if (wordForLapInvertToChar[index] == userGuess) {
                    	
                    	secretWord[index] = userGuess;  //replaces * with guessed letter in caps
                    	isCorrectTheGuess = true;
                    }
                }
                if (isCorrectTheGuess) {
                	
                	correctGuesses++;
                    System.out.println("The guess is CORRECT!");
                } 
                
                else {
                	
                	wrongGuesses++;
                	currentGuesses--;
                    System.out.println("There are no " +userGuess +"'s in the word.");
                
                }                
            }        	
        }
        
        if(String.valueOf(secretWord).equals(wordForLap)) {
        	
        	score++;        	
        	System.out.println("Congratulations! You guessed the word: " +wordForLap);
        	System.out.print("You made " + correctGuesses +" correct guesses ");
        	System.out.println("and " + wrongGuesses + " wrong guesses.");
        	
        }
        else {
        	
        	System.out.println("You lost!!!");
        	System.out.print("You made " + correctGuesses +" correct guesses ");
        	System.out.println("and " + wrongGuesses + " wrong guesses.");
        }
        	        
	}
	
	public String takeWordFromDictionary() {
		
		Dictionary D1 = new Dictionary();
		int forIndex = D1.getRandomInt(0, 29);
		String word= D1.getWord(forIndex);
				
		return word;
		
	}
	
	public String read() {
		
		Scanner in = new Scanner(System.in);						
		String letterORwords = in.nextLine();
		return letterORwords;
		
	}
	

	
	public void menuGame() {
		
		System.out.println("Player Name: " + playerName);
		System.out.println("MAIN MENU");
		System.out.println("   -  Start a new Game  (N)");
		System.out.println("   -  Statistics  (S)");
		System.out.println("   -  Exit  (E)");
		System.out.println("Please enter your choice:");
	}
	
	
	public void printStatistics() {
		
		System.out.print("You have played so far " +gamesPlayed +" games. ");
		System.out.print("You won " +score +" times ");
		System.out.println("and lost " +(gamesPlayed-score) + " times.");
		
	}	

}
