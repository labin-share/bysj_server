package dtoMapper;

import dto.MantainerDTO;
import dto.RegisterDTO;
import entity.Mantainer;

public class MantainerDTOMapper {

	public static MantainerDTO toDTO(MantainerDTO dto, Mantainer entity) {
		dto.setId(entity.getId());
		dto.setAddress(entity.getAddress());
		// dto.setEvaNum(entity.getEvaNum());
		dto.setHeadPortrait(entity.getHeadPortrait());
		dto.setMantainTypeList(entity.getMantainTypeList());
		dto.setName(entity.getName());
		dto.setPhone(entity.getPhone());
		dto.setSignature(entity.getSignature());
		// dto.setCredit(entity.getCredit());
		return dto;
	}

	//deliver the mantaner info which collection by customer or filter by latitude and longitude
	public static MantainerDTO toMtnShowList(Mantainer entity) {
		MantainerDTO dto = new MantainerDTO();
		dto.setHeadPortrait(entity.getHeadPortrait());
		dto.setName(entity.getName());
		dto.setEvaNum(entity.getEvaNum());
		dto.setTradeNum(entity.getTradeNum());
		dto.setMantainTypeList(entity.getMantainTypeList());
		return dto;
	}

	public static Mantainer toEntity(Mantainer entity, MantainerDTO dto) {
		entity.setAddress(dto.getAddress());
		// entity.setHeadPortrait(dto.getHeadPortrait());
		entity.setId(dto.getId());
		entity.setMantainTypeList(dto.getMantainTypeList());
		entity.setName(dto.getName());
		entity.setSignature(dto.getSignature());
		return entity;
	}

	public static Mantainer toEntityFromRegisterDTO(RegisterDTO dto) {
		Mantainer mantainer = new Mantainer();
		mantainer.setName(dto.getPhone());
		mantainer.setPhone(dto.getPhone());
		mantainer.setPsw(dto.getPsw());
		return mantainer;
	}

}
