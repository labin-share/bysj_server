package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.ResponseInfo;
import constant.ComConstant;
import dao.ContactionDao;
import dto.ContactionDTO;
import dtoMapper.ContactionDTOMapper;
import entity.Contaction;

@Service
public class ContactionService {

	@Autowired
	ContactionDao contactionDao;
	ObjectMapper mapper = new ObjectMapper();

	public String findByCustomer(String id) throws JsonProcessingException {
		List<Contaction> contactionList = this.contactionDao.findByCustomer(id);
		List<ContactionDTO> contactionDTOList = new ArrayList<ContactionDTO>();
		ContactionDTO contactionDTO = null;
		for (Contaction contaction : contactionList) {
			contactionDTO = ContactionDTOMapper.toDTO(contaction);
			contactionDTOList.add(contactionDTO);
		}
		return this.mapper.writeValueAsString(contactionDTOList);
	}

	public String saveContactions(String contactionsStr)
			throws JsonParseException, JsonMappingException, IOException {

		List<Contaction> contactionList = this.mapper.readValue(
				contactionsStr,
				this.mapper.getTypeFactory().constructCollectionType(
						List.class, Contaction.class));
		ResponseInfo response = new ResponseInfo();
		try {
			this.contactionDao.persistAll(contactionList);
		} catch (Exception e) {
			response.setStatus(false);
			response.setMsg(ComConstant.SYS_ERRO);
		}

		return this.mapper.writeValueAsString(response);

	}
}
