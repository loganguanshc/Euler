
public class Problem12 {

	public static long findTriangular(int divisor){
		long result = 6;
		long counter = 3;
		int count = 0;
		while(true){
			for (long i = 1; i*i <= result; i++){
				if(result % i == 0){
					count= count + 2;
				}
			}
			if (count > divisor){
				return result;
			}
			else{
				count = 0;
			}
			counter++;
			result=result+counter;
			System.out.println(counter);
		}
	}
	
	public static void main(String args[]){
		System.out.print(findTriangular(500));
	}
}
