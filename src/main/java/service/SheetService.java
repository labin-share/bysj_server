package service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.ResponseInfo;
import constant.ComConstant;
import dao.SheetDao;
import dto.SheetCreateDTO;
import dtoMapper.SheetDTOMapper;
import entity.Sheet;

@Service
public class SheetService {
	
	@Autowired
	SheetDao sheetDao;
	ObjectMapper mapper = new ObjectMapper();
	
	public String createNewSheet(String dtoStr) throws JsonParseException, JsonMappingException, IOException{
		SheetCreateDTO sheetCreateDTO = this.mapper.readValue(dtoStr, SheetCreateDTO.class);
		Sheet sheet = SheetDTOMapper.toNewSheet(sheetCreateDTO);
		ResponseInfo response = new ResponseInfo();
		try{
			this.sheetDao.persist(sheet);
		}catch(Exception e){
			response.setMsg(ComConstant.SYS_ERRO);
		}
		return this.mapper.writeValueAsString(response);
	}

}
