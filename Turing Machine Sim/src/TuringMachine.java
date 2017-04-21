import java.util.Stack;

/**
 * 
 */

/**
 * @author Jordane Thomas
 *
 */
public class TuringMachine {
	private int state;
	private int start;
	private char[] action;
	private ST<Character, Integer>[] next;
	private Stack <Character, Character>[] out;
	
	//infinite tape
	private Stack<Character> left;
	private Stack<Character> right;
	
	private char read(){
		if(right.isEmpty()) return '#';
		else return right.pop();
	}
	
	private void write(char c){
		right.push(c);
	}
	
	private void moveRight(){
		if (right.isEmpty())
			left.push('#');
		else left.push(right.pop());
	}
	
	private void moveLeft(){
		if (left.isEmpty())
			right.push('#');
		else right.push(left.pop());
	}
	// infinite tape
	

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
