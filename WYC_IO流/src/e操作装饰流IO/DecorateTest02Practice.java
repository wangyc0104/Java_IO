package e操作装饰流IO;

/**
 * 模拟装修 <br>
 * - 抽象组件：需要装饰的抽象对象（一般是接口或父类）<br>
 * - 具体组件：需要装饰的对象 <br>
 * - 抽象装饰类：包含了对抽象组件的引用以及装饰者共有的方法 <br>
 * - 具体装饰类：被装饰的对象 <br>
 * 
 * @author 王以诚
 */
public class DecorateTest02Practice {
	public static void main(String[] args) {
		House house = new House();
		System.out.println(house.info() + "值" + house.cost() + "元");
		Mansion mansion = new Mansion(house);
		System.out.println(mansion.info() + "值" + mansion.cost() + "元");
		mansion = new Mansion(mansion);
		System.out.println(mansion.info() + "值" + mansion.cost() + "元");
	}
}

interface Building {
	public int cost();

	public String info();
}

class House implements Building {
	public int cost() {
		return 1000000;
	}

	public String info() {
		return "普通小别墅";
	}
}

abstract class Embellishment implements Building {
	Building building;

	public Embellishment(Building building) {
		this.building = building;
	}

	public abstract int cost();

	public abstract String info();

}

class Mansion extends Embellishment {

	public Mansion(Building building) {
		super(building);
	}

	public int cost() {
		return building.cost() * 5;
	}

	public String info() {
		return building.info() + "旁边的楼房";
	}

}