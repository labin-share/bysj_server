package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.CriteriaBuilderPersonal;
import constant.LoginConstant;
import constant.RegisterConstant;
import dto.LoginDTO;
import dto.MantainerDTO;
import entity.Mantainer;
import entity.User;

@Repository
public class MantainerDAO extends BaseDao<Mantainer>{
	
	public MantainerDAO() {
		super(Mantainer.class);
	}

	public List<Mantainer> login(LoginDTO dto) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(LoginConstant.PASSWORD, dto.getPsw());
		builder.and(LoginConstant.PHONE, dto.getPhone());
		List<Mantainer> MTNList = super.execute(builder);
		return MTNList;
	}
	
	public List<Mantainer> findByPhone(String phone) throws Exception {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(RegisterConstant.PHONE, phone);
		List<Mantainer> mantainerList = super.execute(builder);
		return mantainerList;
	}

}
