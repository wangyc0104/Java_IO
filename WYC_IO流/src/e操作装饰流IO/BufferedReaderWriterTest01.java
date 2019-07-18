package e操作装饰流IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * -文件字符缓冲输入流 <br>
 * --创建源 <br>
 * --选择流 <br>
 * --操作（写出内容） <br>
 * --释放资源 <br>
 * 
 * @author 王以诚
 */
public class BufferedReaderWriterTest01 {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		// 创建源
		File src = new File("src/abc.txt");
		// 选择流
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(src)); // true为插入模式，false为覆写模式
			// 操作（写出）
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				try {
					// 释放资源
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
