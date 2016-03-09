package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.CriteriaBuilderPersonal;
import constant.LoginConstant;
import constant.RegisterConstant;
import dto.LoginDTO;
import entity.Customer;

@Repository
public class CustomerDao extends BaseDao<Customer> {

	public CustomerDao() {
		super(Customer.class);
	}

	public List<Customer> login(LoginDTO dto) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(LoginConstant.PASSWORD, dto.getPsw());
		builder.and(LoginConstant.PHONE, dto.getPhone());
		List<Customer> customerList = super.execute(builder);
		return customerList;
	}

	public List<Customer> findByPhone(String phone) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(RegisterConstant.PHONE, phone);
		List<Customer> customerList = super.execute(builder);
		return customerList;
	}

}
