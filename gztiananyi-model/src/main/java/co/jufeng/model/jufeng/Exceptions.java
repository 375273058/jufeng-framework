package co.jufeng.model.jufeng;

import javax.persistence.Column;
import javax.persistence.Entity;

import co.jufeng.dao.hibernate.strategy.EntityStrategyAuto;

@Entity(name = "JF_EXCEPTIONS")
public class Exceptions extends EntityStrategyAuto {

	private static final long serialVersionUID = -5799022233822037101L;

	@Column(name = "EXCEPTION_CLASS", nullable = false)
	private String  exceptionClass;
	
//	@Lob
	@Column(name = "EXCEPTION_TYPE", length = 500, nullable = false)
	private String exceptionType;
	
	@Column(name = "NOTE_MESSAGE", length = 500, nullable = false)
	private String noteMessage;
	
	@Column(name = "EXCEPTION_LINE", nullable = false)
	private Integer exceptionLine;
	
	@Column(name = "STATUS", length = 1)
	private Integer status = 0;
	
	
	public Exceptions() {
	}
	
	public Exceptions(String exceptionClass, String exceptionType, String noteMessage, Integer exceptionLine) {
		this.exceptionClass = exceptionClass;
		this.exceptionType = exceptionType;
		this.noteMessage = noteMessage;
		this.exceptionLine = exceptionLine;
	}
	
	public Exceptions(String exceptionClass, String exceptionType, String noteMessage, Integer exceptionLine, Integer status) {
		this.exceptionClass = exceptionClass;
		this.exceptionType = exceptionType;
		this.noteMessage = noteMessage;
		this.exceptionLine = exceptionLine;
		this.status = status;
	}
	
	public String getExceptionClass() {
		return exceptionClass;
	}

	public void setExceptionClass(String exceptionClass) {
		this.exceptionClass = exceptionClass;
	}

	public String getNoteMessage() {
		return noteMessage;
	}

	public void setNoteMessage(String noteMessage) {
		this.noteMessage = noteMessage;
	}

	public Integer getExceptionLine() {
		return exceptionLine;
	}

	public void setExceptionLine(Integer exceptionLine) {
		this.exceptionLine = exceptionLine;
	}

	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
}
