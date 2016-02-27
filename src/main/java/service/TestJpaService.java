package service;

import java.util.List;

import org.springframework.stereotype.Service;

import common.BeanAssistant;
import common.ResponseInfo;
import dao.TestJpaDao;
import entity.User;

@Service
public class TestJpaService {
	TestJpaDao testJpadao = BeanAssistant.getBean(TestJpaDao.class);
	
	public String findAll(){
		ResponseInfo resp = new ResponseInfo();
		List<User> AllUserList = testJpadao.findAll();
		return "success";
	}
	
	public void insettRecord(){
		User user = new User();
		user.setPhone("13631225776");
		user.setType("MTN");
		user.setPsw("password");
		testJpadao.persist(user);
	}
	
	
	public void updateRecord() throws Exception{
		User user = testJpadao.findById(1);
		user.setPsw("psw");
		testJpadao.update(user);
	}
}
