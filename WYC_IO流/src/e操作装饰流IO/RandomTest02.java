package e操作装饰流IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读取和写入流 RandomAccessFile <br>
 * 文件分块
 * 
 * @author 王以诚
 */
public class RandomTest02 {

	public static void main(String[] args) throws IOException {
		// 分多少块
		File src = new File("src/crsto.txt");
		// 总长度
		long len = src.length();
		// 每块大小
		int blockSize = 1024;
		// 多少块？
		int size = (int) Math.ceil(len * 1.0 / blockSize);
		System.out.println(size);
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
			System.out.println("\n" + i + " " + beginPos + " " + actualSize);
			split(i, beginPos, actualSize);
		}

	}

	/**
	 * -指定第i块的起始位置和实际长度，并输出到控制台
	 * 
	 * @param i
	 * @param beginPos
	 * @param actualSize
	 * @throws IOException
	 */
	public static void split(int i, int beginPos, int actualSize) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("src/crsto.txt"), "r");
		RandomAccessFile raf2 = new RandomAccessFile(new File("dest/crsto" + i + ".txt"), "rw");
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

}
