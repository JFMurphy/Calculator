import java.util.Stack;
import java.util.StringTokenizer;

public class InfixConverter extends TypeCheck {

	Stack<StackToken> opStack = new Stack<StackToken>();

	private String input;
	private String postfixString = "";

	public InfixConverter(String input) {
		this.input = input;
	}

	public String convert() {
		// Stack<String> stack = new Stack<String>();
		StringTokenizer st = new StringTokenizer(input, " ");

		while (st.hasMoreElements()) {
			String token = st.nextToken();

			// Single digit, Check if type is digit or operator.
			if (token.length() == 1) {
				char temp = token.charAt(0);

				// Digit
				if (Character.isDigit(temp)) {
					addToOutputQueue(token);
				}
				// Operator
				else if (isOperator(temp)) {
					processOperator(token);
				}
				// Parenthesis
				else if (isParenthesis(temp)) {
					processParenthesis(token);
				}
			}
			// More than one digit. Can only be number
			else {
				addToOutputQueue(token);
			}
		}

		while (opStack.size() != 0) {
			addToOutputQueue(opStack.pop().getType());
		}

		return postfixString;
	}

	private void addToOutputQueue(String token) {
		postfixString += token + " ";
	}

	private void processOperator(String token) {
		StackToken operator = new StackToken(token);

		// While there is an operator at the top of the stack.
		while (opStack.size() > 0 && isOperator(opStack.peek().getType().charAt(0))) {

			// If new operator is of lower precedence than operator at top.
			if (operator.getLevel() <= opStack.peek().getLevel()) {
				// Pop onto queue
				addToOutputQueue(opStack.pop().getType());
			} else {
				break;
			}
		}

		opStack.push(operator);
	}

	private void processParenthesis(String token) {
		char temp = token.charAt(0);

		if (temp == '(')
			opStack.push(new StackToken(token));
		else {
			while (!opStack.peek().getType().equals("(")) {
				addToOutputQueue(opStack.pop().getType());
			}

			if (opStack.peek().getType().equals("("))
				opStack.pop();
		}
	}

	/*
	 * private boolean isOperator(char token) { switch (token) {
	 * 
	 * case '/': case '*': case '-': case '+': case '(': case ')': return true;
	 * 
	 * default: return false; }
	 * 
	 * }
	 * 
	 * private boolean isParenthesis(char token) { switch (token) {
	 * 
	 * case '(': case ')': return true; default: return false; } }
	 */

	public String getPostfixString() {
		return postfixString;
	}

}
