package co.jufeng.model.exception;
/**
 * 数据模型内部异常
 */
public class ModelBusinessException extends RuntimeException {

	private static final long serialVersionUID = 177215111821874260L;

	private int code;
	
	private String description;
	
	public ModelBusinessException() {
        super();
    }
	
    public ModelBusinessException(int code, String description) {
        super(description);
        this.code = code;
        this.description = description;
    }

    public ModelBusinessException(int code, String description, Throwable cause) {
        super(description, cause);
        this.code = code;
        this.description = description;
    }

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}