package e操作装饰流IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * -对象流： <br>
 * --写出后读取 <br>
 * --读取的顺序与写出保持一致 <br>
 * --不是所有的对象都可以序列化，必须实现Serializable接口 <br>
 * ObjectOutputStream <br>
 * ObjectInputStream <br>
 * 
 * @author 王以诚
 */
public class ObjectIOTest02 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 写出（顺序与读取一致）
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/obj.ser")));
		// 操作数据类型
		oos.writeUTF("编码辛酸泪");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChar('a');
		// 对象序列化
		oos.writeObject("谁解其中味");
		oos.writeObject(new Date());
		Employee emp = new Employee("马云", 40000);
		oos.writeObject(emp);
		oos.flush();
		// 读取（顺序与写出一致）
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/obj.ser")));
		String msg = ois.readUTF();
		int age = ois.readInt();
		boolean flag = ois.readBoolean();
		char ch = ois.readChar();
		System.out.println(msg + age + flag + ch);

		// 对象的数据还原（反序列化）
		Object str = ois.readObject();
		Object date = ois.readObject();
		Object employee = ois.readObject();
		if (str instanceof String) {
			String strObj = (String) str;
			System.out.println(strObj);
		}
		if (str instanceof Date) {
			Date dateObj = (Date) date;
			System.out.println(dateObj);
		}
		if (employee instanceof Employee) {
			Employee employeeObj = (Employee) employee;
			System.out.println(employeeObj.getName() + "挣" + employeeObj.getSalary() + "元");
		}
	}
}

// javaBean封装数据用
@SuppressWarnings("serial")
class Employee1 implements Serializable {

	private static String name; // 加上transient表明该数据不需要序列化，会返回一个null
	private double salary;

	public String getName() {
		return name;
	}

	@SuppressWarnings("static-access")
	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee1() {
	}

	@SuppressWarnings("static-access")
	public Employee1(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
}