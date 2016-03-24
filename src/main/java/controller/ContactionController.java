package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import service.ContactionService;
import common.BeanAssistant;

@Controller
@RequestMapping("/contaction")
public class ContactionController {
	private ContactionService contactionService = BeanAssistant
			.getBean(ContactionService.class);

	// not test
	@RequestMapping("/getByCustomer/{id}")
	public @ResponseBody String getByCustomer(@PathVariable("id") String id)
			throws JsonProcessingException {
		return this.contactionService.findByCustomer(id);
	}

	// not test
	// @RequestMapping("/modifyContaction")
	// public @ResponseBody String modifyContaction(String contactionDtoStr)
	// throws Exception {
	// return this.contactionService.saveContactions(contactionDtoStr);
	// }

	@RequestMapping("/saveContaction")
	public @ResponseBody String saveContaction(String dtoStr) throws Exception {
		return this.contactionService.saveContaction(dtoStr);
	}

	@RequestMapping("/setDefault/{id}")
	public @ResponseBody String setDefault(@PathVariable("id")int id) throws Exception {
		return this.contactionService.setDefault(id);
	}
}
