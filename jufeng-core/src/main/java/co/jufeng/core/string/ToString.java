package co.jufeng.core.string;

public class ToString {
	
	@Override
	public String toString() {
		return co.jufeng.core.string.ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE_MAP);
	}

}
