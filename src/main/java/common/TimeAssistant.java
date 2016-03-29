package common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeAssistant {
	public static String FONT_TIME_FORMAT = "YYYY-MM-dd hh:mm:ss";
	public static String BACKEND_TIME_FORMAT = "YYYYMMddhhmmss";
	public static String FILE_NAME_DATE_FORMAT = "YYYYMMddhhmmssSS";

	public static String toFontFormat(String time) throws ParseException {
		DateFormat fontFormat = new SimpleDateFormat(FONT_TIME_FORMAT);
		DateFormat backendFormat = new SimpleDateFormat(BACKEND_TIME_FORMAT);
		Date date = backendFormat.parse(time);
		return fontFormat.format(date).toString();
	}

	public static String toBackendFormat(String time) throws ParseException {
		DateFormat fontFormat = new SimpleDateFormat(FONT_TIME_FORMAT);
		DateFormat backendFormat = new SimpleDateFormat(BACKEND_TIME_FORMAT);
		Date date = fontFormat.parse(time);
		return backendFormat.format(date).toString();
	}

}
