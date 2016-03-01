package co.jufeng.core.webservice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class AuthenticateResult implements ISession{
	
	private String id = UUID.randomUUID().toString();;
	private long creationTime = System.currentTimeMillis();
	private boolean invalid = false;
	private Map<Object, Object> attributes = new LinkedHashMap<Object, Object>();

	public String getId() {
		return id;
	}

	@Override
	public long getCreationTime() {
		assertIsValid();
		return this.creationTime;
	}
	
	public boolean isInvalid() {
		return this.invalid;
	}
	
	private void assertIsValid() {
		if (isInvalid()) {
			throw new IllegalStateException("The session has already been invalidated");
		}
	}

	@Override
	public void invalidate() {
		assertIsValid();
		this.invalid = true;
		clearAttributes();
	}
	
	/**
	 * Clear all of this session's attributes.
	 */
	public void clearAttributes() {
		this.attributes.clear();
	}
	
	public Object getAttribute(String name) {
        return this.attributes.get(name);
    }
	
	public void setAttribute(String name, Object value) {
        if (value == null) {
        	this.attributes.remove(name);
        } else {
        	this.attributes.put(name, value);
        }
    }
}