/*
	ä½œè€…ï¼š843367228@qq.com
	æ—¶é—´ï¼š2016-03-10
	æ��è¿°ï¼š
	ç›®å½•å��ï¼šç±»åž‹+id
	æ–‡ä»¶å��ï¼šæ—¥æœŸYYMMddmmssSS.jpg
	
	ç±»åž‹ï¼šå¤´åƒ�ï¼Œè®¢å�•ï¼Œè¯„ä»·ï¼Œé€€å�•
	
 */
package common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import constant.ComConstant;
import constant.ImgConstant;

public class ImgAssistant {

	public static String saveImg(MultipartFile imgFile, String path)
			throws IOException {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat(ComConstant.FILE_NAME_DATE_FORMAT);
		String date = df.format(d);
		Random random = new Random();
		int randomNum;
		randomNum = (int) random.nextDouble() * ImgConstant.THIRD_DIGIT_LENGTH;
		FileUtils.copyInputStreamToFile(imgFile.getInputStream(), new File(
				path, "" + date + "" + randomNum));
		return path + "" + date + "" + randomNum;
	}

	public static void deleteOldImg(String path) {
		if (path != null) {
			File file = new File(path);
			if (file.isFile() && file.exists()) {
				file.delete();
			}
		}
	}

	public static String updateImg(MultipartFile imgFile, String catalog,
			String oldPath) throws IOException {
		String newPath = saveImg(imgFile, catalog);
		deleteOldImg(oldPath);
		return newPath;
	}

}
