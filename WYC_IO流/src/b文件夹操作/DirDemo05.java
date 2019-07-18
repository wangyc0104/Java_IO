package b文件夹操作;

import java.io.File;

/**
 * -统计文件夹的大小 <br>
 * 
 * @author 王以诚
 */
public class DirDemo05 {
	public static void main(String[] args) {
		testCode();
	}

	private static long len = 0;

	// 获取文件夹的大小
	public static void count(File src) {
		if (null != src && src.exists()) { // 递归头
			if (src.isFile()) {
				len += src.length();
			} else {
				for (File s : src.listFiles()) {
					count(s);
				}
			}
		}
	}

	public static void testCode() {
		File src = new File("F:\\eclipse\\workspace\\WYC_IO流");
		count(src);
		System.out.println(len);
	}

}
