package practice;
import java.util.*;


public class RandomList<T> {
	private ArrayList<T> storage = new ArrayList<T>();
	private Random rand = new Random(47);
	
	public void add(T item){
		storage.add(item);
	}
	public T select(){
		return storage.get(rand.nextInt(storage.size()));
	}
	public static void main(String[] args){
		RandomList<String> rs = new RandomList<String>();
		for(String s: ("a b c d e f g h i j k l m n").split(" ")){
			rs.add(s);
		}
		System.out.println(rs);
		for(int i = 0; i < 11; i++){
			System.out.println(rs.select() + " ");
		}
	}
	
}
