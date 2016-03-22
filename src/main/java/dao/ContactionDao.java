package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.CriteriaBuilderPersonal;
import constant.ContactionConstant;
import entity.Contaction;

@Repository
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

	public List<Contaction> findByDef(boolean b) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(ContactionConstant.DEFAULT, b);
		List<Contaction> contactionList = super.execute(builder);
		return contactionList;
	}
}
