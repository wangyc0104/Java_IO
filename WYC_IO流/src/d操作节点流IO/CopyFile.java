package d操作节点流IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * -文件拷贝：文件字节输入<br>
 * -创建源和池<br>
 * -选择输入、输出流<br>
 * -操作（读入输入流至一个缓冲区，将缓冲区内容输出，最后要flush）<br>
 * -关闭流（先创建的后关闭）<br>
 * 
 * @author 王以诚
 */
public class CopyFile {

	public static void testCode() {
		copy("src/go.jpg", "src/goCopy.jpg");
		copy2("src/go.jpg", "src/goCopy2.jpg");
	}

	public static void copy(String srcPath, String destPath) {
		// 创建源
		File src = new File(srcPath);
		File dest = new File(destPath);
		// 选择流
		InputStream is = null;
		OutputStream os = null;
		try {
			// os = new FileOutputStream(dest); // 如果没有第二个参数，则默认为覆写模式
			is = new FileInputStream(src);
			os = new FileOutputStream(dest, true); // true为插入模式，false为覆写模式
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
		} finally {
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

	}

	// 使用带资源的try语句块
	public static void copy2(String srcPath, String destPath) {
		// 创建源
		File src = new File(srcPath);
		File dest = new File(destPath);
		// 选择流
		try (InputStream is = new FileInputStream(src); OutputStream os = new FileOutputStream(dest, true);) {
			// os = new FileOutputStream(dest); // 如果没有第二个参数，则默认为覆写模式
			// true为插入模式，false为覆写模式
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

	public static void main(String[] args) {
		testCode();
	}

}
