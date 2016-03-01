package co.jufeng.model.jufeng;

import javax.persistence.Column;
import javax.persistence.Entity;

import co.jufeng.dao.hibernate.strategy.EntityStrategyAutoNullDate;

@Entity(name = "JF_SYSTEM_CODE")
public class SystemCode extends EntityStrategyAutoNullDate {

	private static final long serialVersionUID = 3750084715243134310L;
	
	@Column(name = "SYSTEM_NAME", length = 20, nullable = false, unique = true)
	private String systemName;

	public SystemCode() {
	}

	public SystemCode(Long id) {
		this.setId(id);
	}
	
	public SystemCode(String systemName) {
		this.systemName = systemName;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	

}
