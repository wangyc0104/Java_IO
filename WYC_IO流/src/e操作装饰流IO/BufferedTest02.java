package e操作装饰流IO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * -文件字节输出流 <br>
 * --创建源 <br>
 * --选择流 <br>
 * --操作（写出内容） <br>
 * --释放资源 <br>
 * 
 * @author 王以诚
 */
public class BufferedTest02 {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		// 创建源
		File dest = new File("src/dest.txt");
		// 选择流
		OutputStream os = null;
		try {
			// os = new FileOutputStream(dest); // 如果没有第二个参数，则默认为覆写模式
			os = new BufferedOutputStream(new FileOutputStream(dest, true)); // true为插入模式，false为覆写模式
			// 操作（写出）
			String msg = "IO is so easy";
			byte[] datas = msg.getBytes(); // 字符串-->字节数组（编码）
			os.write(datas, 0, datas.length);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != os) {
				try {
					// 释放资源
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
