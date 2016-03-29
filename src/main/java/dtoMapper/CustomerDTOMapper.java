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
		// customer.setHeadPortrait(customerDTO.getHeadPortrait());
		return customer;
	}

	public static void toExistEntity(Customer entity, CustomerDTO dto) {
		entity.setName(dto.getName());
		entity.setSignature(dto.getSignature());
	}

	public static CustomerDTO toDTO(Customer entity) {
		CustomerDTO dto = new CustomerDTO();
		dto.setId(entity.getId());
		dto.setHeadPortrait(entity.getHeadPortrait());
		dto.setName(entity.getName());
		dto.setPhone(entity.getPhone());
		dto.setSignature(entity.getSignature());
		return dto;
	}

}
