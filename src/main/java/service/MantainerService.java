package service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import controller.LngLatAssistant;
import dao.MantainerDAO;
import dao.SheetDao;
import dto.LoginDTO;
import dto.MantainerDTO;
import dto.RegisterDTO;
import dto.SheetDTO;
import dtoMapper.MantainerDTOMapper;
import dtoMapper.SheetDTOMapper;
import entity.MantainType;
import entity.Mantainer;
import entity.Sheet;

@Service
public class MantainerService extends BaseService {

	@Autowired
	MantainerDAO mantainerDao;
	@Autowired
	SheetDao sheetDao;
	ObjectMapper mapper = new ObjectMapper();

	public String findById(int id) throws JsonProcessingException {
		Mantainer mantainer = this.mantainerDao.findById(id);
		MantainerDTO mantainerDTO = MantainerDTOMapper.toDTO(
				new MantainerDTO(), mantainer);
		return super.buildRespJson(true, EMPTY, super.getMapper()
				.writeValueAsString(mantainerDTO));
	}

	public ResponseInfo login(LoginDTO dto) throws JsonProcessingException {
		ResponseInfo resp = new ResponseInfo();
		List<Mantainer> MTNList = this.mantainerDao.login(dto);
		if (MTNList.isEmpty()) {
			resp.setStatus(false);
			resp.setMsg(LoginConstant.VERRIFY_ERRO);
			return resp;
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(MantainerConstant.ID, MTNList.get(0).getId());
			map.put(MantainerConstant.NAME, MTNList.get(0).getName());
			resp.setData(this.mapper.writeValueAsString(map));
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

	// public String modifyPersonalInfo(String mantainerDtoStr, MultipartFile
	// img)
	// throws Exception {
	// ResponseInfo resp = new ResponseInfo();
	// MantainerDTO mantaierDTO = this.mapper.readValue(mantainerDtoStr,
	// MantainerDTO.class);
	// Mantainer mantainer = MantainerDTOMapper.toEntity(new Mantainer(),
	// mantaierDTO);
	// String catalogPath = ImgConstant.ROOT + ImgConstant.TYPE_HEAD
	// + mantaierDTO.getId();
	// String oldPath = this.mantainerDao.findById(mantaierDTO.getId())
	// .getHeadPortrait();
	// String newPath = ImgAssistant.updateImg(img, catalogPath, oldPath);
	// mantainer.setHeadPortrait(newPath);
	// try {
	// this.mantainerDao.persist(mantainer);
	// } catch (Exception e) {
	// resp.setStatus(false);
	// resp.setMsg(ComConstant.SYS_ERRO);
	// }
	// return this.mapper.writeValueAsString(resp);
	// }

	public String modifyPersonalInfo(String mantainerDtoStr) throws Exception {
		MantainerDTO mantainerDTO = this.mapper.readValue(mantainerDtoStr,
				MantainerDTO.class);
		Mantainer mantainer = this.mantainerDao.findById(mantainerDTO.getId());
		if (!this.isDuplicateName(mantainerDTO.getName())) {
			MantainerDTOMapper.toExistEntity(mantainer, mantainerDTO);
			this.mantainerDao.persist(mantainer);
			return super.buildRespJson(false, MantainerConstant.DUPLICATE_NAME,
					super.EMPTY);
		}
		return super.buildRespJson(true, EMPTY, EMPTY);
	}

	private boolean isDuplicateName(String name) {
		List<Mantainer> mantainerList = this.mantainerDao.findByName(name);
		if (mantainerList != null || !mantainerList.isEmpty()) {
			return true;
		}
		return false;
	}

	public String modifyHeadPortrait(int id, MultipartFile img)
			throws IOException {
		Mantainer mantainer = this.mantainerDao.findById(id);
		String catalogPath = ImgConstant.TYPE_HEAD + id;
		String oldPath = mantainer.getHeadPortrait();
		String newPath = ImgAssistant.updateImg(img, catalogPath, oldPath);
		mantainer.setHeadPortrait(newPath);
		this.mantainerDao.persist(mantainer);
		return super.buildRespJson(true, super.EMPTY, super.EMPTY);
	}

	public String changePsw(int id, String psw) throws JsonProcessingException {
		ResponseInfo resp = new ResponseInfo();
		Mantainer mantainer = this.mantainerDao.findById(id);
		mantainer.setPsw(psw);
		try {
			this.mantainerDao.persist(mantainer);
		} catch (Exception e) {
			resp.setStatus(false);
			resp.setMsg(ComConstant.SYS_ERRO);
		}
		return this.mapper.writeValueAsString(resp);
	}

	public String getSheetByMtnIdDistance(int id, double distance)
			throws Exception {
		Mantainer mantainer = this.mantainerDao.findById(id);
		List<MantainType> mantainTypes = mantainer.getMantainTypeList();
		List<String> tags = new ArrayList<String>();
		for (MantainType type : mantainTypes) {
			tags.add(type.getTag());
		}
		List<Sheet> sheets = this.sheetDao.findByTypeState(tags);
		List<SheetDTO> sheetDTOs = new ArrayList<SheetDTO>();
		SheetDTO sheetDTO = null;
		double realDistance;
		for (Sheet sheet : sheets) {
			realDistance = LngLatAssistant.calculateDistance(
					mantainer.getLatitude(), mantainer.getLongitude(),
					sheet.getLantitude(), sheet.getLongitude());
			if (Double.compare(realDistance, distance) <= 0) {
				sheetDTO = SheetDTOMapper.toSimpleInfo(sheet);
				sheetDTO.setDistance(realDistance);
				sheetDTOs.add(sheetDTO);
			}
		}
		return super.buildRespJson(true, EMPTY, super.getMapper()
				.writeValueAsString(sheetDTOs));
	}

}
