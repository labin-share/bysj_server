package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.ImgAssistant;
import common.ResponseInfo;
import constant.ComConstant;
import constant.ImgConstant;
import constant.LoginConstant;
import constant.MantainerConstant;
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

	public List<Mantainer> findAll() {
		return this.mantainerDao.findAll();
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

//	public String modifyPersonalInfo(String mantainerDtoStr, MultipartFile img)
//			throws Exception {
//		ResponseInfo resp = new ResponseInfo();
//		MantainerDTO mantaierDTO = this.mapper.readValue(mantainerDtoStr,
//				MantainerDTO.class);
//		Mantainer mantainer = MantainerDTOMapper.toEntity(new Mantainer(),
//				mantaierDTO);
//		String catalogPath = ImgConstant.ROOT + ImgConstant.TYPE_HEAD
//				+ mantaierDTO.getId();
//		String oldPath = this.mantainerDao.findById(mantaierDTO.getId())
//				.getHeadPortrait();
//		String newPath = ImgAssistant.updateImg(img, catalogPath, oldPath);
//		mantainer.setHeadPortrait(newPath);
//		try {
//			this.mantainerDao.persist(mantainer);
//		} catch (Exception e) {
//			resp.setStatus(false);
//			resp.setMsg(ComConstant.SYS_ERRO);
//		}
//		return this.mapper.writeValueAsString(resp);
//	}

	public String modifyPersonalInfo(String mantainerDtoStr) throws Exception {
		ResponseInfo resp = new ResponseInfo();
		MantainerDTO mantainerDTO = this.mapper.readValue(mantainerDtoStr,
				MantainerDTO.class);
		Mantainer mantainer = MantainerDTOMapper.toEntity(new Mantainer(),mantainerDTO);
		List<Mantainer> mantainerList = this.mantainerDao.findByName(mantainer
				.getName());
		if (mantainerList == null && mantainerList.isEmpty()) {
			resp.setStatus(false);
			resp.setMsg(MantainerConstant.DUPLICATE_NAME);
			return this.mapper.writeValueAsString(resp);
		}
		try {
			this.mantainerDao.persist(mantainer);
		} catch (Exception e) {
			resp.setMsg(ComConstant.SYS_ERRO);
			resp.setStatus(false);
		}
		return this.mapper.writeValueAsString(resp);
	}

	public String modifyHeadPortrait(int id, MultipartFile img) throws JsonProcessingException {
		ResponseInfo resp = new ResponseInfo();
		Mantainer mantainer = this.mantainerDao.findById(id);
		String catalogPath = ImgConstant.ROOT + ImgConstant.TYPE_HEAD + id;
		String oldPath = mantainer.getHeadPortrait();
		try{
			String newPath = ImgAssistant.updateImg(img, catalogPath, oldPath);
			mantainer.setHeadPortrait(newPath);
		}catch(Exception e){
			resp.setStatus(false);
			resp.setMsg(ComConstant.SYS_ERRO);
		}
		return this.mapper.writeValueAsString(resp);
	}

}
