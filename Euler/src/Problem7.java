
public class Problem7 {
	
	public static long findPrime(int count){
		long res = 2;
		boolean flag = false;
		while(count >= 2){
			res++;
			for(long i = 2; i < res; i++){
				if(res % i == 0){
					flag = true;
					break;
				}
			}
			if(!flag){
				count--;
			}
			flag = false;
		
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPrime(10001));
	}

}
