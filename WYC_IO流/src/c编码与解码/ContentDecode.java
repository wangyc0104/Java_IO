package c编码与解码;

import java.io.UnsupportedEncodingException;

/**
 * -编码：字符串 --> 字节 <br>
 * 
 * @author 王以诚
 */
public class ContentDecode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		testCode();
	}

	public static void testCode() throws UnsupportedEncodingException {
		String msg = "abc会不会乱码ABC";
		// 编码(默认使用工程的字符集)
		byte[] datas = msg.getBytes();
		System.out.println(datas.length);

		// 解码：字符串 String(byte bytes[], int offset, int length, Charset charset)
		msg = new String(datas, 0, datas.length, "UTF-8");
		System.out.println("正常解码--" + msg);

		// 乱码：字节数不够
		msg = new String(datas, 0, datas.length - 2, "UTF-8");
		System.out.println("字节数不够--" + msg);
		// 乱码：字符集不同
		msg = new String(datas, 0, datas.length, "GBK");
		System.out.println("字符集不同--" + msg);
	}
}
