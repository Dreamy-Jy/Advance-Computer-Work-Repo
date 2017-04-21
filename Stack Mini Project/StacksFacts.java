import java.util.Arrays;
import java.util.Stack;

/*
 * made by Jordane Thomas
 * Takes in strings from the command line, as an array, and spites them out in reverse order.
 */
public class StacksFacts {

	public static void main(String[] args) {

		Stack<String> stc = new Stack<String>();
		for(String s: args)
			stc.push(s);

		while (stc.size() > 0)
			System.out.print(stc.pop() + " ");
		System.out.print("\n");
	}

}
