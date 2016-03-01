package co.jufeng.core.io;

import java.io.Serializable;
import java.net.URL;

public class File extends java.io.File implements Serializable, Comparable<java.io.File>{
	
	private static final long serialVersionUID = -3944514127250486881L;

	private URL url;
	
	private String savePath;
	
	public File(java.io.File parent, String child) {
		super(parent, child);
	}

	public File(String pathname, URL url, String savePath) {
		super(pathname);
		this.url = url;
		this.savePath = savePath;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	

	

}
