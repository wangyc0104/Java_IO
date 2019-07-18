package e操作装饰流IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * -文件缓冲拷贝：BufferedInputStream只能套一次进行性能提升，套多次效果并不叠加<br>
 * -创建源和池<br>
 * -选择输入、输出流<br>
 * -操作（读入输入流至一个缓冲区，将缓冲区内容输出，最后要flush）<br>
 * -关闭流（先创建的后关闭）<br>
 * 
 * @author 王以诚
 */
public class BufferedCopyFile {

	// 没有缓冲流
	public static void copy(String srcPath, String destPath) {
		// 创建源
		File src = new File(srcPath);
		File dest = new File(destPath);
		// 选择流
		try (InputStream is = new FileInputStream(src); OutputStream os = new FileOutputStream(dest, true);) {
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

	// 有缓冲流
	public static void copy2(String srcPath, String destPath) {
		// 创建源
		File src = new File(srcPath);
		File dest = new File(destPath);
		// 选择流
		try (InputStream is = new BufferedInputStream(new FileInputStream(src)); OutputStream os = new BufferedOutputStream(new FileOutputStream(dest, true));) {
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

	public static void testCode() {
		long t1 = System.currentTimeMillis();
		copy("src/校庆1.mp4", "src/校庆1.mp4");
		long t2 = System.currentTimeMillis();
		System.out.println("没有缓冲流" + (t2 - t1));

		t1 = System.currentTimeMillis();
		copy2("src/校庆2.mp4", "src/校庆2.mp4");
		t2 = System.currentTimeMillis();
		System.out.println("有缓冲流" + (t2 - t1));
	}

	public static void main(String[] args) {
		testCode();
	}

}
