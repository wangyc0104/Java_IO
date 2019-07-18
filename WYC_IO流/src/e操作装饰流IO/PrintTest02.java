package e操作装饰流IO;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * 打印流 <br>
 * PrintWriter
 * 
 * @author 王以诚
 */
public class PrintTest02 {
	public static void main(String[] args) throws FileNotFoundException {
		// 输出到文件
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("src/print.txt")), true);
		pw.println("打印流");
		pw.println(true);
		pw.close();
	}
}
