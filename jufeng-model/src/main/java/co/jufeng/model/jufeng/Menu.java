package co.jufeng.model.jufeng;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import co.jufeng.core.util.StringUtils;
import co.jufeng.core.util.Transcoding;
import co.jufeng.dao.hibernate.strategy.EntityStrategyAuto;

@Entity(name = "JF_MENU")
public class Menu extends EntityStrategyAuto {

	private static final long serialVersionUID = -7172800519670240409L;

	/**
	 * 中文简体名称
	 */
	@Column(name = "CN_NAME", nullable = false, length = 100)
	private String cnName = "飓丰软件";
	
	/**
	 * 英文名称
	 */
	@Column(name = "US_NAME", nullable = false, length = 100)
	private String usName = UUID.randomUUID().toString().substring(0, 5);
	
	/**
	 * 韩文名称
	 */
//	@Lob
	@Column(name = "KR_NAME", length = 100)
	private String krName = Transcoding.utf8ToUnicode("광주펭소프트웨어");
	
	/**
	 * 默认访问菜单栏
	 */
	@Column(name = "DEFAULT_MENU", length = 100)
	private String defaultMenu = "defaultMenu";
	
	/**
	 * 访问URL
	 */
	@Column(name = "URL")
	private String url;
	
	/**
	 * 是否显示
	 */
	@Column(name = "IS_SHOW")
	private boolean isShow;
	
	/**
	 * 显示位置
	 */
	@Column(name = "LOCATION")
	private int location = 255;
	
	/**
	 * 描述当前菜单属于哪个菜单下的
	 */
	@ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID",  updatable = true, nullable = true)
	private Menu menu;
	
	/**
	 * 子菜单
	 * 集合按id排序.
	 * 集合中对象的id的缓存.
	 */
	@OrderBy("location")
	@OneToMany(mappedBy = "menu", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@MapKey(name="usName")
	private Map<String, Menu> children = new LinkedHashMap<String, Menu>(); 
	
	/**
	 * 系统码
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SYSTEM_CODE_ID", updatable = true, nullable = true)
	private SystemCode systemCode;
	
	public Menu(){
	}
	
	public Menu(Long id) {
		this.setId(id);
	}

	public Menu(String cnName) {
		this.cnName = cnName;
	}
	
	public String getDefaultMenu() {
		return defaultMenu;
	}

	public void setDefaultMenu(String defaultMenu) {
		this.defaultMenu = defaultMenu;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getUsName() {
		return usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
	}

	public String getKrName() {
		if(null != krName){
			return Transcoding.unicodeToUtf8(krName);
		}
		return krName;
	}

	public void setKrName(String krName) {
		if(null != krName){
			this.krName = StringUtils.replaceBlank(Transcoding.utf8ToUnicode(krName));
		}
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(boolean isShow) {
		this.isShow = isShow;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}

	public Map<String, Menu> getChildren() {
		return children;
	}

	public void setChildren(Map<String, Menu> children) {
		this.children = children;
	}

	public SystemCode getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(SystemCode systemCode) {
		this.systemCode = systemCode;
	}
	
	

}
