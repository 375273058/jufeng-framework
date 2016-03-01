package co.jufeng.model.vo;

public class AdvertisementVO {
	
	public AdvertisementVO() {
	}

	public AdvertisementVO(String url) {
		this.url = url;
	}

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "AdvertisementVO [url=" + url + "]";
	}
	
	
}
