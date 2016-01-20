import java.util.StringTokenizer;

public class Calculator {

	public static void main(String[] args) {
		
		String str = "3 + 4 * 2 / ( 1 - 5 )";
		
		//StringTokenizer st = new StringTokenizer(str);
		InfixConverter ic = new InfixConverter(str);
		
		System.out.println(ic.convert());
		
	}
}