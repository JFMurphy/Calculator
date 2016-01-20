
public class Operator {
	private String type;
	private int level;
	
	public Operator(String type) {
		this.type = type;
		
		char temp = this.type.charAt(0);
		
		switch (temp) {
		case '+':
		case '-':
			this.level = 1;
			break;
		case '*':
		case '/':
			this.level = 2;
			break;
		default: 
			this.level = 0;
			break;
		}
	}

	public int getLevel() {
		return level;
	}

	public String getType() {
		return type;
	}
}
