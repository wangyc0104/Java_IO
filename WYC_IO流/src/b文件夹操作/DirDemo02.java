package b文件夹操作;

import java.io.File;

/**
 * 列出下一级 <br>
 * --list()：列出下一级名称 <br>
 * --listFiles()：列出下一级File对象 <br>
 * --listRoots()：列出所有的盘符 <br>
 * 
 * @author 王以诚
 */
public class DirDemo02 {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		File dir = new File("F:/eclipse/workspace/WYC_IO流");

		// 下级名称 list()
		String[] subNames = dir.list();
		for (String name : subNames) {
			System.out.println(name);
		}

		// 下级对象 listFiles()
		File[] subFiles = dir.listFiles();
		for (File file : subFiles) {
			System.out.println(file.getAbsolutePath());
		}

		// 列出所有的盘符
		File[] roots = File.listRoots();
		for (File r : roots) {
			System.out.println(r.getAbsolutePath());
		}

	}
}
