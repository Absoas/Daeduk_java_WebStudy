<%@page import="java.text.DateFormatSymbols"%>
<%@page import="sun.util.resources.LocaleData"%>
<%@page import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.DayOfWeek"%>
<%@page import="java.time.Month"%>
<%@page import="java.time.YearMonth"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력</title>
</head>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>

<script type="text/javascript">
	$(function() {
		$("[name='lang']").on("change", function() {
			document.langForm.submit();
		});
	});
</script>

<style>
	table{
		border: 1px solid;
	}
	td{
		border : 1px solid;
		text-align: center;
	}
</style>

<%
	Locale[] locales = Locale.getAvailableLocales();
	String lang = request.getParameter("lang");
	Locale currentLocale = request.getLocale();
	if(lang!= null && lang.trim().length()!=0){
		currentLocale = Locale.forLanguageTag(lang);
	}
%>


<%
    Calendar cal = Calendar.getInstance();

	int currentYear = cal.get(Calendar.YEAR);
	int currentMonth = cal.get(Calendar.MONTH);
	int currentDate = cal.get(Calendar.DATE);

	String yearStr = request.getParameter("year");
	String monthStr = request.getParameter("month");
	
	int year;
	int month;
	
	if(yearStr==null || monthStr == null || !yearStr.matches("\\d*") || Integer.parseInt(monthStr)>12){
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
	}else{
		year = Integer.parseInt(yearStr);
		month = (Integer.parseInt(monthStr)) - 1;
	}

	cal.set(year, month, 1);
	int bgnWeek = cal.get(Calendar.DAY_OF_WEEK);

	int prevYear = year;
	int prevMonth = (month + 1) - 1;
	int nextYear = year;
	int nextMonth = (month + 1) + 1;
	
	if (prevMonth < 1) {
		prevYear--;
		prevMonth = 12;
	}

	if (nextMonth > 12) {
		nextYear++;
		nextMonth = 1;
	}
%>
<body>
	<form action="./calendar.jsp" method="get">
		연도  : <input type="number" name="year" style="width: 75px;">
		월    : <input type="number" min="1" max="12" name="month" style="width: 75px;">
		<input type="submit" value="검색"><br><br><br>
	</form>


	<form name="langForm">
		언어 선택 : <select name="lang">
			<option value="">언어 선택</option>
			<%
					String optPattern = "<option value = '%s' %s>%s</option>";
					for (Locale tmp : locales) {
						String value = tmp.toLanguageTag();
						String text = tmp.getDisplayLanguage();
						String selected = "";
						if (currentLocale.equals(tmp)) {
							selected = "selected";
						}
						if (text != null && text.trim().length() != 0) {
							out.println(String.format(optPattern, value, selected, text));
						}
					}
		
				%>
		</select>
	</form>

	<br>
	<br>

	<table>
		<tr>
			<td><a href="./calendar.jsp?year=<%=prevYear%>&month=<%=prevMonth%>">&lt;</a></td>
			<td><%=year%>  <%=cal.getDisplayName(Calendar.MONTH, Calendar.LONG, currentLocale)%></td>
			<td><a href="./calendar.jsp?year=<%=nextYear%>&month=<%=nextMonth%>">&gt;</a></td>
		</tr>
	</table>
	
	<table>
		<tr>
			<%
				Locale locale = request.getLocale();
				DateFormatSymbols dfs = new DateFormatSymbols(currentLocale);
				String[] weekdays = dfs.getWeekdays();
				
				for (int i = 1; i < weekdays.length; i++) {
					out.println("<td>" + weekdays[i] + "</td>");
				}
			%>
		</tr>

		<tr>
			<%
				for (int i = 1; i < bgnWeek; i++) {
					out.println("<td>&nbsp;</td>");
				}

				while (cal.get(Calendar.MONTH) == month) {

					if (cal.get(Calendar.YEAR) == currentYear && cal.get(Calendar.MONTH) == currentMonth
							&& cal.get(Calendar.DATE) == currentDate) {
						out.println("<td bgcolor=\"#FF0000\">" + cal.get(Calendar.DATE) + "</td>");
					} else {
						out.println("<td>" + cal.get(Calendar.DATE) + "</td>");
					}

					if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
						out.println("</tr><tr>");
					}
					cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE) + 1);
				}

				for (int i = cal.get(Calendar.DAY_OF_WEEK); i <= 7; i++) {
					out.println("<td>&nbsp;</td>");
				}
			%>
		</tr>
	</table>
</body>
</html>
