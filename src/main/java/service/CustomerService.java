package service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.ImgAssistant;
import common.ResponseInfo;
import constant.ComConstant;
import constant.CustomerConstant;
import constant.ImgConstant;
import constant.LoginConstant;
import constant.RegisterConstant;
import dao.CustomerDao;
import dto.CustomerDTO;
import dto.LoginDTO;
import dto.RegisterDTO;
import dtoMapper.CustomerDTOMapper;
import entity.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	ObjectMapper mapper = new ObjectMapper();

	public ResponseInfo login(LoginDTO dto) {
		ResponseInfo resp = new ResponseInfo();
		List<Customer> customerList = this.customerDao.login(dto);
		if (customerList.isEmpty()) {
			resp.setStatus(false);
			resp.setMsg(LoginConstant.VERRIFY_ERRO);
			return resp;
		} else {
			resp.setData(customerList.get(0).getName());
		}
		return resp;
	}

	public String register(String registerDTOStr) throws Exception {
		ResponseInfo resp = new ResponseInfo();
		RegisterDTO registerDTO = this.mapper.readValue(registerDTOStr,
				RegisterDTO.class);
		try {
			List<Customer> customerList = this.customerDao
					.findByPhone(registerDTO.getPhone());
			if (customerList.isEmpty() || customerList == null) {
				this.customerDao.persist(CustomerDTOMapper
						.toEntityFromRegisterDTO(registerDTO));
			} else {
				resp.setStatus(false);
				resp.setMsg(RegisterConstant.DUPLICATE_REGISTER);
			}
		} catch (Exception e) {
			resp.setStatus(false);
			resp.setMsg(ComConstant.SYS_ERRO);
			e.printStackTrace();
		}
		return this.mapper.writeValueAsString(resp);
	}

	public String findById(int id) throws JsonProcessingException {
		Customer customer = this.customerDao.findById(id);
		return this.mapper.writeValueAsString(customer);
	}

	// public String modifyPersonalInfo(String customerDtoStr, MultipartFile
	// img)
	// throws Exception {
	// ResponseInfo resp = new ResponseInfo();
	// CustomerDTO customerDTO = this.mapper.readValue(customerDtoStr,
	// CustomerDTO.class);
	// Customer customer = CustomerDTOMapper.toEntity(customerDTO);
	// String catalogPath = ImgConstant.ROOT + ImgConstant.TYPE_HEAD
	// + customerDTO.getId();
	// String oldPath = this.customerDao.findById(customerDTO.getId())
	// .getHeadPortrait();
	// String newPath = ImgAssistant.updateImg(img, catalogPath, oldPath);
	// customer.setHeadPortrait(newPath);
	// try {
	// this.customerDao.persist(customer);
	// } catch (Exception e) {
	// resp.setStatus(false);
	// resp.setMsg(ComConstant.SYS_ERRO);
	// }
	// return this.mapper.writeValueAsString(resp);
	// }

	public String modifyPersonalInfo(String customerDtoStr) throws Exception {
		ResponseInfo resp = new ResponseInfo();
		CustomerDTO customerDTO = this.mapper.readValue(customerDtoStr,
				CustomerDTO.class);
		Customer customer = CustomerDTOMapper.toEntity(customerDTO);
		List<Customer> customerList = this.customerDao.findByName(customer
				.getName());
		if (customerList == null && customerList.isEmpty()) {
			resp.setStatus(false);
			resp.setMsg(CustomerConstant.DUPLICATE_NAME);
			return this.mapper.writeValueAsString(resp);
		}
		try {
			this.customerDao.persist(customer);
		} catch (Exception e) {
			resp.setMsg(ComConstant.SYS_ERRO);
			resp.setStatus(false);
		}
		return this.mapper.writeValueAsString(resp);
	}

	public String modifyHeadPortrait(int id, MultipartFile img)
			throws IOException {
		ResponseInfo resp = new ResponseInfo();
		Customer customer = this.customerDao.findById(id);
		String catalogPath = ImgConstant.ROOT + ImgConstant.TYPE_HEAD + id;
		String oldPath = customer.getHeadPortrait();
		try {
			String newPath = ImgAssistant.updateImg(img, catalogPath, oldPath);
			customer.setHeadPortrait(newPath);
		} catch (Exception e) {
			resp.setStatus(false);
			resp.setMsg(ComConstant.SYS_ERRO);
		}
		return this.mapper.writeValueAsString(resp);
	}

	public String changePsw(int id, String psw) throws JsonProcessingException {
		ResponseInfo resp = new ResponseInfo();
		Customer customer = this.customerDao.findById(id);
		customer.setPsw(psw);
		try {
			this.customerDao.persist(customer);
		} catch (Exception e) {
			resp.setStatus(false);
			resp.setMsg(ComConstant.SYS_ERRO);
		}
		return this.mapper.writeValueAsString(resp);
	}

}
