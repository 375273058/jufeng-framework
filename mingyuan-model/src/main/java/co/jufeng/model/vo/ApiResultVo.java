package co.jufeng.model.vo;

import java.io.Serializable;

public class ApiResultVo implements Serializable {
	
	private static final long serialVersionUID = 6670482794659800003L;

	private Boolean isSuccess = true;
	
	private int code = 200;
	
	private String description = "";
	
	private Object data = "";

	public ApiResultVo() {
	}

	public ApiResultVo(Object result) {
		this.data = result;
	}
	
	public ApiResultVo(Object result, String description) {
		this.data = result;
		this.description = description;
	}

	public void respFailure(int code, String message) {
		this.code = code;
		this.description = message;
		isSuccess = false;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "ApiRspResultVo [isSuccess=" + isSuccess + ", code=" + code
				+ ", description=" + description + ", data=" + data + "]";
	}
	
}
