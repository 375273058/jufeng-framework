package co.jufeng.core.factory.action.inject;

import java.io.Serializable;
import java.util.Set;

public interface Container extends Serializable {

	public final static String DEFAULT_NAME = "default";

	public void inject(Object o);

	public <T> T inject(Class<T> implementation);

	public <T> T getInstance(Class<T> type, String name);

	public <T> T getInstance(Class<T> type);
  
	public Set<String> getInstanceNames(Class<?> type);

	public void removeScopeStrategy();
}