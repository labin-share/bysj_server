package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.BeanAssistant;
import common.ResponseAssistant;
import common.ResponseInfo;
import service.LoginService;
import constant.LoginConstant;
import dao.LoginDao;
import dto.LoginDTO;

@Controller
@RequestMapping("/login")
public class LoginController {
	private LoginService loginService = BeanAssistant
			.getBean(LoginService.class);
	private ObjectMapper mapper = new ObjectMapper();

	@RequestMapping("/summitLogin")
	public @ResponseBody String login(@RequestParam("dtoStr") String dtoStr)
			throws Exception {
		LoginDTO dto = this.mapper.readValue(dtoStr, LoginDTO.class);
		ResponseInfo resp = this.loginService.login(dto);
		return ResponseAssistant.buildJackson(resp);
	}

	@RequestMapping("/forgotPsw")
	public @ResponseBody String forgotPsw(HttpServletRequest reuqest) {
		return null;
	}
}
