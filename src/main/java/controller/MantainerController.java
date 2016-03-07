package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import service.MantainerService;
import common.BeanAssistant;
import dto.MantainerDTO;

@Controller
@RequestMapping("/mtn")
public class MantainerController {
	private ObjectMapper mapper = new ObjectMapper();
	private MantainerService mantainerService = BeanAssistant
			.getBean(MantainerService.class);
	
	@RequestMapping("/getInfo/{id}")
	public @ResponseBody String getInfo(@PathVariable("id")int id) throws JsonProcessingException{
		MantainerDTO mantainerDto = this.mantainerService.findById(id); 
		return this.mapper.writeValueAsString(mantainerDto);
	}

}
