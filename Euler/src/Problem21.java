

public class Problem21 {

	public int isAmicable(int i){
		int sum = 1;
		int sum2 = 1;
		for (int j = 2 ; j < Math.sqrt(i); j++){
			if(i % j == 0){
				sum = sum + j + i / j;
			//	System.out.println(j);
			}
		}
		if(i % Math.sqrt(i) == 0){
			sum = (int) (sum + Math.sqrt(i));
		}
		//System.out.println(sum);
		if (sum <= i){
			return 0;
		}
		else{
			for(int j = 2; j < Math.sqrt(sum); j++){
				if(sum % j == 0){
					sum2 = sum2 + j + sum / j;
				}
			}
			if(sum % Math.sqrt(sum) == 0){
				sum2 = (int) (sum2 + Math.sqrt(sum));
			}
		//	System.out.println(sum);
			if(i == sum2){
				return sum + sum2;
			}
			else{
				return 0;
			}
		}
		//return 0;
		//return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 0;
		Problem21 a = new Problem21();
		for (int i = 3; i <= 10000; i++){
			total = total + a.isAmicable(i);
	//		System.out.println(a.isAmicable(i));
		}
		System.out.println(total);
	}

}
