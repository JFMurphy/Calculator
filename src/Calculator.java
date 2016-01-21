public class Calculator {

	public static void main(String[] args) {

		String str = "4+5*56+695-5";
		InfixConverter ic = new InfixConverter(str);
		ic.convert();		
		
		System.out.println(ic.getPostfixString());

	}
}