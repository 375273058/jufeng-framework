package co.jufeng.model.jufeng;

import javax.persistence.Column;
import javax.persistence.Entity;

import co.jufeng.dao.hibernate.strategy.EntityStrategyAutoNullDate;

@Entity(name = "JF_STATUS")
public class Status  extends EntityStrategyAutoNullDate {

	private static final long serialVersionUID = 3750084715243134310L;
	
	@Column(name = "STATUS_NAME", length = 20, unique = true)
	private String statusName;

	public Status() {
	}
	
	public Status(Long id) {
		this.setId(id);
	}

	public Status(String statusName) {
		this.statusName = statusName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}


}
