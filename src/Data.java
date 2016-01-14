
public class Data {
	private String string;
	private double doub;
	
	public Data (String number) {
		this.string = number;
		this.doub = Double.parseDouble(number);
	}
	
	public String getString() {
		return string;
	}
	
	public void setString(String string) {
		this.string = string;
	}
	
	public double getDoub() {
		return doub;
	}
	
	public void setDoub(double doub) {
		this.doub = doub;
	}

}
