package co.jufeng.core.enums;

public enum PropertyEnum {
	
	ALIAS("JF_");

	private final String value;

	public String getValue() {
		return value;
	}

	PropertyEnum(String value) {
		this.value = value;
	}


}
