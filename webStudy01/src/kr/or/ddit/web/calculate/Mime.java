package kr.or.ddit.web.calculate;

public enum Mime {
	
	HTML("text/html; charset=UTF-8" , new RealMime() {
		@Override
		public String outResult() {
			return "<p>" + "%s" + "</p>";
		}
	}),

	XML("application/xml; charset=UTF-8", () ->{
		return null;
	}),
	
	JSON("application/json; charset=UTF-8", () ->{
		return "{\"result\" :\"" +"%s"+"\"}";
	}),
	
	PLAIN("text/plain; charset=UTF-8", () ->{
		return "%s";
	});
	
	String mime;
	RealMime realMime;
	
	private Mime(String mime , RealMime realMime) {
		this.mime = mime;
		this.realMime = realMime;
	}
	
	public String getResult() {
		return realMime.outResult();
	}
	
	public String getContentType() {
		return mime;
	}
	
}
