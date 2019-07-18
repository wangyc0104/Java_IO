package a基本IO和File;

import java.io.File;

/**
 * -文件状态 <br>
 * --isExist <br>
 * --isDirectory <br>
 * 
 * @author 王以诚
 */
public class PathDemo04 {

	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {

		File src = new File("src\\go.jpg");
		System.out.println(src.getAbsolutePath());
		System.out.println("" + src.exists());
		System.out.println("" + src.isFile());
		System.out.println("" + src.isDirectory());

		src = new File("xxx");
		if (!src.exists()) {
			System.out.println("文件不存在");
		} else {
			if (src.isFile()) {
				System.out.println("文件操作");
			} else {
				System.out.println("文件夹操作");
			}
		}
	}
}
