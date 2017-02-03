import java.util.Scanner;

/**
 * @author Jordane Thomas
 *
 */
public class DateCalculator {

	/**
	 * @param args
	 */
	public static int getYo(int year, int month) {
		return year - ((14 - month) / 12);
	}

	public static int getX(int yo) {
		return yo + (yo / 4) - (yo / 100) + (yo / 400);
	}

	public static int getMo(int month) {
		return month + 12 * ((14 - month) / 12) - 2;
	}

	public static int getDo(int day, int mo, int x) {
		return (day + x + ((31 * mo) / 12)) % 7;
	}

	// untested
	public static int checkInput(int input, String mode, Scanner scan) {
		switch (mode) {
		case "month":
			if (!(input <= 12 && input >= 1)) {
				System.out.println("in the Month if statment");
				do {
					System.out.print("Bro there's no " + input + "th month, please enter a number from 1-12.");
					input = scan.nextInt();
				} while (!(input <= 12 && input >= 1));
			}
			return input;
		case "date":
			if (!(input <= 31 && input >= 1)) {
				do {
					System.out.print("Bro there's no " + input + "th date, please enter a number from 1-31.");
					input = scan.nextInt();
				} while (!(input <= 31 && input >= 1));
			}
			return input;
		case "year":
			if (!(input > 0)) {
				do {
					System.out.print("Bro there's no " + input + "th year, please enter a number from 1-12.");
					input = scan.nextInt();
				} while (!(input > 0));
			}
			return input;
		}
		return input;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int month = Integer.parseInt(args[0]);
		month = checkInput(month, "month", scan);
		System.out.println("Month is " + month);// temp
		int day = Integer.parseInt(args[1]);
		day = checkInput(day, "date", scan);
		System.out.println("Day is " + day);// temp
		int year = Integer.parseInt(args[2]);
		year = checkInput(year, "year", scan);
		System.out.println("Year is " + year);// temp

		String[] daysOfTheWeek = { "Sunday", "Monday", "Tuesday", "Wednsday", "Thrusday", "Friday", "Saturday" };

		int yO = getYo(year, month);
		System.out.println("yO is " + yO);
		int x = getX(yO);
		System.out.println("x is " + x);
		int mO = getMo(month);
		System.out.println("mO is " + mO);
		int dO = getDo(day, mO, x);
		System.out.println("dO is " + dO);

		if (dO <= 6 && dO >= 0)
			System.out.println(daysOfTheWeek[dO]);
		else
			System.out.println("error!");

	}

}