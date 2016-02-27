package dtoMapper;

import org.springframework.util.StringUtils;

import dto.RegisterDTO;
import entity.User;

public class RegisterDTOMapper {

	public static RegisterDTO toDTO(User user, RegisterDTO dto) {
		dto.setName(user.getName());
		dto.setPhone(user.getPhone());
		dto.setPsw(user.getPsw());
		dto.setType(user.getType());
		return dto;
	}

	public static User toEntity(RegisterDTO dto, User user) {
		if(!StringUtils.isEmpty(dto.getName())){
			user.setName(dto.getName());
		}else{
			user.setName(dto.getPhone());
		}
		user.setPhone(dto.getPhone());
		user.setPsw(dto.getPsw());
		user.setType(dto.getType());
		return user;
	}
}
