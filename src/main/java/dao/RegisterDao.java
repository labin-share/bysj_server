package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.CriteriaBuilderPersonal;

import constant.RegisterConstant;
import entity.User;

@Repository
public class RegisterDao extends BaseDao<User> {

	public RegisterDao() {
		super(User.class);
	}

	// use phone number to check if duplicate register
	public List<User> findByPhone(String phone) throws Exception {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(RegisterConstant.PHONE, phone);
		List<User> userList = super.execute(builder);
		return userList;
	}

	public void register(User user) throws Exception {
		super.persist(user);
	}

}
