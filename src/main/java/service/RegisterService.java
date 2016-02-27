package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.BeanAssistant;
import common.ResponseInfo;
import constant.ComConstant;
import constant.RegisterConstant;
import dao.RegisterDao;
import dto.RegisterDTO;
import dtoMapper.RegisterDTOMapper;
import entity.User;

@Service
public class RegisterService {
	// RegisterDao registerDao = BeanAssistant.getBean(RegisterDao.class);
	@Autowired
	RegisterDao registerDao;

	public ResponseInfo register(RegisterDTO registerDTO) {
		ResponseInfo resp = new ResponseInfo();
		List<User> userList;
		try {
			userList = this.registerDao.findByPhone(registerDTO.getPhone());
			if (userList.isEmpty() || userList == null) {
				User user = RegisterDTOMapper.toEntity(registerDTO, new User());
				this.registerDao.register(user);
			} else {
				resp.setStatus(false);
				resp.setMsg(RegisterConstant.DUPLICATE_REGISTER);
			}
		} catch (Exception e) {
			resp.setStatus(false);
			resp.setMsg(ComConstant.SYS_ERRO);
			e.printStackTrace();
		}
		return resp;
	}

}
