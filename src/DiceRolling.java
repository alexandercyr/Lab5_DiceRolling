import java.util.Scanner;
import java.util.Random;

/**
 * Program simulates dice rolling for die with number of sides provided by user.
 *
 * @author Alexander Cyr
 *
 */

public class DiceRolling {

	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		int sidesCount = 0;
		int turnCount = 1;
		String continueRun = "y";

		System.out.println("Welcome to the Grand Circus Casino!");
		System.out.println();

		System.out.print("How many sides should each die have? ");
		// Get number of sides from user
		sidesCount = getValidInput();
		scnr.nextLine();

		// Roll dice until user says so
		while (continueRun.equalsIgnoreCase("y")) {

			System.out.println();
			System.out.println("Roll " + turnCount);
			rollDice(sidesCount);

			// Check if user wants to roll again
			System.out.println();
			System.out.println("Roll again? (y/n) ");
			continueRun = scnr.nextLine();
			continueRun = String.valueOf(continueRun.charAt(0));

			// Increment turn count
			turnCount++;

		}

		System.out.println();
		System.out.println("Program terminated.");
		scnr.close();
	}

	public static void rollDice(int sidesCount) {

		Random randGen = new Random();

		int die1 = randGen.nextInt(sidesCount) + 1;
		int die2 = randGen.nextInt(sidesCount) + 1;
		int sum = die1 + die2;

		// Output random number up to specified number of sides
		System.out.println(die1);
		System.out.println(die2);
		
		if (sidesCount == 6) {
			craps(sum);
		}

	}

	public static void craps(int sum) {
		if (sum == 2) {
			System.out.println("Snake Eyes!");
		} else if (sum == 7 || sum == 11) {
			System.out.println("Rolled a " + sum + " - Craps!");
		} else if (sum == 12) {
			System.out.println("Boxcar!");
		}
	}
	
	public static int getValidInput() {
		int userNumber = 0;
		boolean valid = false;

		while (!valid) {

			// Loop until user provides a number
			while (!scnr.hasNextInt()) {
				System.out.print("Invalid entry. Enter a number greater than 0: ");
				scnr.nextLine();
			}

			userNumber = scnr.nextInt();

			// Check to see if user number is greater than zero
			if (userNumber >= 4) {
				valid = true;
			} else {
				System.out.print("Invalid entry. Enter a number 4 or greater: ");
				scnr.nextLine();
			}
		}

		return userNumber;
	}

}
