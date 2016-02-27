package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.CriteriaBuilderPersonal;
import constant.LoginConstant;
import dto.LoginDTO;
import entity.User;

@Repository
public class LoginDao extends BaseDao<User> {

	public LoginDao() {
		super(User.class);
	}

	public List<User> login(LoginDTO dto) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(LoginConstant.PASSWORD, dto.getPsw());
		builder.and(LoginConstant.PHONE, dto.getPhone());
		List<User> userList = super.execute(builder);
		return userList;
	}

}
