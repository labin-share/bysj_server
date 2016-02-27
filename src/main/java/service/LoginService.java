package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.BeanAssistant;
import common.ResponseInfo;
import constant.LoginConstant;
import dao.LoginDao;
import dto.LoginDTO;
import entity.User;

@Service
public class LoginService {

//	LoginDao loginDao = BeanAssistant.getBean(LoginDao.class);
	@Autowired
	LoginDao loginDao;

	public ResponseInfo login(LoginDTO dto) {
		ResponseInfo resp = new ResponseInfo();
		List<User> userList = this.loginDao.login(dto);
		if(userList.isEmpty()){
			resp.setStatus(false);
			resp.setMsg(LoginConstant.VERRIFY_ERRO);
			return resp;
		}else{
			resp.setData(userList.get(0).getType());
		}
		return resp;
	}

}
