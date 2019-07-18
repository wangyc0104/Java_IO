package b文件夹操作;

/**
 * -递归：方法自己调用自己 <br>
 * -递归头：何时结束递归 <br>
 * -递归体：重复调用 <br>
 * 
 * @author 王以诚
 */
public class DirDemo03 {
	public static void main(String[] args) {
		testCode();
	}

	public static void testCode() {
		printNumbertoTen(4);
	}

	// 打印1~10的数
	public static void printNumbertoTen(int n) {
		if (n > 10) {
			System.out.println();
			return;
		}
		System.out.print(n + " ");
		printNumbertoTen(n + 1);
	}
}
