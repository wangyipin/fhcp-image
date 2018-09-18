package com.njsecnet.fhcp.image.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @ProjectName: fhcp-image
 * @Package: com.njsecnet.fhcp.image.util
 * @ClassName: FileUtils
 * @Description: java类作用描述
 * @Author: wangyipin
 * @CreateDate: 2018/9/12 9:12
 * @Version: 1.0
 */
public class FileUtils {

	private FileUtils() {
	}

	private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

	public static String copyFile(String filePath) {

		Long startTime = System.currentTimeMillis();

		File file = new File(filePath);
		if (!file.exists()) {
			return "文件不存在";
		}
		BufferedInputStream bis;
		BufferedOutputStream bos;
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			String fileName = file.getName();
			String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			File toFile = new File("e://" + fileName + fileType);
			bos = new BufferedOutputStream(new FileOutputStream(toFile));
			byte[] bytes = new byte[2048];
			while (bis.read(bytes, 0, bytes.length) != -1) {
				bos.write(bytes);
			}
			bos.flush();
			bos.close();
			bis.close();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		Long endTime = System.currentTimeMillis();
		logger.info("总共耗时：" + (endTime - startTime) + "毫秒");
		return "success";
	}

}
