package practice;

interface HasBatteries{};
interface Waterproof{};
interface Shoots{};

class Toy{
	Toy(){};
	Toy(int i){
		
	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
	FancyToy(){
		super(1);
	}
}

public class ToyTest {

	static void printInfo(Class cc){
		System.out.println(cc.getName()+" "+cc.isInterface());
		System.out.println(cc.getSimpleName());
		System.out.println(cc.getCanonicalName());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class c = null;
		try{
			c = Class.forName("practice.FancyToy");
		} catch(ClassNotFoundException e){
			System.exit(1);
		}
		printInfo(c);
		for(Class face : c.getInterfaces()){
			printInfo(face);
		}
		Class up = c.getSuperclass();
		Object obj = null;
		try{
			obj = up.newInstance();
		} catch(InstantiationException e){
			System.exit(1);
		} catch(IllegalAccessException e){
			System.exit(1);
		}
		printInfo(obj.getClass());
	}

}
