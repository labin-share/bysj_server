package dtoMapper;

import dto.RegisterDTO;
import entity.Customer;

public class CustomerDTOMapper {

	public static Customer toEntityFromRegisterDTO(RegisterDTO dto) {
		Customer customer = new Customer();
		customer.setName(dto.getPhone());
		customer.setPhone(dto.getPhone());
		customer.setPsw(dto.getPsw());
		return customer;
	}

}
