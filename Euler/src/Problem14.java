
public class Problem14 {

	public static int startNum(long num){
		int result = 0;
		while(num!=1){
			if (num % 2 == 0){
				num = num /2;
			}
			else {
				num = num * 3 + 1;
			}
			result++;
		}
		
		return result;
	}
	
	public static void main(String args[]){
		int count = 19;
		long result = 0;
		int g = 0;
		for (long i = 500001; i <= 1000000; i = i+2){
			g = startNum(i);
			if(count < g){
				count = g;
				result = i;
			}
		}
		System.out.println(result);
	}
	
}
