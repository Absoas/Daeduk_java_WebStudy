package kr.or.ddit.weather.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.json.XML;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetAirInfo {
	
	final String API_KEY = "RiRhW5gyS8VRPtTKn0oYUJwUF3JFl3rkxKBDj1XiVMzmthbnyxqLKvdedcAhXYFPtT61VQxtmRkyGcmDdaEJIw%3D%3D";

	@RequestMapping(value="air/showAir.do",method = RequestMethod.GET)
	public String doAirGet() throws IOException {
		return "weather/airList";
	}
	
	@ResponseBody
	@RequestMapping(value="air/showAir.do",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String doPost() throws IOException {
		String tempUrl = "http://openapi.airkorea.or.kr/openapi/"
				+ "services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst" 
				+ "?itemCode=PM10"
				+ "&dataGubun=HOUR"			// 일평균 , 시간 별로 측정
				+ "&searchCondition=MONTH&pageNo=1&numOfRows=1"
				+ "&ServiceKey="+API_KEY+"";
		return getData(tempUrl);
	}
	
	@RequestMapping(value="weather/showWeather.do",method = RequestMethod.GET)
	public String doWeatherGet() throws IOException {
		return "weather/weatherList";
	}
	
	@ResponseBody
	@RequestMapping(value="weather/showWeather.do",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String getWeatherToXml(@RequestParam(required=false)Date date) throws IOException{
		
//		해당 날짜 데이터 조회
//		if(date!=null){
//			SimpleDateFormat test0 = new SimpleDateFormat("yyyy-MM-dd");
//			System.out.println(	test0.format(date));
//		}
		
		String tempUrl = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108"; 
		return getData(tempUrl);
	}
	
	
	public String getData(String tempUrl) throws IOException{
		StringBuffer buffer = new StringBuffer();
		
		
		URL url = new URL(tempUrl);
		 
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestProperty("CONTENT-TYPE","text/xml"); 
		
		try(
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		){
			
			String inputLine;
			
			// 페이지의 정보를 저장한다.
			while ((inputLine = in.readLine()) != null){
				buffer.append(inputLine.trim());
			}
			//XML에서 JSON 변환 org.json API 활용
			//추가 보완 사항 : JSON 데이터로 올때 판별 가능 해야함
			//XML 로만 와야한다는 단점 존재
			
			org.json.JSONObject xmlJSONObj = XML.toJSONObject(buffer.toString());
            String jsonPrettyPrintString = xmlJSONObj.toString(4);
			return jsonPrettyPrintString;
		}
	}
}
