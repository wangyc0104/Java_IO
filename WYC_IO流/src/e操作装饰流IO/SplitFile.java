package e操作装饰流IO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 面向对象思想分割 <br>
 * 文件分块
 * 
 * @author 王以诚
 */
public class SplitFile {

	// 源头
	private File src;
	// 目的地
	private String destDir;
	// 所有分割后的文件存储路径
	private List<String> destPaths;
	// 每块大小
	private int blockSize;
	// 块数
	private int size;

	public SplitFile(String srcPath, String destDir) {
		this(srcPath, destDir, 1024);
	}

	public SplitFile(String srcPath, String destDir, int blockSize) {
		this.src = new File(srcPath);
		this.destDir = destDir;
		this.blockSize = blockSize;
		this.destPaths = new ArrayList<String>();
		init();
	}

	// 初始化
	private void init() {
		// 总长度
		long len = this.src.length();
		// 多少块？
		this.size = (int) Math.ceil(len * 1.0 / blockSize);
		// 路径
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDir + "/" + i + "-" + this.src.getName());
		}
	}

	/**
	 * 分割 -计算每一块的起始位置大小 <br>
	 * -分割 <br>
	 * 
	 * @author 王以诚
	 * @throws IOException
	 */
	public void split() throws IOException {
		// 总长度len
		long len = src.length();
		// 起始位置和实际大小
		int beginPos = 0;
		int actualSize = (int) (blockSize > len ? len : blockSize);
		for (int i = 0; i < size; i++) {
			beginPos = i * blockSize;
			if (i == size - 1) {
				actualSize = (int) len;
			} else {
				actualSize = blockSize;
				len -= actualSize;
			}
			System.out.println("写出到文件块" + i);
			splitDetail(i, beginPos, actualSize);
		}
	}

	/**
	 * -根据第i块的起始位置和块大小，将字节流写出到文件
	 * 
	 * @param i          第i块
	 * @param beginPos   起始位置
	 * @param actualSize 块大小
	 * @throws IOException
	 */
	private void splitDetail(int i, int beginPos, int actualSize) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(this.src, "r");
		RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i), "rw");
		// 起始节点
		raf.seek(beginPos);
		// 读取
		byte[] flush = new byte[1024]; // 缓冲容器
		int len = -1; // 接收长度
		while ((len = raf.read(flush)) != -1) {
			if (actualSize > len) { // 获取本次读取的所有内容
				raf2.write(flush, 0, len);
				actualSize -= len;
			} else {
				raf2.write(flush, 0, actualSize);
				break;
			}
		}
		raf2.close();
		raf.close();
	}

	// 文件的合并
	public void merge(String destPath) throws IOException {
		// 输入、输出 流
		OutputStream os = new FileOutputStream(destPath, true);
		Vector<InputStream> vi = new Vector<InputStream>();
		SequenceInputStream sis = null;
		for (int i = 0; i < destPaths.size(); i++) {
			vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
		}
		sis = new SequenceInputStream(vi.elements());
		byte[] flush = new byte[1024];
		int len = -1; // 接收长度
		while ((len = sis.read(flush)) != -1) {
			// 操作（写出）
			os.write(flush, 0, len);
		}
		os.flush();
		sis.close();
		os.close();
	}

	public static void main(String[] args) throws IOException {
		SplitFile sf = new SplitFile("src/go.jpg", "dest");
		sf.split();
		sf.merge("dest/merge.jpg");
	}

}
