package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.ResponseInfo;
import constant.ComConstant;
import constant.LoginConstant;
import constant.RegisterConstant;
import dao.CustomerDao;
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
		if(customerList.isEmpty()){
			resp.setStatus(false);
			resp.setMsg(LoginConstant.VERRIFY_ERRO);
			return resp;
		}else{
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


}
