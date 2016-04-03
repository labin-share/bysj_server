package service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

import common.ImgAssistant;
import common.TimeAssistant;
import constant.ImgConstant;
import constant.SheetConstant;
import dao.ChargebackDao;
import dao.SheetDao;
import dao.SheetProgressDao;
import dto.SheetCreateDTO;
import dto.SheetDTO;
import dto.SheetEvalDTO;
import dtoMapper.SheetDTOMapper;
import entity.Chargeback;
import entity.ChargebackImge;
import entity.Sheet;
import entity.SheetEvalImge;
import entity.SheetImge;
import entity.SheetProgress;
import entity.SheetStateFollow;

@Service
public class SheetService extends BaseService {

	@Autowired
	SheetDao sheetDao;
	@Autowired
	SheetProgressDao sheetProgressDao;
	@Autowired
	ChargebackDao chargebackDao;

	public String createNewSheet(String dtoStr, List<MultipartFile> imgfileList)
			throws JsonParseException, JsonMappingException, IOException,
			ParseException {
		SheetCreateDTO sheetCreateDTO = super.getMapper().readValue(dtoStr,
				SheetCreateDTO.class);
		Sheet sheet = SheetDTOMapper.toNewSheet(sheetCreateDTO);
		sheet = this.sheetDao.persist(sheet);
		List<SheetImge> newPathList = new ArrayList<SheetImge>();
		SheetImge sheetImge = null;
		String catalog = ImgConstant.TYPE_SHEET + sheet.getId();
		String newPath = null;
		for (MultipartFile imgeFile : imgfileList) {
			newPath = ImgAssistant.updateImg(imgeFile, catalog, null);
			sheetImge = new SheetImge();
			sheetImge.setImg(newPath);
			sheetImge.setSheetId(sheet);
			newPathList.add(sheetImge);
		}
		sheet.setSheetImgList(newPathList);
		this.sheetDao.persist(sheet);
		return super.buildRespJson(true, EMPTY, EMPTY);
	}

	public String getSheetsEvalsByMtnId(int mtnId) throws Exception {
		List<Sheet> sheetList = this.sheetDao.findByMtnId(mtnId);
		SheetEvalDTO dto = null;
		List<SheetEvalDTO> sheetEvalDTOList = new ArrayList<SheetEvalDTO>();
		for (Sheet sheet : sheetList) {
			dto = SheetDTOMapper.toSheetsEvalDTO(sheet);
			sheetEvalDTOList.add(dto);
		}
		return super.buildRespJson(true, EMPTY, super.getMapper()
				.writeValueAsString(sheetEvalDTOList));
	}

	public String getSheetEvalBySheetId(int sheetId) throws Exception {
		Sheet sheet = this.sheetDao.findById(sheetId);
		SheetEvalDTO sheetEvalDTO = SheetDTOMapper.toSheetsEvalDTO(sheet);
		List<SheetEvalDTO> sheetEvalDTOList = new ArrayList<SheetEvalDTO>();
		sheetEvalDTOList.add(sheetEvalDTO);
		return super.buildRespJson(true, EMPTY, super.getMapper()
				.writeValueAsString(sheetEvalDTOList));
	}

	public String changeStateToSuccessFail(int id, int state) throws Exception {
		Sheet sheet = this.sheetDao.findById(id);
		if (sheet.getState() == SheetConstant.SHEET_FINISHED) {
			if (state == SheetConstant.SHEET_SUCCESS
					|| state == SheetConstant.SHEET_FAIL) {
				sheet.setState(state);
				this.sheetDao.persist(sheet);
				this.addToSheetStateFollow(sheet, state);
			}
		}
		return super.buildRespJson(true, EMPTY, EMPTY);
	}

	public String getSheetProgress(int id) throws Exception {
		List<SheetProgress> sheetProgressList = this.sheetProgressDao
				.findBySheetId(id);
		for (SheetProgress sheetProgress : sheetProgressList) {
			String fontTime = TimeAssistant.toFontFormat(sheetProgress
					.getCreateDate());
			sheetProgress.setCreateDate(fontTime);
		}
		return super.getMapper().writeValueAsString(sheetProgressList);
	}

	public String chargeback(String chargebackDtoStr,
			List<MultipartFile> imgfileList) throws Exception {
		Chargeback chargeback = super.getMapper().readValue(chargebackDtoStr,
				Chargeback.class);
		Sheet sheet = this.sheetDao.findById(chargeback.getSheetId());
		if (chargeback.getState() == SheetConstant.CHARGEBACK_SUCCESS) {
			sheet.setState(SheetConstant.CHARGEBACK_SUCCESS);
			this.addToSheetStateFollow(sheet, SheetConstant.CHARGEBACK_SUCCESS);
		} else if (chargeback.getState() == SheetConstant.CHARGEBACK_REQUEST) {
			sheet.setState(SheetConstant.CHARGEBACK_REQUEST);
			this.addToSheetStateFollow(sheet, SheetConstant.CHARGEBACK_REQUEST);
		}
		this.sheetDao.persist(sheet);
		this.saveChargebackImgs(chargeback, imgfileList);
		this.chargebackDao.persist(chargeback);
		return super.buildRespJson(true, EMPTY, EMPTY);
	}

