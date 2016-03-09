package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.CriteriaBuilderPersonal;
import constant.SheetConstant;
import entity.SheetProgress;

@Repository
public class SheetProgressDao extends BaseDao<SheetProgress>{

	public SheetProgressDao() {
		super(SheetProgress.class);
	}
	
	public List<SheetProgress> findBySheetId(String id) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(SheetConstant.SHEET_ID, id);
		List<SheetProgress> SheetProgressList = super.execute(builder);
		return SheetProgressList;
	}

}
