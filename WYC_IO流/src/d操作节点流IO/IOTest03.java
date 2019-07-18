package d操作节点流IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * -四个步骤：分段读取 <br>
 * -- 创建源 <br>
 * -- 选择流 <br>
 * -- 操作 <br>
 * -- 释放
 * 
 * @author 王以诚
 */
public class IOTest03 {
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
			// 3.操作（分段读取）
			byte[] flush = new byte[10]; // 缓冲容器
			int len = -1; // 接收长度
			while ((len = is.read(flush)) != -1) { // 读不到内容，返回一个-1
				// String str = new String(flush); // 会把car的byte数组后面超出length的内容也打出来
				String str = new String(flush, 0, len);
				System.out.print(str);
			}
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
	}
}
