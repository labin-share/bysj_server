package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.RegisterService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.BeanAssistant;
import common.ResponseAssistant;
import common.ResponseInfo;
import dto.RegisterDTO;

@Controller
@RequestMapping("register")
public class RegisterController {
	ObjectMapper mapper = new ObjectMapper();
//	RegisterService registerService = new RegisterService();
	RegisterService registerService=BeanAssistant.getBean(RegisterService.class);

	@RequestMapping("registerNew")
	public @ResponseBody String register(String dtoStr) throws Exception {
		RegisterDTO registerDto = this.mapper.readValue(dtoStr,
				RegisterDTO.class);
		ResponseInfo resp = this.registerService.register(registerDto);
		return ResponseAssistant.buildJackson(resp);
	}
}
