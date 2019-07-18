package e操作装饰流IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 转换流：InputStreamReader OutputStreamWriter <br>
 * -以字符流的形式操作字节流（纯文本） <br>
 * -指定字符集 <br>
 * 
 * @author 王以诚
 */
public class ConvertTest02 {
	public static void main(String[] args) {
		// 操作网络流（下载百度的源代码）
		try (
			// 保存的编码必须和源文件的编码一致，否则会乱码
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(), "UTF-8"));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/baidu.html"), "UTF-8"));
		) {
			String msg;
			while ((msg = reader.readLine()) != null) {
				writer.write(msg);
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("操作异常");
		}
	}

	public static void test3(String[] args) {
		// 操作网络流（下载百度的源代码）
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(), "UTF-8"));
			String msg;
			while ((msg = is.readLine()) != null) {
				System.out.print(msg);
			}
		} catch (IOException e) {
			System.out.println("操作异常");
		}
	}

	public static void test2(String[] args) {
		// 操作网络流（下载百度的源代码）
		try {
			InputStreamReader is = new InputStreamReader(new URL("http://www.baidu.com").openStream(), "UTF-8");
			int temp;
			while ((temp = is.read()) != -1) {
				System.out.print((char) temp); // 字符集不匹配会出现乱码
			}
		} catch (IOException e) {
			System.out.println("操作异常");
		}
	}

	public static void test1(String[] args) {
		// 操作网络流（下载百度的源代码）
		try {
			InputStream is = new URL("http://www.baidu.com").openStream();
			int temp;
			while ((temp = is.read()) != -1) {
				System.out.print((char) temp); // 字节数不一致会出现乱码
			}
		} catch (IOException e) {
			System.out.println("操作异常");
		}
	}
}
