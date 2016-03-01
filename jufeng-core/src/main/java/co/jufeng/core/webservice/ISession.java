package co.jufeng.core.webservice;

public interface ISession {
	
	public long getCreationTime();
	
	public void invalidate();
	
	public String getId();
	
}
