package e操作装饰流IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
public class ObjectIOTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 写出（顺序与读取一致）
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
		// 操作数据类型
		oos.writeUTF("全钒液流电池");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChar('a');
		// 对象序列化
		oos.writeObject("离子交换膜");
		oos.writeObject(new Date());
		Employee1 emp = new Employee1("张全蛋", 40000);
		oos.writeObject(emp);
		oos.flush();
		byte[] datas = baos.toByteArray();
		// 读取（顺序与写出一致）
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
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
		if (employee instanceof Employee1) {
			Employee1 employeeObj = (Employee1) employee;
			System.out.println(employeeObj.getName() + "挣" + employeeObj.getSalary() + "元");
		}
	}
}

// javaBean封装数据用
@SuppressWarnings("serial")
class Employee implements Serializable {

	private transient String name; // 加上transient表明该数据不需要序列化，会返回一个null
	private double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee() {
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
}