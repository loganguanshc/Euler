
public class Problem6 {

	public static long numDiff(int num){
		long sum1 = 0;
		long sum2 = 0;
		for (int i = 1; i <= num; i ++){
			sum1 = sum1 + i*i;
			sum2 = i + sum2;
		}
		return sum2 * sum2 - sum1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDiff(100));
	}

}
