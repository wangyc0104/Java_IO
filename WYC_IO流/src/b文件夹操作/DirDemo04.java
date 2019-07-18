package b文件夹操作;

import java.io.File;

/**
 * -递归打印目录中的文件内容名称 <br>
 * 
 * @author 王以诚
 */
public class DirDemo04 {
	public static void main(String[] args) {
		testCode();
	}

	// 打印子孙目录和文件的名称
	public static void printName(File src, int deep) {
		for (int i = 0; i < deep; i++) {
			System.out.print("-");
		}
		System.out.println(src.getName());
		if (null == src || !src.exists()) { // 递归头
			return;
		} else if (src.isDirectory()) { // 递归体
			for (File s : src.listFiles()) {
				printName(s, deep + 1);
			}
		}
	}
	
	public static void testCode() {
		File src = new File("F:\\eclipse\\workspace\\WYC_IO流");
		printName(src, 0);
	}

}
