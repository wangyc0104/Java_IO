package d操作节点流IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * -第一个程序 <br>
 * -- 创建源 <br>
 * -- 选择流 <br>
 * -- 操作 <br>
 * -- 释放
 * 
 * @author 王以诚
 */
public class IOTest01 {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		// 1.创建源
		File src = new File("src/abc.txt");
		// 2.选择流
		InputStream is = null;
		try {
			is = new FileInputStream(src);
			// 3.操作（读取）
			int data1 = is.read(); // 第一个数据 a
			int data2 = is.read(); // 第二个数据 b
			int data3 = is.read(); // 第三个数据 c
			int data4 = is.read(); // 第四个数据（无），不是数据，文件的末尾返回-1
			System.out.println((char) data1);
			System.out.println((char) data2);
			System.out.println((char) data3);
			System.out.println(data4);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
