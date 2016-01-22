import java.util.StringTokenizer;
import java.util.Stack;

public class Calculator {

	private String postfixString;
	
	public void calculate(String input) {
		InfixConverter ic = new InfixConverter();
		ic.convert(input);
		postfixString = ic.getPostfixString();
		
		StringTokenizer tokenizer = new StringTokenizer(postfixString, " ");
		
		while (tokenizer.hasMoreTokens()) {
			processToken(tokenizer.nextToken());
		}
		
				
	}
	
	private void processToken(String token) {
		
	}
}