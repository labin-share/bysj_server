/*
	作者：843367228@qq.com
	时间：2016-03-10
	描述：
	目录名：类型+id
	文件名：日期YYMMddmmssSS.jpg
	
	类型：头像，订单，评价，退单
	
*/
package common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import constant.ComConstant;

public class ImgAssistant {

	public static List<String> saveImgs(List<MultipartFile> imgFiles,
			String path) throws IOException {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat(ComConstant.FILE_NAME_DATE_FORMAT);
		String date = df.format(d);
		List<String> fullPath = new ArrayList<String>();
		for (MultipartFile img : imgFiles) {
			FileUtils.copyInputStreamToFile(img.getInputStream(), new File(
					path, date));
			fullPath.add(path + date);
		}
		return fullPath;
	}

	public static void deleteImg(String path) {
		File file = new File(path);
		if (file.isFile() && file.exists()) {
			file.delete();
		}
	}

}
