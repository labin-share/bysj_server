package dtoMapper;

import dto.ContactionDTO;
import entity.Contaction;

public class ContactionDTOMapper {

	public static Contaction toEnity(ContactionDTO dto) {
		Contaction contaction = new Contaction();
		contaction.setAddress(dto.getAddress());
		contaction.setCustomerId(dto.getCustomerId());
		contaction.setDef(dto.isDef());
		contaction.setPhone(dto.getPhone());
		return contaction;
	}
	
	public static ContactionDTO toDTO(Contaction entity){
		ContactionDTO dto = new ContactionDTO();
		dto.setAddress(entity.getAddress());
		dto.setCustomerId(entity.getCustomerId());
		dto.setDef(entity.isDef());
		dto.setPhone(entity.getPhone());
		return dto;
	}

}
