package d操作节点流IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * -文件字符输出流 <br>
 * --创建源 <br>
 * --选择流 <br>
 * --操作（写出内容） <br>
 * --释放资源 <br>
 * 
 * @author 王以诚
 */
public class ReaderWriterTest01 {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		// 创建源
		File src = new File("src/abc.txt");
		// 选择流
		Reader reader = null;
		try {
			reader = new FileReader(src); // true为插入模式，false为覆写模式
			// 操作（写出）
			char[] flush = new char[1024];
			int len = -1;
			while ((len = reader.read(flush)) != -1) {
				String str = new String(flush, 0, len);
				System.out.print(str);
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
