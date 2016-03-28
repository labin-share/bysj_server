package controller;

import java.io.IOException;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import service.SheetService;
import common.BeanAssistant;

@Controller
@RequestMapping("/sheet")
public class SheetController {
	SheetService sheetService = BeanAssistant.getBean(SheetService.class);

	// not test
	@RequestMapping("/createNewSheet")
	public @ResponseBody String createNewSheet(String dtoStr, @RequestParam("imgfile") List<MultipartFile> imgfileList)
			throws JsonParseException, JsonMappingException, IOException {
		return this.sheetService.createNewSheet(dtoStr, imgfileList);
	}

	// not test
	@RequestMapping("/getSheetsEvalsByMtnId/{mtnId}")
	public @ResponseBody String getSheets(@PathVariable("mtnId")int mtnId) throws Exception {
		return this.sheetService.getSheetsEvalsByMtnId(mtnId);
	}

	// not test
	@RequestMapping("/changeState")
	public @ResponseBody String changeState(int id, int state) throws Exception {
		return this.sheetService.changeState(id, state);
	}

	// not test
	@RequestMapping("/getSheetProgress/{id}")
	public @ResponseBody String getSheetProgress(@PathVariable int id) throws Exception {
		return this.sheetService.getSheetProgress(id);
	}

	// not test
	@RequestMapping("/chargeback")
	public @ResponseBody String chargeback(String chargebackDtoStr)
			throws Exception {
		return this.sheetService.chargeback(chargebackDtoStr);
	}

	@RequestMapping("/getSheetSimpleInfo")
	public @ResponseBody String getSheetSimpleInfo(String customerId,
			String state) throws IOException {
		return this.sheetService.getSheetSimpleInfo(customerId, state);
	}

	@RequestMapping("getSheetDetailInfo")
	public @ResponseBody String getSheetDetailInfo(int sheetId)
			throws JsonProcessingException {
		return this.sheetService.getSheetDetailInfo(sheetId);
	}
	
}
