package kr.or.ddit.web.calculate;

public enum Mime {
	PlAIN("plain","text/plain;charset=UTF-8",""),
	JSON("json","application/json;charset=UTF-8","{\\\"result\\\":\\\"\"+result+\"\\"),
	HTML("html","text/html;charset=UTF-8","<p>\" + result + \"</p>");
	
	private String m;
	private String code;
	private String r;
	Mime(String m, String code, String r){
		this.m = m;
		this.code = code;
		this.r = r;
	}
	public String getM() {
		return this.m;
		
	}
	public String getCode() {
		return this.code;
	}
	public String getR() {
		return this.r;
	}

	

}