	private void addToSheetStateFollow(Sheet sheet, int state) {
		List<SheetStateFollow> sheetStateList = sheet.getSheetStateList();
		SheetStateFollow newState = new SheetStateFollow();
		newState.setSheetId(sheet);
		newState.setState(state);
		sheetStateList.add(newState);
	}

	private void saveChargebackImgs(Chargeback chargeback,
			List<MultipartFile> imgfileList) throws IOException {
		String catalog = ImgConstant.TYPE_CHARGEBACK + chargeback.getId();
		List<ChargebackImge> imgList = null;
		String newPath = null;
		for (MultipartFile imgFile : imgfileList) {
			newPath = ImgAssistant.updateImg(imgFile, catalog, null);
			imgList.get(0).setImg(newPath);
		}
		chargeback.setImgeList(imgList);
	}

	public String getSheetSimpleInfo(String customerId, String state)
			throws IOException, ParseException {
		List<String> stateList = super.getMapper().readValue(state,
				new TypeReference<List<String>>() {
				});
		List<Sheet> sheetList = this.sheetDao.findByCustomerIdState(
				Integer.parseInt(customerId), stateList);
		List<SheetDTO> sheetDTOList = new ArrayList<SheetDTO>();
		for (Sheet sheet : sheetList) {
			sheetDTOList.add(SheetDTOMapper.toSimpleInfo(sheet));
		}
		return super.buildRespJson(true, super.EMPTY, super.getMapper()
				.writeValueAsString(sheetDTOList));
	}

	public String getSheetSimpleInfoByMtnId(String mtnId, String states)
			throws Exception {
		List<String> stateList = super.getMapper().readValue(states,
				new TypeReference<List<String>>() {
				});
		List<Sheet> sheetList = this.sheetDao.findByMtnIdState(
				Integer.parseInt(mtnId), stateList);
		List<SheetDTO> sheetDTOList = new ArrayList<SheetDTO>();
		for (Sheet sheet : sheetList) {
			sheetDTOList.add(SheetDTOMapper.toSimpleInfo(sheet));
		}
		return super.buildRespJson(true, super.EMPTY, super.getMapper()
				.writeValueAsString(sheetDTOList));
	}

	public String getSheetDetailInfo(int sheetId)
			throws JsonProcessingException, ParseException {
		Sheet sheet = this.sheetDao.findById(sheetId);
		SheetDTO dto = SheetDTOMapper.toDetailInfo(sheet);
		return super.buildRespJson(true, EMPTY, super.getMapper()
				.writeValueAsString(dto));
	}

	public String evaluate(String dtoStr, List<MultipartFile> imgFiles)
			throws JsonParseException, JsonMappingException, IOException {
		SheetDTO sheetDTO = super.getMapper().readValue(dtoStr, SheetDTO.class);
		Sheet sheet = this.sheetDao.findById(sheetDTO.getId());
		SheetDTOMapper.toEvalSheet(sheet, sheetDTO);
		this.saveEvalImgs(sheet, imgFiles);
		this.sheetDao.persist(sheet);
		return super.buildRespJson(true, EMPTY, EMPTY);
	}

	private void saveEvalImgs(Sheet sheet, List<MultipartFile> imgFiles)
			throws IOException {
		String catalog = ImgConstant.TYPE_EVAL + sheet.getId();
		List<SheetEvalImge> oldImgs = sheet.getSheetEvalImgList();
		List<SheetEvalImge> newImgs = new ArrayList<SheetEvalImge>();
		List<String> oldPaths = new ArrayList<String>();
		List<String> newPaths = new ArrayList<String>();
		for (SheetEvalImge img : oldImgs) {
			oldPaths.add(oldImgs.get(0).getImg());
		}
		newPaths = ImgAssistant.updateImgs(imgFiles, catalog, oldPaths);
		for (String newPath : newPaths) {
			newImgs.add(new SheetEvalImge() {
			});
		}
		sheet.setSheetEvalImgList(newImgs);
	}

	public String getChargebackSimpleInfoByCustomerIdState(int id, String states)
			throws JsonParseException, JsonMappingException, IOException {
		List<String> stateList = super.getMapper().readValue(states,
				new TypeReference<List<String>>() {
				});
		List<Sheet> chargebackSheet = this.sheetDao
				.findChargebackByCustomer(id);
		List<Chargeback> chargebackList = this.chargebackDao
				.findByIdStateSheetId(chargebackSheet, stateList);
		List<Sheet> usefulSheet = new ArrayList<Sheet>();
		for (Chargeback chargeback : chargebackList) {
			usefulSheet.add(this.sheetDao.findById(chargeback.getSheetId()));
		}
		List<SheetDTO> sheetDTO = SheetDTOMapper.toSimpleChargebackList(
				usefulSheet, chargebackList);
		return super.buildRespJson(true, EMPTY, super.getMapper()
				.writeValueAsString(sheetDTO));
	}

	public String getChargebackDetailInfoByChargebackId(int id)
			throws JsonProcessingException {
		Chargeback chargeback = this.chargebackDao.findById(id);
		Sheet sheet = this.sheetDao.findById(chargeback.getSheetId());
		SheetDTO dto = SheetDTOMapper.toDetailChargeback(sheet, chargeback);
		return super.buildRespJson(true, EMPTY, super.getMapper()
				.writeValueAsString(dto));
	}

}
