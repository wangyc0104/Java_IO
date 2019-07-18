package e操作装饰流IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * -文件字符缓冲输出流 <br>
 * --创建源 <br>
 * --选择流 <br>
 * --操作（写出内容） <br>
 * --释放资源 <br>
 * 
 * @author 王以诚
 */
public class BufferedReaderWriterTest02 {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		// 创建源
		File dest = new File("src/dest.txt");
		// 选择流
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(dest)); // true为插入模式，false为覆写模式
			// 操作（写出）
			// writer.append("appended1\r\n").append("appended2\r\n"); //
			// 不需要手动添加\r\n，可直接使用newLine()方法
			writer.append("append1");
			writer.newLine();
			writer.append("append2");
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
