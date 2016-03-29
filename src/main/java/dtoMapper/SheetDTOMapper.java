package dtoMapper;

import dto.SheetCreateDTO;
import dto.SheetDTO;
import dto.SheetEvalDTO;
import entity.Sheet;

public class SheetDTOMapper {

	static public Sheet toNewSheet(SheetCreateDTO dto) {
		Sheet sheet = new Sheet();
		sheet.setAddress(dto.getAddress());
		sheet.setExpectiveTime(dto.getExpectiveTime());
		sheet.setMtnId(dto.getMtnerId());
		sheet.setPhone(dto.getPhone());
		sheet.setCustomerId(dto.getCustomerId());
		sheet.setType(dto.getType());
		return sheet;
	}

	static public SheetEvalDTO toSheetsEvalDTO(Sheet entity) {
		SheetEvalDTO dto = new SheetEvalDTO();
		dto.setEvaluation(entity.getEvaluation());
		dto.setType(entity.getType());
		dto.setAchive(entity.getAchive());
		dto.setAttitude(entity.getAttitude());
		// dto.setEva(entity.isEnableEva());
		dto.setEvaTime(entity.getEvaTime());
		dto.setSpeed(entity.getSpeed());
		dto.setSheetImgList(entity.getSheetImgList());
		return dto;
	}

	static public SheetDTO toSimpleInfo(Sheet entity) {
		SheetDTO sheetDTO = new SheetDTO();
		sheetDTO.setId(entity.getId());
		sheetDTO.setAddress(entity.getAddress());
		sheetDTO.setState(entity.getState());
		sheetDTO.setType(entity.getType());
		sheetDTO.setCreateDate(entity.getCreateDate());
		sheetDTO.setEvaTime(entity.getEvaTime());
		sheetDTO.setEndTime(entity.getEndTime());
		return sheetDTO;
	}

	static public SheetDTO toDetailInfo(Sheet entity) {
		SheetDTO sheetDTO = new SheetDTO();
		sheetDTO.setId(entity.getId());
		sheetDTO.setAddress(entity.getAddress());
		sheetDTO.setState(entity.getState());
		sheetDTO.setType(entity.getType());
		sheetDTO.setCreateDate(entity.getCreateDate());
		sheetDTO.setEvaTime(entity.getEvaTime());
		sheetDTO.setEndTime(entity.getEndTime());
		sheetDTO.setSheetImgList(entity.getSheetImgList());
		return sheetDTO;
	}

	static public void toEvalSheet(Sheet sheet, SheetDTO dto) {
		sheet.setAchive(dto.getAchive());
		sheet.setAttitude(dto.getAttitude());
		sheet.setEvaluation(dto.getEvaluation());
		sheet.setSpeed(dto.getSpeed());
	}

}
