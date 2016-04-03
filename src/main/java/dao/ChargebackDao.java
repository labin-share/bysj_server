package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import common.CriteriaBuilderPersonal;
import constant.ChargebackConstant;
import constant.LoginConstant;
import entity.Chargeback;
import entity.Sheet;
import entity.User;

@Repository
public class ChargebackDao extends BaseDao<Chargeback> {

	public ChargebackDao() {
		super(Chargeback.class);
	}

	public List<Chargeback> findByIdStateSheetId(List<Sheet> sheets,
			List<String> stateList) {
		EntityManager entityManager = super.getEntitymanager();
		Query query = entityManager.createQuery("select c1 from Chargeback c1 "
				+ "where c1.createDate in "
				+ "(select max(c2.createDate) from Chargeback c2 "
				+ "where c2.sheetId in "
				+ "(select c3.sheetId from Chargeback c3 "
				+ "where c3.sheetId in "+this.buildSheetIdQuerySets(sheets)+" "
				+ "group by c3.sheetId "
				+ "having (count(c3.sheetId) in "+this.buildStateQuerySets(stateList)+")))");
		return query.getResultList();
	}
	
	private String buildSheetIdQuerySets(List<Sheet> sheets){
		String sheetIds = "(";
		for(Sheet sheet: sheets){
			if(!sheetIds.equals("(")){
				sheetIds += ",";
			}
			sheetIds += sheet.getId();
		}
		sheetIds+=")";
		return sheetIds;
	}
	
	private String buildStateQuerySets(List<String> stateList){
		String states = "(";
		for(String state: stateList){
			if(!states.equals("(")){
				states += ",";
			}
			states+=state;
		}
		states+=")";
		return states;
	}
}
