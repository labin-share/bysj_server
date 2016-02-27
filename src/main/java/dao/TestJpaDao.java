package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.CriteriaBuilderPersonal;

import constant.LoginConstant;
import entity.User;

@Repository
public class TestJpaDao extends BaseDao<User> {

	public TestJpaDao() {
		super(User.class);
	}

}
