package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.ResponseInfo;
import constant.ComConstant;
import constant.LoginConstant;
import constant.RegisterConstant;
import dao.MantainerDAO;
import dto.LoginDTO;
import dto.MantainerDTO;
import dto.RegisterDTO;
import dtoMapper.MantainerDTOMapper;
import entity.Mantainer;

@Service
public class MantainerService {

	@Autowired
	MantainerDAO mantainerDao;
	ObjectMapper mapper = new ObjectMapper();

	public MantainerDTO findById(int id) {
		Mantainer mantainer = this.mantainerDao.findById(id);
		return MantainerDTOMapper.toDTO(new MantainerDTO(), mantainer);
	}

	public ResponseInfo login(LoginDTO dto) {
		ResponseInfo resp = new ResponseInfo();
		List<Mantainer> MTNList = this.mantainerDao.login(dto);
		if (MTNList.isEmpty()) {
			resp.setStatus(false);
			resp.setMsg(LoginConstant.VERRIFY_ERRO);
			return resp;
		} else {
			resp.setData(MTNList.get(0).getName());
		}
		return resp;
	}

	public String register(String registerDTOStr) throws Exception {
		ResponseInfo resp = new ResponseInfo();
		RegisterDTO registerDTO = this.mapper.readValue(registerDTOStr,
				RegisterDTO.class);
		try {
			List<Mantainer> mantainerList = this.mantainerDao
					.findByPhone(registerDTO.getPhone());
			if (mantainerList.isEmpty() || mantainerList == null) {
				this.mantainerDao.persist(MantainerDTOMapper
						.toEntityFromRegisterDTO(registerDTO));
			} else {
				resp.setStatus(false);
				resp.setMsg(RegisterConstant.DUPLICATE_REGISTER);
			}
		} catch (Exception e) {
			resp.setStatus(false);
			resp.setMsg(ComConstant.SYS_ERRO);
			e.printStackTrace();
		}
		return this.mapper.writeValueAsString(resp);
	}

}
