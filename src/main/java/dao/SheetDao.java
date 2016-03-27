package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.CriteriaBuilderPersonal;
import constant.SheetConstant;
import entity.Sheet;

@Repository
public class SheetDao extends BaseDao<Sheet> {

	public SheetDao() {
		super(Sheet.class);
	}

	public List<Sheet> findByMtnId(int id) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(SheetConstant.MTN_ID, id);
		return super.execute(builder);
	}

	public List<Sheet> findByStateEva(String state, String isEnableEva) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(SheetConstant.STATE, state);
		builder.and(SheetConstant.IS_ENABLE_EVA, isEnableEva);
		return super.execute(builder);
	}

	public List<Sheet> findByCustomerIdState(int customerId,
			List<String> stateList) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		if (stateList != null) {
			for (String state : stateList) {
				builder.or(SheetConstant.STATE, state);
			}
		}
		builder.and(SheetConstant.CUSTOMER_ID, customerId);
		return super.execute(builder);
	}

}
