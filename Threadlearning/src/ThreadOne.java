import java.util.Scanner;

/**
 * 
 */

/**
 * @author Jordane Thomas
 *
 */
public class ThreadOne extends Thread {
	String name;

	public ThreadOne(String name) {
		this.name = name;
	}

	public void run() {
		Scanner scan = new Scanner(System.in);
		System.out.println(name + ": Hi I'm a thread");
		System.out.println(name + ": My name is " + name);
		System.out.println(name + ": Tell me a number");
		int number = scan.nextInt();
		System.out.println(name + ": My number is " + number);
		scan.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadOne one = new ThreadOne("nick");
		ThreadOne two = new ThreadOne("jack");
		one.start();
		two.start();
	}

}
