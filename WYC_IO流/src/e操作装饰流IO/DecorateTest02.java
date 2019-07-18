package e操作装饰流IO;

/**
 * 模拟咖啡 <br>
 * - 抽象组件：需要装饰的抽象对象（一般是接口或父类）<br>
 * - 具体组件：需要装饰的对象 <br>
 * - 抽象装饰类：包含了对抽象组件的引用以及装饰者共有的方法 <br>
 * - 具体装饰类：被装饰的对象 <br>
 * 
 * @author 王以诚
 */
public class DecorateTest02 {
	public static void main(String[] args) {
		Drink coffee = new Coffee();
		System.out.println(coffee.info() + "-->" + coffee.cost());
		Drink sugar = new Sugar(coffee);
		System.out.println(sugar.info() + "-->" + sugar.cost());
		Drink milk = new Milk(coffee);
		System.out.println(milk.info() + "-->" + milk.cost());
		milk = new Milk(milk);
		System.out.println(milk.info() + "-->" + milk.cost());
	}
}

interface Drink {
	double cost(); // 费用

	String info(); // 说明
}

class Coffee implements Drink {
	private String name = "原味咖啡";

	@Override
	public double cost() {
		return 10;
	}

	@Override
	public String info() {
		return name;
	}

}

// 抽象装饰类
abstract class Decorate implements Drink {
	private Drink drink;

	Decorate(Drink drink) {
		this.drink = drink;
	}

	@Override
	public double cost() {
		return this.drink.cost();
	}

	@Override
	public String info() {
		return this.drink.info();
	}
}

//具体装饰类
class Milk extends Decorate {
	public Milk(Drink drink) {
		super(drink);
	}

	@Override
	public double cost() {
		return super.cost() * 4;
	}

	@Override
	public String info() {
		return super.info() + "加入了牛奶";
	}
}

class Sugar extends Decorate {
	public Sugar(Drink drink) {
		super(drink);
	}

	@Override
	public double cost() {
		return super.cost() * 2;
	}

	@Override
	public String info() {
		return super.info() + "加了糖";
	}
}