package co.jufeng.core.javabean;

import java.io.Serializable;
import java.util.List;

import co.jufeng.core.ISerializableType;

public class SmsVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2950700367132483423L;

	private List<String> moblies;
	
	private String content;
	
	private ISerializableType serializableType;
	
	public SmsVO(List<String> moblies, String content) {
		this.moblies = moblies;
		this.content = content;
	}
	
	public SmsVO(List<String> moblies, String content, ISerializableType serializableType) {
		this.moblies = moblies;
		this.content = content;
		this.serializableType = serializableType;
	}

	public List<String> getMoblies() {
		return moblies;
	}

	public void setMoblies(List<String> moblies) {
		this.moblies = moblies;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ISerializableType getSerializableType() {
		return serializableType;
	}

	public void setSerializableType(ISerializableType serializableType) {
		this.serializableType = serializableType;
	}

	
}
