package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r = new Random();
	/**
	 * 处理缩略图,并返回新生成图片的相对值路径
	 */
	public static String generateThumbnail(File thumbnail, String targetAddr) {
		
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail).size(200, 200)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "watermark.jpg")), 0.25f)
			.outputQuality(0.8f).toFile(dest);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return relativeAddr;
	}
	
	/**
	 * 创建目标路径所涉及到的目录，及/home/work/xiangze/xxx.jpg,
	 * 那么home work xiangze这三个文件都会自动创建
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	/**
	 * 获取输入文件的拓展名
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(File cFile) {
		String originalFileName = cFile.getName();
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}
	/**
	 * 生成随机文件名，当前年月日小时分钟+五位随机数
	 * @return
	 */
	public static String getRandomFileName() {
		// 获取随机五位数
		int rannum = r.nextInt(89999) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr + rannum;
	}
	public static void main(String[] args) throws IOException {
		System.out.println("basePath:" + basePath);
		Thumbnails.of(new File("/Users/liuyi/Pictures/鸣人.jpg")).size(200, 200).
		watermark(Positions.CENTER, ImageIO.read(new File(basePath + "/timg.jpg")), 0.15f).outputQuality(0.8f).toFile("/Users/liuyi/Pictures/鸣人New1.jpg");
		
	}

}
