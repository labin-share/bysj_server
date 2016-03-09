package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.CustomerService;
import service.MantainerService;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.BeanAssistant;

@Controller
@RequestMapping("register")
public class RegisterController {
	ObjectMapper mapper = new ObjectMapper();
	private MantainerService mantainerService = BeanAssistant
			.getBean(MantainerService.class);
	private CustomerService customerService = BeanAssistant
			.getBean(CustomerService.class);

	// not test
	@RequestMapping("registerMTN")
	public @ResponseBody String registerMTN(String dtoStr) throws Exception {
		return this.mantainerService.register(dtoStr);
	}

	// not test
	@RequestMapping("/registerCustomer")
	public @ResponseBody String registerCustomer(String dtoStr) throws Exception {
		return this.customerService.register(dtoStr);
	}
}
