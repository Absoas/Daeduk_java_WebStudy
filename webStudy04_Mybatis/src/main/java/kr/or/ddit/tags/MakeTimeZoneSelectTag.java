package kr.or.ddit.tags;

import java.io.IOException;
import java.util.TimeZone;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MakeTimeZoneSelectTag extends SimpleTagSupport {
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	private String onchangeFuncName;
	public void setOnchangeFuncName(String onchangeFuncName) {
		this.onchangeFuncName = onchangeFuncName;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer selectTag = new StringBuffer();
		String pattern = "<option value='%s'>%s</option>\n";
		selectTag.append("<select name='"+name+"'");
		if(onchangeFuncName!=null) {
			selectTag.append(" onchange='"+onchangeFuncName+"(event);'");	
		}
		selectTag.append(">\n");
		selectTag.append(String.format(pattern, "", "로케일 선택"));
		String[] zoneIds = TimeZone.getAvailableIDs();
		for(String zoneId : zoneIds) {
			selectTag.append(
				String.format(pattern, zoneId, 
						TimeZone.getTimeZone(zoneId).getDisplayName()));
		}
		selectTag.append("</select>\n");
		getJspContext().getOut().print(selectTag);
	}
	
}













