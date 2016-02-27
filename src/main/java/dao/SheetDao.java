package dao;

import org.springframework.stereotype.Repository;

import entity.Sheet;

@Repository
public class SheetDao extends BaseDao<Sheet>{

	public SheetDao() {
		super(Sheet.class);
	}

}
