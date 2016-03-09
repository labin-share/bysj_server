package dtoMapper;

import dto.SheetCreateDTO;
import dto.SheetEvalDTO;
import entity.Sheet;

public class SheetDTOMapper {

	static public Sheet toNewSheet(SheetCreateDTO dto) {
		Sheet sheet = new Sheet();
		sheet.setAddress(dto.getAddress());
		sheet.setExpectiveTime(dto.getExpectiveTime());
		sheet.setMtnerId(dto.getMtnerId());
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
		dto.setEva(entity.isEva());
		dto.setEvaTime(entity.getEvaTime());
		dto.setSpeed(entity.getSpeed());
		return dto;
	}

}
