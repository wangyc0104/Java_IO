package e操作装饰流IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * -纯字符文件缓冲拷贝：BufferedReader只能套一次进行性能提升，套多次效果并不叠加<br>
 * -创建源和池<br>
 * -选择输入、输出流<br>
 * -操作（读入输入流至一个缓冲区，将缓冲区内容输出，最后要flush）<br>
 * -关闭流（先创建的后关闭）<br>
 * 
 * @author 王以诚
 */
public class BufferedCopyTextFile {

	// 没有缓冲流
	public static void copy(String srcPath, String destPath) {
		// 创建源
		File src = new File(srcPath);
		File dest = new File(destPath);
		// 选择流
		try (FileReader fr = new FileReader(src); FileWriter fw = new FileWriter(dest, true);) {
			// 操作（读入）
			char[] flush = new char[1024];
			int len = -1; // 接收长度
			while ((len = fr.read(flush)) != -1) {
				// 操作（写出）
				fw.write(flush, 0, len);
			}
			fw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 有缓冲流
	public static void copy2(String srcPath, String destPath) {
		// 创建源
		File src = new File(srcPath);
		File dest = new File(destPath);
		// 选择流
		try (BufferedReader is = new BufferedReader(new FileReader(src));
				BufferedWriter os = new BufferedWriter(new FileWriter(dest));) {
			// 操作（读入）
			String line = null;
			while ((line = is.readLine()) != null) {
				// 操作（写出）
				os.write(line);
				os.newLine();
			}
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void testCode() {
		long t1 = System.currentTimeMillis();
		copy("src/crsto.txt", "src/crsto1.txt");
		long t2 = System.currentTimeMillis();
		System.out.println("没有缓冲流" + (t2 - t1));

		t1 = System.currentTimeMillis();
		copy2("src/crsto.txt", "src/crsto2.txt");
		t2 = System.currentTimeMillis();
		System.out.println("有缓冲流" + (t2 - t1));
	}

	public static void main(String[] args) {
		testCode();
	}

}
