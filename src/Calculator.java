public class Calculator {

	public static void main(String[] args) {

		String str = "3 + 6 * 5 + ( 1 - 5 )";
		InfixConverter ic = new InfixConverter(str);
		ic.convert();		
		
		System.out.println(ic.getPostfixString());

	}
}