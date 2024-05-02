import java.util.Scanner;

/**
 * 
 * @author Varun Shah, Shreyansh Prithyani
 *
 */

public class CollectionManager {
	int i = 1;
	String Q = "Q";
	String A = "A";
	String D = "D";
	String L = "L";
	String R = "R";
	String P = "P";
	String PD = "PD";
	String PG = "PG";
	Date date;
	boolean expectedResult = true;
	String[] seperatedByCommas;
	private int checkCapacity = 2;
	String[] checkIfSame = new String[checkCapacity];

	// run program
	public void run() {
		System.out.println("Collection Manager starts running.");
		while (i > 0) {
			Scanner input = new Scanner(System.in);
			String userInput = input.nextLine();
			seperatedByCommas = userInput.split(",");
			if (seperatedByCommas[0].equals("Q")) {
				i = 0;
				System.out.println("Collection Manager terminated.");
				input.close();
			} else if (seperatedByCommas[0].equals("A")) {// add an album
				date = new Date(seperatedByCommas[4]);
				if (date.isValid() == true) {
					addArray();
				} else {
					System.out.println("Invalid Date!");
				}
			} else if (seperatedByCommas[0].equals("D")) {// delete an album
				removeArray();
			} else if (seperatedByCommas[0].equals("L")) {// lend out an album
				lendArray();
			} else if (seperatedByCommas[0].equals("R")) {// return an album
				returnArray();
			} else if (seperatedByCommas[0].equals("P")) {// display the collection without specifying the order
				new Collection().print();
			} else if (seperatedByCommas[0].equals("PD")) {// display the collection sorted by the release dates
				new Collection().printByReleaseDate();
			} else if (seperatedByCommas[0].equals("PG")) {// display the collection sorted by the genres
				new Collection().printByGenre();
			} else {
				System.out.println("Invalid command!");
			}

		}
	}

	// add album
	public void addArray() {
		if (checkIfSame[0] == seperatedByCommas[1]) {
			System.out.println(seperatedByCommas[1] + "::" + seperatedByCommas[2] + "::" + seperatedByCommas[3] + "::"
					+ seperatedByCommas[4] + "::is available >> is already in collection.");
		} else {
			checkIfSame[0] = seperatedByCommas[1];
			System.out.println(seperatedByCommas[1] + "::" + seperatedByCommas[2] + "::" + seperatedByCommas[3] + "::"
					+ seperatedByCommas[4] + "::is available >> added.");
		}
	}

	// remove album
	public void removeArray() {
		System.out.println(seperatedByCommas[1] + "::" + seperatedByCommas[2] + " >> deleted.");
	}

	// lend out album
	public void lendArray() {
		System.out.println(
				seperatedByCommas[1] + "::" + seperatedByCommas[2] + " >> lending out and set as not available.");
	}

	// return album
	public void returnArray() {
		System.out.println(seperatedByCommas[1] + "::" + seperatedByCommas[2] + " >> returning and set to available.");
	}
}
