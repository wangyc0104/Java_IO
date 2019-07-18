package a基本IO和File;

import java.io.File;

/**
 * 其它信息 <br>
 * length(): 文件的字节数 <br>
 * 
 * @author 王以诚
 */
public class PathDemo05 {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		File src = new File("F:/eclipse/workspace/WYC_IO流/src/go.jpg");
		System.out.println("长度 --- " + src.length());
		File src1 = new File("F:/eclipse/workspace/WYC_IO流/src1");
		System.out.println("长度 --- " + src1.length());
	}
}
