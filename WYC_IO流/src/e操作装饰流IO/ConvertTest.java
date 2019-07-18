package e操作装饰流IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流：InputStreamReader OutputStreamWriter <br>
 * -以字符流的形式操作字节流（纯文本） <br>
 * -指定字符集 <br>
 * 
 * @author 王以诚
 */
public class ConvertTest {
	public static void main(String[] args) {
		// 操作System.in和System.out
		try (
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			// 循环获取键盘的输入，遇到exit退出，输出此内容
			String msg = "";
			while (!msg.equals("exit")) {
				msg = reader.readLine();
				writer.write(msg);
				writer.newLine();
				writer.flush(); // 要强制刷新一下
			}
		} catch (IOException e) {
			System.out.println("操作异常");
		}
	}
}
