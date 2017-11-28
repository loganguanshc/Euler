import java.math.*;
public class Problem25 {

	public static int fib(int n) {
		int count = 1;
		double result = (1/Math.sqrt(5))*((1+Math.sqrt(5))/2);
		for(int i = 1; i < n; i++) {
			result *= ((1+Math.sqrt(5))/2);
			if(result>10) {
				result = result /10;
				count ++;
			}
		}
		
		return count;
	}
	
	public static void main(String args[]) {
		int dig = 1000;
		int i = 3;
		while(fib(i)<dig) {
			i++;
		}
		System.out.println(i);
	}
}
