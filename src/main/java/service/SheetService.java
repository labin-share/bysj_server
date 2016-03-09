package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.ResponseInfo;
import constant.ComConstant;
import constant.SheetConstant;
import dao.ChargebackDao;
import dao.SheetDao;
import dao.SheetProgressDao;
import dto.SheetCreateDTO;
import dto.SheetEvalDTO;
import dtoMapper.SheetDTOMapper;
import entity.Chargeback;
import entity.Sheet;
import entity.SheetProgress;

@Service
public class SheetService {

	@Autowired
	SheetDao sheetDao;
	@Autowired
	SheetProgressDao sheetProgressDao;
	@Autowired
	ChargebackDao chargebackDao;
	ObjectMapper mapper = new ObjectMapper();

	public String createNewSheet(String dtoStr) throws JsonParseException,
			JsonMappingException, IOException {
		SheetCreateDTO sheetCreateDTO = this.mapper.readValue(dtoStr,
				SheetCreateDTO.class);
		Sheet sheet = SheetDTOMapper.toNewSheet(sheetCreateDTO);
		ResponseInfo response = new ResponseInfo();
		try {
			this.sheetDao.persist(sheet);
		} catch (Exception e) {
			response.setMsg(ComConstant.SYS_ERRO);
		}
		return this.mapper.writeValueAsString(response);
	}

	public String getSheetsEval(String id) throws Exception {
		List<Sheet> sheetList = this.sheetDao.findByMtnId(id);
		SheetEvalDTO dto = null;
		List<SheetEvalDTO> sheetEvalDTOList = new ArrayList<SheetEvalDTO>();
		for (Sheet sheet : sheetList) {
			dto = SheetDTOMapper.toSheetsEvalDTO(sheet);
			sheetEvalDTOList.add(dto);
		}
		return this.mapper.writeValueAsString(sheetEvalDTOList);
	}

	public String changeState(int id, int state) throws Exception {
		ResponseInfo response = new ResponseInfo();
		Sheet sheet = this.sheetDao.findById(id);
		sheet.setState(state);
		this.sheetDao.persist(sheet);
		return this.mapper.writeValueAsString(response);
	}

	public String getSheetProgress(String id) throws Exception {
		List<SheetProgress> sheetProgressList = this.sheetProgressDao
				.findBySheetId(id);
		return this.mapper.writeValueAsString(sheetProgressList);
	}

	public String chargeback(String chargebackDtoStr) throws Exception {
		Chargeback chargeback = this.mapper.readValue(chargebackDtoStr,
				Chargeback.class);
		ResponseInfo info = new ResponseInfo();
		try {
			if (chargeback.getState() == SheetConstant.CHARGEBACK_SUCCESS) {
				Sheet sheet = this.sheetDao.findById(chargeback.getSheetId());
				sheet.setState(SheetConstant.SHEET_CHARGEBACK);
				this.sheetDao.persist(sheet);
			}
			this.chargebackDao.persist(chargeback);

		} catch (Exception e) {
			info.setMsg(ComConstant.SYS_ERRO);
			info.setStatus(false);
		}
		return this.mapper.writeValueAsString(info);
	}

}
