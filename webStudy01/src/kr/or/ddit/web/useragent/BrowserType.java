package kr.or.ddit.web.useragent;

public enum BrowserType {
	CHROME("chrome"),
	TRIDENT("explorer"),
	FIREFOX("Firefox"),
	OTHER("기타");
	
	private String browserName;
	
	private BrowserType(String browserName) {
		this.browserName = browserName;
	}
	
	public String getBrowserName() {
		return browserName;
	}
	
	public static BrowserType geBrowserType(String userAgent) {
		BrowserType result = OTHER; 
		BrowserType[] types = values();
		for (BrowserType tmp : types) {
			if(userAgent.toUpperCase().contains(tmp.name())) {
				result = tmp;
				break;
			}
		}
		
		return result;
	}
}
