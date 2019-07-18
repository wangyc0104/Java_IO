package a基本IO和File;

import java.io.File;
import java.io.InputStream;

/**
 * \ / 名称分隔符 <br>
 * 
 * @author 王以诚
 */
public class PathDemo01 {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		String path = "F:/eclipse/workspace/WYC_IO流/src/go.jpg";
		System.out.println(File.separatorChar);
		// 1（建议）path = "F:/eclipse/workspace/WYC_IO流/src/go.jpg"
		// 2.常量拼接 path =
		// "F:"+File.separatorChar+"eclipse"+File.separatorChar+"workspace"+File.separatorChar+"WYC_IO流"+File.separatorChar+"src"+File.separatorChar+"go.jpg"
		// path = "F:" + File.separatorChar + "eclipse" + File.separatorChar +
		// "workspace" + File.separatorChar + "WYC_IO流" + File.separatorChar + "src" +
		// File.separatorChar + "go.jpg";
		System.out.println(path);
	}
}
