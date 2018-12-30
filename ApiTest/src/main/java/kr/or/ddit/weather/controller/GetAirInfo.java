package kr.or.ddit.weather.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("air/showAir.do")
public class GetAirInfo {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet() {
		return "weather/airList";
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public JSONObject doPost() throws IOException, ParseException {
        JSONParser jsonparser = new JSONParser();
        JSONObject jsonobject = (JSONObject)jsonparser.parse(getData());
        return jsonobject;
	}

	
	public String getData() throws IOException{
		BufferedInputStream reader = null;
		try {
			URL url = new URL("http://openapi.airkorea.or.kr/openapi/"
					+ "services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst" 
					+ "?itemCode=PM10&dataGubun=DAILY"
					+ "&searchCondition=MONTH&pageNo=1&numOfRows=10"
					+ "&ServiceKey=RiRhW5gyS8VRPtTKn0oYUJwUF3JFl3rkxKBDj1XiVMzmthbnyxqLKvdedcAhXYFPtT61VQxtmRkyGcmDdaEJIw%3D%3D"
					+ "&_returnType=json");
			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer();
			int i;
			byte[] b = new byte[4096];
			while ((i = reader.read(b)) != -1) {
				buffer.append(new String(b, 0, i));
			}
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}
}
