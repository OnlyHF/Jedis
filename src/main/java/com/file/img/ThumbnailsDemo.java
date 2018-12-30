package com.file.img;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;

import net.coobird.thumbnailator.Thumbnails;

/**
 * Thumbnails 实现图片处理
 * 
 * @author qianzhubing
 * @date   2018年12月25日 下午10:41:40
*/
public class ThumbnailsDemo {

	/**
	 * 实现图片压缩：
	 * 	1、图片尺寸不变；
	 * 	2、图片大小变小；
	 * @param filePath
	 */
	public static String outputQuality(String filePath) {
		long startTime = System.currentTimeMillis();
		String toPicPath = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			
//			String name = FilenameUtils.getName(filePath);
//			System.out.println(name);
			
			toPicPath = FilenameUtils.getFullPath(filePath) + sdf.format(new Date()) + "." + FilenameUtils.getExtension(filePath);
			File toPic = new File(toPicPath);
			Thumbnails.of(filePath).scale(0.5f).outputQuality(0.1f).toFile(toPic);
			
//			FileInputStream in = new FileInputStream(filePath);
//			
//			
//			byte[] imageBytes = in.readAllBytes();
//			long desFileSize = 100L;
//			long srcSize = imageBytes.length;
//			double accuracy = getAccuracy(srcSize / 1024);
//			
//			 while (imageBytes.length > desFileSize * 1024) {
//                ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
//                ByteArrayOutputStream outputStream = new ByteArrayOutputStream(imageBytes.length);
//                Thumbnails.of(inputStream)
//                        .scale(1f)
//                        .outputQuality(accuracy)
//                        .toOutputStream(outputStream);
//                imageBytes = outputStream.toByteArray();
//             }
//			 FileOutputStream out = new FileOutputStream(toPic);
//			 out.write(imageBytes);
//			 out.flush();
//			 out.close();
			 

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("压缩出问题");
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime);
		System.out.println("endTime - startTime = " + (endTime - startTime));
		return toPicPath;
	}
	
	/**
     * 自动调节精度(经验数值)
     *
     * @param size 源图片大小
     * @return 图片压缩质量比
     */
    private static double getAccuracy(long size) {
        double accuracy;
        if (size < 900) {
            accuracy = 0.85;
        } else if (size < 2047) {
            accuracy = 0.6;
        } else if (size < 3275) {
            accuracy = 0.44;
        } else {
            accuracy = 0.4;
        }
        return accuracy;
    }
	
	public static void main(String[] args) {
//		String filePath = "/Users/qianzhubing/Downloads/photo/201812252255.jpg";
//		String name = FilenameUtils.getFullPath(filePath);
//		System.out.println(name);
		
		String filePath = "/Users/qianzhubing/Downloads/photo/20181231001.jpeg";
		String toPicPath = outputQuality(filePath);
		System.out.println(toPicPath);
	}
}
