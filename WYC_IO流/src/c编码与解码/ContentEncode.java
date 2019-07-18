package c编码与解码;

import java.io.UnsupportedEncodingException;

/**
 * -编码：字符串 --> 字节 <br>
 * 
 * @author 王以诚
 */
public class ContentEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		testCode();
	}

	public static void testCode() throws UnsupportedEncodingException {
		String msg = "abc会不会乱码ABC";
		// 编码(默认使用工程的字符集)
		byte[] datas = msg.getBytes();
		System.out.println(datas.length);

		// 编码：其他字符集
		datas = msg.getBytes("UTF-16LE");
		System.out.println(datas.length);
	}
}
