package common;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseAssistant {
	private static ObjectMapper mapper = new ObjectMapper();

	public static String buildJackson(String status, String msg, String data) {
		if (data == null) {
			data = "";
		}
		return '{' + "\"success:\"" + "\"" + status + "\"" + "," + "\"msg:\""
				+ "\"" + msg + "\"" + "\"data:\"" + "\"" + data + "\"";
	}

	public static String buildJackson(ResponseInfo resp) throws Exception {
		return mapper.writeValueAsString(resp);
	}

}
