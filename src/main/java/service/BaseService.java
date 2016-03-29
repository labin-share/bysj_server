package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.ResponseHelper;
import common.ResponseInfo;

@Service
public class BaseService implements ResponseHelper {
	public static String EMPTY = "";
	@Autowired
	private ObjectMapper mapper;

	public ObjectMapper getMapper() {
		return this.mapper;
	}

	public ResponseInfo getResponseInfo() {
		return new ResponseInfo();
	}

	public String buildRespJson(boolean status, String msg, String data)
			throws JsonProcessingException {
		ResponseInfo resp = this.getResponseInfo();
		resp.setData(data);
		resp.setMsg(msg);
		resp.setStatus(status);
		return this.mapper.writeValueAsString(resp);
	}

}
