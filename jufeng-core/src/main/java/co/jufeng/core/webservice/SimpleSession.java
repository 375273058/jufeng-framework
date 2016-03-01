package co.jufeng.core.webservice;

import java.util.Enumeration;
import java.util.Hashtable;

public class SimpleSession implements Session {

	private Hashtable<String, Object> rep = null;
	private int timeout = -1;
	private long lastTouched;

	public SimpleSession() {
		lastTouched = System.currentTimeMillis();
	}

	public Object get(String key) {
		if (rep == null) {
			return null;
		}
		lastTouched = System.currentTimeMillis();
		return rep.get(key);
	}

	public void set(String key, Object value) {
		synchronized (this) {
			if (rep == null) {
				rep = new Hashtable<String, Object>();
			}
		}
		lastTouched = System.currentTimeMillis();
		rep.put(key, value);
	}

	public void remove(String key) {
		if (rep != null) {
			rep.remove(key);
		}
		lastTouched = System.currentTimeMillis();
	}

	public Enumeration<?> getKeys() {
		if (rep != null) {
			return rep.keys();
		}
		return null;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getTimeout() {
		return timeout;
	}

	public void touch() {
		lastTouched = System.currentTimeMillis();
	}

	public void invalidate() {
		rep = null;
		lastTouched = System.currentTimeMillis();
		timeout = -1;
	}

	public long getLastAccessTime() {
		return lastTouched;
	}

	public synchronized Object getLockObject() {
		if (rep == null) {
			rep = new Hashtable<String, Object>();
		}
		return rep;
	}
}