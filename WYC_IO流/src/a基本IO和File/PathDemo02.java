package a基本IO和File;

import java.io.File;
import java.io.InputStream;

/**
 * -构建File <br>
 * --存在盘符：绝对路径 <br>
 * --不存在盘符：相对路径 <br>
 * 
 * @author 王以诚
 */
public class PathDemo02 {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		String path = "F:/eclipse/workspace/WYC_IO流/src/go.jpg";

		// 构建File对象(根据路径)
		System.out.println("构建File对象(根据路径)");
		File src = new File(path);
		System.out.println(src.length());
		System.out.println();

		// 构建File对象(路径拼接)
		System.out.println("构建File对象(路径拼接)");
		src = new File("F:/eclipse/workspace", "WYC_IO流/src/go.jpg");
		System.out.println(src.length());
		System.out.println();

		// 构建File对象(父对象子名称)
		System.out.println("构建File对象(父对象子名称)");
		src = new File(new File("F:/eclipse/workspace/WYC_IO流/src"), "go.jpg");
		System.out.println(src.length());
		System.out.println();

		// 绝对路径
		System.out.println("绝对路径");
		File srcA = new File(path);
		System.out.println(srcA.getAbsolutePath());
		System.out.println();

		// 相对路径
		System.out.println("相对路径");
		File srcB = new File("src/go.jpg");
		System.out.println(System.getProperty("user.dir"));
		System.out.println(srcA.getAbsolutePath());
		System.out.println(srcA.getParent());
		System.out.println();

		// 构建一个不存在的文件
		System.out.println("构建一个不存在的文件");
		File srcC = new File("哈哈哈哈");
		System.out.println(srcC.length());
		System.out.println();
	}
}
