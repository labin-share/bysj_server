package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import constant.SheetConstant;
import dao.SheetDao;
import entity.Sheet;

//not test
public class ScheduleJob {
	@Autowired
	SheetDao sheetDao;

	public void updateSheetEvaFunc() throws ParseException {
		List<Sheet> sheetList = this.sheetDao.findByStateEva(Integer.toString(SheetConstant.SHEET_FINISHED), Boolean.toString(SheetConstant.ENABLE_EVA));
		SimpleDateFormat format = new SimpleDateFormat(TimeAssistant.BACKEND_TIME_FORMAT);
		Date nowDate = new Date();
	    Date endDate = null;
		for(Sheet sheet : sheetList){
			endDate = format.parse(sheet.getEndTime());
			if((nowDate.getDay()-endDate.getDay())>=7){
				sheet.setEnableEva(false);
			}
		}
		this.sheetDao.persistAll(sheetList);
	}
}
