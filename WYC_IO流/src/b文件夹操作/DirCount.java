package b文件夹操作;

import java.io.File;

/**
 * -使用面向对象的方法统计文件夹的大小 <br>
 * 
 * @author 王以诚
 */
public class DirCount {

	private long len;
	private String path;
	private File src;
	private int fileSize;
	private int dirSize;

	public DirCount(String path) {
		this.path = path;
		this.src = new File(path);
		count(this.src); // 在处此替换practiceCount()方法检测是否正确
	}

	// 获取文件夹的大小
	public void count(File src) {
		if (null != src && src.exists()) { // 递归头
			if (src.isFile()) {
				len += src.length();
				this.fileSize++;
			} else {
				this.dirSize++;
				for (File s : src.listFiles()) { // 下一级递归
					count(s);
				}
			}
		}
	}

	// 练习某文件下的文件大小
	public void practiceCount(File file) {
		if (null != file && file.exists()) {
			if (file.isFile()) {
				len += file.length();
				fileSize++;
			} else {
				dirSize++;
				for (File temp : file.listFiles()) {
					practiceCount(temp);
				}
			}
		}
	}

	public static void testCode() {
		DirCount dir = new DirCount("F:\\eclipse\\workspace\\WYC_IO流");
		System.out.println(dir.getLen());
		System.out.println(dir.getDirSize());
		System.out.println(dir.getFileSize());
		DirCount dir2 = new DirCount("F:\\eclipse\\workspace\\WYC_IO流\\src");
		System.out.println(dir2.getLen());
		System.out.println(dir2.getDirSize());
		System.out.println(dir2.getFileSize());
	}

	public static void main(String[] args) {
		testCode();
	}

	public long getLen() {
		return len;
	}

	public void setLen(long len) {
		this.len = len;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public File getSrc() {
		return src;
	}

	public void setSrc(File src) {
		this.src = src;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public int getDirSize() {
		return dirSize;
	}

	public void setDirSize(int dirSize) {
		this.dirSize = dirSize;
	}

}
