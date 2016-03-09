package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.CriteriaBuilderPersonal;
import constant.LoginConstant;
import constant.SheetConstant;
import entity.Sheet;

@Repository
public class SheetDao extends BaseDao<Sheet>{

	public SheetDao() {
		super(Sheet.class);
	}

	public List<Sheet> findByMtnId(String id) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(SheetConstant.MTN_ID, id);
		return super.execute(builder);
	}

}
