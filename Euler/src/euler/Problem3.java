package euler;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class Problem3 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("running");
		long  i = 600851475143L;
		List<Long> result = new ArrayList<Long>();
		long j;
		int k=0;
		while(i>2){
			for(j = 2; j < i; j ++){
				if(i % j == 0){
					result.add(j);
					k++;
					i = (long) java.lang.Math.ceil(i/j);
					System.out.println(result.size());
					System.out.println(i);
				}
				if(i <= 1){
					break;
				}
			}
		}
		System.out.println("still");
		System.out.println(result.get(result.size()-1));
	}

}
