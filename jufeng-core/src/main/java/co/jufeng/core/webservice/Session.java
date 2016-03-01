package co.jufeng.core.webservice;

import java.util.Enumeration;

public interface Session{
   public Object get(String key);
   public void set(String key, Object value);
   public void remove(String key);
   public Enumeration<?> getKeys();
   public void setTimeout(int timeout);
   public int getTimeout();
   public void touch();
   public void invalidate();
   public Object getLockObject();
}