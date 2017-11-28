package euler;

public class Problem15 {

	public static long counter (int left, int right){
		if(left == 1){
			return right + 1;
		}
		if(right == 1){
			return left + 1;
		}
		return counter(left, right-1)  + counter(left-1, right);
		
		//return sum;
	}
	
	public static long counter2 (int left, int right){
		if(left == 1){
			return right + 1;
		}
		if(right == 1){
			return left + 1;
		}
		return counter2(left, right-1)  + counter2(left-1, right);
		
		//return sum;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(counter(20,20));

		
	}
}
