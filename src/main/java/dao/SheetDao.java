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
		builder.notEqual(SheetConstant.EVA_TIME, null);
		return super.execute(builder);
	}

	public List<Sheet> findChargebackByCustomer(int id) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(SheetConstant.CUSTOMER_ID, id);
		builder.and(SheetConstant.STATE, SheetConstant.CHARGEBACK_REQUEST);
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

	public List<Sheet> findByMtnIdState(int mtnId, List<String> stateList) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		if (stateList != null) {
			for (String state : stateList) {
				builder.or(SheetConstant.STATE, state);
			}
		}
		builder.and(SheetConstant.MTN_ID, mtnId);
		return super.execute(builder);
	}

	public List<Sheet> findByTypeState(List<String> tags) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		if (tags != null) {
			for (String tag : tags) {
				builder.or(SheetConstant.TYPE, tag);
			}
		}
		builder.and(SheetConstant.STATE, SheetConstant.SHEET_WAIT);
		return super.execute(builder);
	}

}
