package co.jufeng.core.enums;

public enum OutTypeEnum {
	
	TEXT("text/plain"), HTML("text/html"), XML("text/xml"), JSON("text/html");
	
	public final String value;

	public String getValue() {
		return value;
	}
	
	OutTypeEnum(String value) {
		this.value = value;
	}

}
