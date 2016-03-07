package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.BeanAssistant;
import common.ResponseAssistant;
import common.ResponseInfo;
import service.LoginService;
import service.MantainerService;
import constant.LoginConstant;
import dao.LoginDao;
import dto.LoginDTO;

@Controller
@RequestMapping("/login")
public class LoginController {
	private ObjectMapper mapper = new ObjectMapper();
	private MantainerService mantainerService = BeanAssistant
			.getBean(MantainerService.class);

	@RequestMapping("/MTNLogin")
	public @ResponseBody String mtnLogin(@RequestParam("dtoStr") String dtoStr,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginDTO dto = this.mapper.readValue(dtoStr, LoginDTO.class);
		ResponseInfo resp = this.mantainerService.login(dto);
		HttpSession session = request.getSession();
		if (resp.getStatus()) {
			session.setAttribute(LoginConstant.USER_NAME, resp.getData());
		}
		return ResponseAssistant.buildJackson(resp);
	}
	
//	@RequestMapping("/MTNLogin")
//	public @ResponseBody String customerLogin(@RequestParam("dtoStr") String dtoStr,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		LoginDTO dto = this.mapper.readValue(dtoStr, LoginDTO.class);
//		ResponseInfo resp = this.mantainerService.login(dto);
//		HttpSession session = request.getSession();
//		if (resp.getStatus()) {
//			session.setAttribute(LoginConstant.USER_NAME, resp.getData());
//		}
//		return ResponseAssistant.buildJackson(resp);
//	}

	@RequestMapping("/forgotPsw")
	public @ResponseBody String forgotPsw(HttpServletRequest reuqest, HttpServletResponse response) {
		return "";
	}
	
	//test
	@RequestMapping("/showErr")
	public @ResponseBody String showErr(HttpServletRequest reuqest) {
		return "pls login first";
	}
}
