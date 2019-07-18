package d操作节点流IO;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * -四个步骤：字节数组输入流 <br>
 * -- 创建源：字节数组（不要太大） <br>
 * -- 选择流 <br>
 * -- 操作 <br>
 * -- 释放：空方法，可以不用处理 <br>
 * 
 * @author 王以诚
 */
public class ByteArrayInputStreamTest {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		// 1.创建源
		byte[] src = "Talking is cheap, show me the code. 汉字还是会乱码".getBytes();
		// 2.选择流
		InputStream bais = null;
		try {
			bais = new ByteArrayInputStream(src);
			// 3.操作（分段读取）
			byte[] flush = new byte[5]; // 缓冲容器
			int len = -1; // 接收长度
			while ((len = bais.read(flush)) != -1) { // 读不到内容，返回一个-1
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
				if (null != bais) {
					bais.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
