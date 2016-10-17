import java.lang.Math;

/*
 * This code is to solve Pepys problem, by brute forcing the problem 
 */
public class Pepys {

	/**
	 * This get the likelihood that you'll get 1 at least once rolling a six
	 * sided six times.
	 */
	public static double testCase1() {
		double counter = 0;

		for (int i = 0; i < 100000; i++) {
			for (int j = 0; j < 6; j++) {
				if ((int) ((Math.random() * 7) + 1) == 1) {
					counter++;
					break;
				}
			}
		}

		return counter;
	}

	/**
	 * This code test the likely hood of 1 twice when rolling a fair die 12
	 * times
	 * 
	 */
	public static double testCase2() {

		double counter = 0;
		int seen2x = 0;
		for (int i = 0; i < 100000; i++) {
			for (int j = 0; (j < 12) && (seen2x < 2); j++) {
				if ((int) ((Math.random() * 7) + 1) == 1) {
					seen2x++;
				}
				if (seen2x == 2) {
					counter++;
					seen2x = 0;
					break;
				}
			}
		}

		return counter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((testCase2() > testCase1())
				? "Your more likeily to get 2 rolls of the one side of cube in set of 12 rolls"
				: "Your more likeily to get 1 roll of the one side of cube in set of 6 rolls");
	}
}
