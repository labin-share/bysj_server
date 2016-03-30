package dtoMapper;

import dao.CustomerDao;
import dto.ContactionDTO;
import entity.Contaction;
import entity.Customer;

public class ContactionDTOMapper {

	public static Contaction toEnity(ContactionDTO dto) {
		Contaction contaction = new Contaction();
		contaction.setAddress(dto.getAddress());
//		setCustomerId(contaction, dto);
		contaction.setCustomerId(dto.getCustomerId());
		contaction.setDef(dto.isDef());
		contaction.setPhone(dto.getPhone());
		return contaction;
	}

	public static ContactionDTO toDTO(Contaction entity) {
		ContactionDTO dto = new ContactionDTO();
		dto.setId(entity.getId());
		dto.setAddress(entity.getAddress());
		dto.setCustomerId(entity.getCustomerId());
		dto.setDef(entity.isDef());
		dto.setPhone(entity.getPhone());
		return dto;
	}

//	private static void setCustomerId(Contaction contaction, ContactionDTO dto) {
//		CustomerDao dao = new CustomerDao();
//		Customer customer = dao.findById(dto.getCustomerId());
//		contaction.setCustomerId(customer);
//	}

}
