package com.jedis.common.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.jedis.common.utils.DateUtils;
import com.jedis.common.utils.JedisUtils;

/**
 * IO配置信息
 * @author qianzhubing
 * @date 2018-12-03
 */
public class IOUtils {

	/**
	 * 
	 * @param command
	 * @param resultList
	 */
	public static void addLogList(String command, List<String> resultList) {
		if (resultList == null || resultList.size() <= 0) {
			return;
		}
		String result = "";
		for (int i = 0; i < resultList.size(); i++) {
			if (i == 0) {
				result = resultList.get(i);
			} else {
				result = result + " " + resultList.get(i);
			}
		}
		addLog(command, result);
	}
	
	/**
	 * 将操作redis的命令于结果写入到当前系统日期日志文件中
	 * @param command
	 * @param result
	 * @throws IOException 
	 */
	public static void addLog(String command, String result) {
		String filePath = "src/main/resources/IOUtils/logs/" + DateUtils.getFormatDateStr() + ".log";
		File logFile =  new File(filePath);
		BufferedWriter writer = null;
		try {
			if (!logFile.exists()) {
				logFile.createNewFile();
			}
			writer = new BufferedWriter(new FileWriter(logFile, true));
			
			writer.write(DateUtils.getFormatDateString());
			writer.newLine();
			command = JedisUtils.IP +  ":" + JedisUtils.PORT + "  command >>> " + command;
			result = JedisUtils.IP +  ":" + JedisUtils.PORT + "  result  >>> " + result;
			writer.write(command);
			writer.newLine();
			writer.write(result);
			writer.newLine();
			writer.newLine();
			
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		addLog("123", "123");
		
	}
}
