package d操作节点流IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * -封装拷贝 <br>
 * -封装释放资源 <br>
 * 
 * @author 王以诚
 */
public class FileUtils {

	/**
	 * 对接输入输出流
	 */
	public static void copy(InputStream is, OutputStream os) {
		try (is; os) {
			// 操作（读入）
			byte[] flush = new byte[1024];
			int len = -1; // 接收长度
			while ((len = is.read(flush)) != -1) {
				// 操作（写出）
				os.write(flush, 0, len);
			}
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 释放资源 try with resource
	 * 
	 * @param is
	 * @param os
	 */
	public static void close(InputStream is, OutputStream os) {
		try {
			// 释放资源（先打开的后关闭）
			if (null != os) {
				os.close();
			}
			if (null != is) {
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 释放资源
	 * 
	 * @param ios 多个可关闭io流
	 */
	public static void close(Closeable... ios) {
		for (Closeable io : ios) {
			try {
				// 释放资源（先打开的后关闭）
				if (null != io) {
					io.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// 文件到文件
		try {
			InputStream is = new FileInputStream("src/go.jpg");
			OutputStream os = new FileOutputStream("src/goCopy.jpg");
			copy(is, os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 文件到字节数组
		byte[] datas = null;
		try {
			InputStream is = new FileInputStream("src/go.jpg");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copy(is, os);
			datas = os.toByteArray();
			System.out.println(datas.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 字节数组到文件
		try {
			InputStream is = new ByteArrayInputStream(datas);
			OutputStream os = new FileOutputStream("src/goCopyCopy.jpg");
			copy(is, os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
