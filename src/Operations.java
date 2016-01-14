import java.util.List;

public class Operations {
	
	private static String operator = "";
	
	public static double add(List<Data> elements) {
		double result = 0;
		
		for (Data element : elements) {
			result += element.getDoub();
		}
		
		return result;
	}
	
	public static double subtract(List<Data> elements) {
		double result = elements.get(0).getDoub();
		
		for (int i = 0; i < elements.size() - 1; i++) {
			result -= elements.get(i+1).getDoub();
		}
		
		return result;
	}
	
	public static double multiply(List<Data> elements) {
		double result = elements.get(0).getDoub();
		
		for (int i = 0; i < elements.size() - 1; i++) {
			result *= elements.get(i+1).getDoub();
		}
		return result;
	}
	
	public static double divide(List<Data> elements) {
		double result = elements.get(0).getDoub();
		
		for (int i = 0; i < elements.size() - 1; i++) {
			result /= elements.get(i+1).getDoub(); 
		}
		return result;
	}

	public static String getOperator() {
		return operator;
	}

	public static void setOperator(String operator) {
		Operations.operator = operator;
	}
	
}
