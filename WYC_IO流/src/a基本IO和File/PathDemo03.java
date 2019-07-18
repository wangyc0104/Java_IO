package a基本IO和File;

import java.io.File;

/**
 * 名称或路径 getName() getPath() getAbsolutePath() getParent()
 * 
 * @author 王以诚
 */
public class PathDemo03 {

	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {

		File src = new File("src\\go.jpg");
		System.out.println("" + src.getName());
		System.out.println("" + src.getPath());
		System.out.println("" + src.getAbsolutePath());
		System.out.println("" + src.getParent());
		System.out.println("" + src.getParentFile().getName());

//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
	}
}
