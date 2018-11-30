package kr.or.ddit.tags;

import java.io.IOException;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MakeTimeSelectTag extends SimpleTagSupport{
	private String name;
	private String onchangeFunc;
	
	public void setOnchangeFunc(String onchangeFunc) {
		this.onchangeFunc = onchangeFunc;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer selectTag = new StringBuffer();
		String pattern = "<option value = '%s'>%s</option>\n";
		selectTag.append("<select name = '"+name+"'");
		if(onchangeFunc!=null) {
		     selectTag.append(" onchange = '"+onchangeFunc + "(event)");
		}
		selectTag.append("'>\n");
		selectTag.append(String.format(pattern,"", "타임 존 선택"));
		String[] iDs = TimeZone.getAvailableIDs();
		for(String id:iDs) {
			selectTag.append(String.format(pattern, id, TimeZone.getTimeZone(id).getDisplayName()));
		}
		selectTag.append("</select>\n");
		getJspContext().getOut().print(selectTag);
	}
}
