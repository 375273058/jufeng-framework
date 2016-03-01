package co.jufeng.core.enums;

public enum ActionWrapperTypeEnum {

	REQUEST {
		public String toMatchString(String pattern) {
			return pattern;
		}
	},
	
	RESPONSE {
		public String toMatchString(String pattern) {
			return pattern;
		}
	},
	
	PRINT_WRITER {
		public String toMatchString(String pattern) {
			return pattern;
		}
	},


	SESSION {
		public String toMatchString(String pattern) {
			return pattern;
		}
	};

	public abstract String toMatchString(String pattern);

}
