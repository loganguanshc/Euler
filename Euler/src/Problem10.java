
public class Problem10 {

	public static long primeNum(long num){
		for(int i = 2; i < num/2+1; i++){
			if (num % i == 0){
				return 0;
			}
		}
		System.out.println(num);
		return num;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long  bigNum = 2000000;
		long sum = 0;
		for (int i = 2; i <= bigNum; i++){
			sum = sum + primeNum(i);
		}
		System.out.println(sum);
	}

}
