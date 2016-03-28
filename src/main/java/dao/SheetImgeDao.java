package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.SheetImge;

@Repository
public class SheetImgeDao extends BaseDao<SheetImge> {

	public SheetImgeDao() {
		super(SheetImge.class);
	}

	public void removeAll(List<SheetImge> sheetImgList) {
		for (SheetImge imge : sheetImgList) {
			super.remove(imge);
		}
	}

}
