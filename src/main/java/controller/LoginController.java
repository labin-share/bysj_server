package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.BeanAssistant;
import common.ResponseInfo;
import service.CustomerService;
import service.MantainerService;
import constant.LoginConstant;
import dto.LoginDTO;

@Controller
@RequestMapping("/login")
public class LoginController {
	private ObjectMapper mapper = new ObjectMapper();
	private MantainerService mantainerService = BeanAssistant
			.getBean(MantainerService.class);
	private CustomerService customerService = BeanAssistant
			.getBean(CustomerService.class);

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
		return this.mapper.writeValueAsString(resp);
	}

	@RequestMapping("/customerLogin")
	public @ResponseBody String customerLogin(
			@RequestParam("dtoStr") String dtoStr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginDTO dto = this.mapper.readValue(dtoStr, LoginDTO.class);
		ResponseInfo resp = this.customerService.login(dto);
		HttpSession session = request.getSession();
		if (resp.getStatus()) {
			session.setAttribute(LoginConstant.USER_NAME, resp.getData());
		}
		return this.mapper.writeValueAsString(resp);
	}

	@RequestMapping("/changeMtnPsw")
	public @ResponseBody String changeMtnPsw(@RequestParam("id") int id,
			@RequestParam("psw") String newPsw,
			@RequestParam("psw") String oldPsw) throws JsonProcessingException {
		return this.mantainerService.changePsw(id, oldPsw, newPsw);
	}

	@RequestMapping("/changeCustomerPsw")
	public @ResponseBody String changeCustomerPsw(@RequestParam("id") int id,
			@RequestParam("newPsw") String newPsw,
			@RequestParam("oldPsw") String oldPsw)
			throws JsonProcessingException {
		return this.customerService.changePsw(id, oldPsw, newPsw);
	}

	// test
	@RequestMapping("/showErr")
	public @ResponseBody String showErr(HttpServletRequest reuqest) {
		return "pls login first";
	}
}
