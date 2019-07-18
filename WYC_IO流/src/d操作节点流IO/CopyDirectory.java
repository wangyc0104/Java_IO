package d操作节点流IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * -递归地进行文件夹复制操作 <br>
 * --dest必须是文件夹 <br>
 * --src是文件，则直接复制到dest文件夹中 <br>
 * --src是文件夹，则先遍历出其中的所有文件，再递归调用 <br>
 * 
 * @author 王以诚
 */
public class CopyDirectory {

	// copy方法
	public static void copyFile(String srcPath, String destPath) {
		// 创建源、池
		File src = new File(srcPath);
		File dest = new File(destPath);
		// 选择流
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);
			byte[] flush = new byte[1024];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);
			}
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 我的头好晕啊@_@
	 * @param srcPath
	 * @param destPath
	 */
	public static void copyDirectory(String srcPath, String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		if (src.exists() && dest.isDirectory()) {
			if (src.isFile()) {
				copyFile(srcPath, destPath + File.separator + src.getName());
			} else {
				File[] srcFiles = src.listFiles();
				for (File temp : srcFiles) {
					if (temp.isDirectory()) {
						File destDir = new File(destPath, temp.getName());
						destDir.mkdir();
						// 这里进入下层递归
						copyDirectory(temp.getAbsolutePath(), destDir.getAbsolutePath());
					} else {
						copyFile(temp.getAbsolutePath(), destPath + File.separator + temp.getName());
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		copyDirectory("CopyDirectorySrc", "CopyDirectoryDest");
	}
}
