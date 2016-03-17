package dtoMapper;

import dto.CustomerDTO;
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

	public static Customer toEntity(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setId(customerDTO.getId());
		customer.setName(customerDTO.getName());
		customer.setPhone(customerDTO.getPhone());
		customer.setSignature(customerDTO.getSignature());
//		customer.setHeadPortrait(customerDTO.getHeadPortrait());
		return customer;
	}

}
