package d操作节点流IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IOTest02Practice {
	public static void main(String[] args) {
		practiceCode();
	}

	public static void practiceCode() {
		File src = new File("src/abc.txt");
		InputStream is;
		try {
			is = new FileInputStream(src);
			int b;
			while ((b = is.read()) != -1) {
				System.out.print((char) b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
