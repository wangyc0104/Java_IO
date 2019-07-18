package d操作节点流IO;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * -四个步骤：字节数组输出流 <br>
 * -- 不需要指定源（不方便手动创建，而是在write之后通过baos.toByteArray()方法来获取写入内存的字节） <br>
 * -- 选择流 <br>
 * -- 操作 <br>
 * -- 释放：空方法，可以不用处理 <br>
 * 
 * @author 王以诚
 */
public class ByteArrayOutputStreamTest {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		// 1.创建源
		byte[] dest = null;
		// 2.选择流（因为要使用新增加的方法，所以不要使用父类声明）
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			// 3.操作（写出并获取数据）
			String msg = "abcdefghijklmnopqrstuvwxyz这里的汉字不会乱码，因为没有拆分后再写";
			byte[] datas = msg.getBytes(); // 缓冲容器
			baos.write(datas, 0, datas.length); // 写入到某一个内存中
			baos.flush();
			dest = baos.toByteArray(); // 从内存中获取write的数据，并赋值给dest
			System.out.println(dest.length + " --> " + new String(dest, 0, dest.length));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 4.释放：空方法，可以不用处理
				if (null != baos) {
					baos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
