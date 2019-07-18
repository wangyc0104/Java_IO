package e操作装饰流IO;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 打印流 <br>
 * PrintStream
 * 
 * @author 王以诚
 */
public class PrintTest01 {
	public static void main(String[] args) throws FileNotFoundException {
		// 打印流System.out
		PrintStream ps = System.out;
		ps.println("打印流");
		ps.println(true);
		// 输出到文件
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("src/print.txt")), true);
		ps.println("打印流");
		ps.println(true);

		// 重定向输出端
		System.setOut(ps);
		System.out.println("change"); // 此处是输出在了print.txt中
		// 重定向回控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true));
		System.out.println("I am coming back!"); // 此处输出在了控制台中

		ps.close();
	}
}
