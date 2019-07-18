package e操作装饰流IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * -数据流： <br>
 * --写出后读取 <br>
 * --读取的顺序与写出保持一致 <br>
 * 
 * DataOutputStream <br>
 * DataInputStream <br>
 * 
 * @author 王以诚
 */
public class DataIOTest {
	public static void main(String[] args) throws IOException {
		// 写出（顺序与读取一致）
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
		// 操作数据类型
		dos.writeUTF("喜怒哀乐之未发谓之中，发而皆中节谓之和。");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas = baos.toByteArray();
		// 读取（顺序与写出一致）
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String msg = dis.readUTF();
		int age = dis.readInt();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		System.out.println(msg + age + flag + ch);

	}
}
