import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int rounds = 0;
        int totalAttempts = 0;
        
        while (playAgain) {
            System.out.println("Welcome to the Number Guessing Game!");
            int minRange = 1;
            int maxRange = 100;
            int targetNumber = generateRandomNumber(minRange, maxRange);
            int attempts = 0;
            boolean correctGuess = false;
            
            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");
            
            while (!correctGuess && attempts < 10) { // Limiting to 10 attempts per round
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    correctGuess = true;
                }
            }
            
            totalAttempts += attempts;
            rounds++;
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();
            playAgain = playAgainChoice.equals("yes");
        }
        
        System.out.println("Game Over! You played " + rounds + " rounds and took a total of " + totalAttempts + " attempts.");
        scanner.close();
    }
    
    public static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
