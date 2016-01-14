import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// Variables and objects
		final String ADDITION = "+";
		final String SUBTRACTION = "-";
		final String MULTIPLICATION = "*";
		final String DIVISION = "/";
		boolean numberMode = true;
		List<Data> elements = new ArrayList<Data>();
		
		Scanner sc = new Scanner(System.in);

		// Instruction
		System.out.println("Enter a number. Press enter twice when done.");

		// Calculation
		while (true) {
			String temp = "";
			temp = sc.nextLine();
			temp = temp.replaceAll(" ", "");
			// System.out.println(temp);

			if (temp.equals(""))
				break;

			if (!temp.substring(temp.lastIndexOf("+") + 1).equals("")) {
				if (temp.contains(ADDITION)) {
					addNewElement(temp, elements, ADDITION);
					break;
				} else if (temp.contains(SUBTRACTION)) {
					addNewElement(temp, elements, SUBTRACTION);
					break;
				} else if (temp.contains(MULTIPLICATION)) {
					addNewElement(temp, elements, MULTIPLICATION);
					break;
				} else if (temp.contains(DIVISION)) {
					addNewElement(temp, elements, DIVISION);
					break;
				}
			} else {

				if (numberMode) {
					elements.add(new Data(temp));
				} else {
					Operations.setOperator(temp);
				}
				numberMode = numberMode ? false : true;
			}

		}

		pickOperation(Operations.getOperator(), elements);
	}

	private static void pickOperation(String operator, List<Data> elements) {
		switch (operator) {
		case "+":
			System.out.println(Operations.add(elements));
			break;
		case "-":
			System.out.println(Operations.subtract(elements));
			break;
		case "*":
			System.out.println(Operations.multiply(elements));
			break;
		case "/":
			System.out.println(Operations.divide(elements));
			break;
		}
	}

	private static void addNewElement(String newElement, List<Data> elements, String operator) {
		for (int i = 0; i < newElement.length(); i += 2) {
			elements.add(new Data(newElement.substring(i, i + 1)));
			Operations.setOperator(operator);
		}
	}
}