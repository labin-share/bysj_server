package dao;

import java.util.List;

import common.CriteriaBuilderPersonal;
import constant.ContactionConstant;
import entity.Contaction;

public class ContactionDao extends BaseDao<Contaction> {

	public ContactionDao() {
		super(Contaction.class);
	}

	public List<Contaction> findByCustomer(String id) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(ContactionConstant.CUSTOMER, id);
		List<Contaction> contactionList = super.execute(builder);
		return contactionList;
	}
}
