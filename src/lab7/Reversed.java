package lab7;

import java.util.Stack;

public class Reversed {

	Reversed() {
		super();
	}

	static {
		System.out.println("Executing before main method");

	}

	public static void main(String[] args) {
		String word = "we test coders";
		System.out.println("Reversed: " + reverse(word));
		String word2 = "I love Algorithms course";
		System.out.println("Reversed: " + reverse(word2));
		String word3 = "I've got A grade in Algorithms";
		System.out.println("Reversed: " + reverse(word3));
	}

	private static String reverse(String word) {
		StringBuffer sb = new StringBuffer();
		Stack<String> st = new Stack<>();
		if (null != word && !word.equals("")) {
			for (int i = 0; i < word.length(); i++) {// Traversing the given String cost = Theta of (n)
				char var = word.charAt(i);
				if (var != ' ') {
					st.push(String.valueOf(var));// Pushin the elements cost = Theta of (n)
				} else {
					while (!st.isEmpty()) { // Loop to empty out the Stack cost = Theta of (n)
						sb = sb.append((String) st.pop());// Appending the elements to the StringBuffer cost = Theta of
															// (n)
					}
					sb.append(" ");
				}
			}
			while (!st.isEmpty()) { // Traversing the stack to empty it out cost = Theta of n
				sb = sb.append((String) st.pop()); // Appending the elements to the StringBuffer cost = Theha of n
			}
		}
		return sb.toString();
	}
}
