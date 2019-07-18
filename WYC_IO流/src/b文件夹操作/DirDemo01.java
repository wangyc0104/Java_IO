package b文件夹操作;

import java.io.File;

/**
 * -创建目录 --mkdir()：必须确保上级目录存在，不存在则创建失败 <br>
 * --mkdirs()：上级目录可以不存在，不存在则把所有路径都创建 <br>
 * 
 * @author 王以诚
 */
public class DirDemo01 {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		File dir = new File("F:\\eclipse\\workspace\\WYC_IO流\\dir\\test");

		// 创建目录
		boolean flag = dir.mkdirs(); // mkdir()则不能创建
		System.out.println(flag);
		dir.delete();
	}
}
