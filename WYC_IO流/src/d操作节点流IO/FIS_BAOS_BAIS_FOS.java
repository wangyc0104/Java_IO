package d操作节点流IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * -图片读取到字节数组中 <br>
 * -将字节数组写出到文件<br>
 * 
 * @author 王以诚
 */
public class FIS_BAOS_BAIS_FOS {
	/**
	 * -图片读取到字节数组 <br>
	 * --图片到程序-FileInputStream <br>
	 * --程序到字节数组-ByteArrayOutputStream <br>
	 */
	public static byte[] fileToByteArray(String filePath) {
		// 1.创建源
		File src = new File(filePath);
		// 2.选择流
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			is = new FileInputStream(src);
			baos = new ByteArrayOutputStream();
			// 3.操作（分段读取）
			byte[] flush = new byte[1024 * 10]; // 缓冲容器
			int len = -1; // 接收长度
			while ((len = is.read(flush)) != -1) { // 读不到内容，返回一个-1
				baos.write(flush, 0, len); // 写出到字节数组中
			}
			baos.flush();
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 4.关闭流
				if (null != is) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * -字节数组写出到图片 <br>
	 * --图片到程序-FileInputStream <br>
	 * --程序到字节数组-ByteArrayOutputStream <br>
	 */
	public static void byteArrayToFile(byte[] src, String filePath) {
		// 1.创建源
		// src即是源
		File dest = new File(filePath);
		// 2.选择流（ByteArrayInputStream, FileOutputStream
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new ByteArrayInputStream(src);
			os = new FileOutputStream(dest);
			// 3.操作（从字节流读入，并写出到文件）
			byte[] flush = new byte[1024];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);
			}
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null)
					os.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		byteArrayToFile(fileToByteArray("src/go.jpg"), "src/goFtoF.jpg");
	}
}
