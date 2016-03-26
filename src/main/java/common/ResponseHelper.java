package common;


public interface ResponseHelper {

	public ResponseInfo getResponseInfo();

	public String buildRespJson(boolean status, String msg, String data)
			throws Exception;

}
