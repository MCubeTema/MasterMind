package java.main.Domain;

public class Code {
	
	private String code;
	
	public Code () {
		this.code = "0000"; 	
	}

	public Code (String code) {
		this.code = code; 
	}
	
	public void setCode (String inCode) {
		code = inCode; 
	}
	
	public String getCode () {
		return code; 
	}
	
	public boolean compatibleCode (String inCode) {
		//To do
		return true; 
	}		
}
