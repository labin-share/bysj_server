package dtoMapper;

import dto.SheetCreateDTO;
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

}
