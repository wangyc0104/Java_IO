package a基本IO和File;

import java.io.File;
import java.io.IOException;

/**
 * 其它信息: <br>
 * createNewFile()：不存在才创建，返回true <br>
 * delete()：删除文件<br>
 * 
 * @author 王以诚
 */
public class PathDemo06 {
	public static void main(String[] args) throws IOException {
		testCode();
	}

	public static void testCode() throws IOException {
		// 创建文件
		File src = new File("F:/eclipse/workspace/WYC_IO流/src/go.txt");
		boolean flag = src.createNewFile();
		System.out.println(flag);

		// 建立的不是文件夹
		File src1 = new File("F:/eclipse/workspace/WYC_IO流/src/go");
		flag = src1.createNewFile();
		System.out.println(flag);

		// 删除文件
		flag = src1.delete();
		System.out.println(flag);

		// 补充：con com3...是操作系统的设备名，不能正确创建
		src = new File("F:/eclipse/workspace/WYC_IO流/con");
		System.out.println(src.createNewFile());
		src = new File("F:/eclipse/workspace/WYC_IO流/com3");
		System.out.println(src.createNewFile());
	}
}
