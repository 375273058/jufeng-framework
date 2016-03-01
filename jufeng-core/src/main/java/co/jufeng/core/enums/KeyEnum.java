package co.jufeng.core.enums;

public enum KeyEnum {

	BASE_PATH("basePath"),
	
	ADMIN_SKIN("adminSkin"),
	
	CLIENT_SKIN("clentSkin"),
	
	COMMON_ALL_CONTEXT("commonAllContext"),

	SESSION_ID("sessionId"),
	
	USER_NAME("userName"),

	PASSWORD("password"),
	
	LANGUAGE("language"),
	
	PRIVILEGE_SYSTEM("privilegeSystem"),
	
	LANGUAGE_SUFFIX("languageSuffix"),
	
	LOGIN_SUCCESS("loginSuccess"),
	
	I18N_NO_KEY_WARNING("i18nNoKeyWarning");
	
	private final String value;

	public String getValue() {
		return value;
	}

	KeyEnum(String value) {
		this.value = value;
	}

}
