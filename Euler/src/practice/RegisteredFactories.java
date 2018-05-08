package practice;
import java.util.*;

class Part{
	public String toString(){
		return getClass().getSimpleName();
	}
	static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
	static{
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFilter.Factory());
		partFactories.add(new FanBelt.Factory());
		partFactories.add(new GeneratorBelt.Factory());
	}

	private static Random rand = new Random(47);
	public static Part createRandom(){
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}

class Filter extends Part{
	
}

class FuelFilter extends Filter{
	
	public static class Factory implements practice.Factory<FuelFilter>{
		public FuelFilter create(){
			return new FuelFilter(); 
		}
	}
	
}

class AirFilter extends Filter{
	
	public static class Factory implements practice.Factory<AirFilter>{
		public AirFilter create(){
			return new AirFilter();
		}
	}
	
}

class Belt extends Part{
	
}

class FanBelt extends Belt{
	
	public static class Factory implements practice.Factory<FanBelt>{
		public FanBelt create(){ 
			return new FanBelt();
		}
	}
	
}

class GeneratorBelt extends Belt{
	
	public static class Factory implements practice.Factory<GeneratorBelt>{
		public GeneratorBelt create(){
			return new GeneratorBelt();
		}
	}
	
}

public class RegisteredFactories {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++){
			System.out.println(Part.createRandom());
		}
	}

}












