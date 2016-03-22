package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.ResponseInfo;
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

	// public String saveContactions(String contactionsStr)
	// throws JsonParseException, JsonMappingException, IOException {
	//
	// List<Contaction> contactionList = this.mapper.readValue(
	// contactionsStr,
	// this.mapper.getTypeFactory().constructCollectionType(
	// List.class, Contaction.class));
	// ResponseInfo response = new ResponseInfo();
	// try {
	// this.contactionDao.persistAll(contactionList);
	// } catch (Exception e) {
	// response.setStatus(false);
	// response.setMsg(ComConstant.SYS_ERRO);
	// }
	//
	// return this.mapper.writeValueAsString(response);
	//
	// }

	public String saveContaction(String dtoStr) throws Exception {
		Contaction contaction = this.mapper.readValue(dtoStr, Contaction.class);
		this.contactionDao.persist(contaction);
		return this.mapper.writeValueAsString(new ResponseInfo());
	}

	public String setDefault(String dtoStr) throws Exception {
		Contaction contaction = this.mapper.readValue(dtoStr, Contaction.class);
		List<Contaction> oldDefContactionList = this.contactionDao
				.findByDef(true);
		if (oldDefContactionList != null && !oldDefContactionList.isEmpty()) {
			oldDefContactionList.get(0).setDef(false);
			this.contactionDao.persist(oldDefContactionList.get(0));
		}
		this.contactionDao.persist(contaction);
		return this.mapper.writeValueAsString(new ResponseInfo());
	}
}
