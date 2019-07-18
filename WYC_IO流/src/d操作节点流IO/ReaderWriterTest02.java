package d操作节点流IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * -文件字符输出流 <br>
 * --创建源 <br>
 * --选择流 <br>
 * --操作（写出内容） <br>
 * --释放资源 <br>
 * 
 * @author 王以诚
 */
public class ReaderWriterTest02 {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		// 创建源
		File dest = new File("src/dest.txt");
		// 选择流
		Writer writer = null;
		try {
			// writer = new FileWriter(dest, true); // true为插入模式，false为覆写模式
			writer = new FileWriter(dest); // true为插入模式，false为覆写模式

			// 操作（写出）
			// String msg = "PKU辐化组\r\n";

			// 写法一
			// char[] datas = msg.toCharArray(); // 字符串-->字节数组（编码）
			// writer.write(datas, 0, datas.length);

			// 写法二
			// writer.write(msg);
			writer.append("testAppend1\r\n").append("testAppend2\r\n");

			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != writer) {
				try {
					// 释放资源
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
