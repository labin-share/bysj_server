package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.SheetService;
import common.BeanAssistant;

@Controller
@RequestMapping("/sheet")
public class SheetController {
	SheetService sheetService = BeanAssistant.getBean(SheetService.class);

	@RequestMapping("/createNewSheet")
	public @ResponseBody String createNewSheet(String dtoStr) {
		return this.createNewSheet(dtoStr);
	}
}
