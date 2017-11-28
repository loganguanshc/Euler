package euler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P27 {
	/*
	 * Considering quadratics of the form:

n2+an+b, where |a|<1000|a|<1000 and |b|≤1000|b|≤1000

Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, 
starting with n=0.
	 */
	public static List<Integer> findPrime(int num){
		
		List<Integer> result = new ArrayList<Integer>();
		result.add(-2);
		result.add(2);
		int numOfPrime = 0;
		for(int i = 3; i < num; i ++){
			int count = 0;
				for(int j = 2; j <=(int)(Math.sqrt(i)+1); j++){
					if(i % j == 0){
						count++;
						break;
					}
				}
			if(count == 0){
				result.add(i);
				result.add(-i);
				numOfPrime = numOfPrime + 2;
			}
		}
	//	System.out.println(numOfPrime);
		return result;
	}
	
	public static Map<Integer,List<Integer>> findA(List<Integer> resultB, List<Integer> bigP){
		
		Map<Integer, List<Integer>> resultAB = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i < resultB.size(); i++){
			List<Integer> result = new ArrayList<Integer>();
			for(int j = 0; j < bigP.size(); j++){
				int temp = bigP.get(j)-resultB.get(i)-1;
				if(temp < 1000 && temp >-1000){
					result.add(temp);
				}
			}
			resultAB.put(resultB.get(i), result);
		}
		
		return resultAB;
	}
	
	public static int findLongestPrime(int i, int j){
		
		int n = 0;
		int temp = 0;
		int result = 0;
		while(true){
			
			temp = n*n+j*n+i;
//			System.out.println(temp);
			if(temp == 0 || temp == 1 || temp == -1){
				break;
			}
			int count = 0;
			if(temp < 0){
				temp = -temp;
			}
			for(int k = 2; k <=(int)(Math.sqrt(temp)+1); k++){
				if(temp % k == 0 && temp != 2 ){
					count++;
					break;
				}
			}
			if(count == 0){
				result++;
			}
			else{
				break;
			}
			n++;
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> resultB = findPrime(1000);
		List<Integer> bigP = findPrime(2000);
		for(int i = 0; i <resultB.size(); i++){
		//	System.out.println(resultB.get(i));
		}
		Map result = findA(resultB,bigP);
		int[] finalRes = new int[4];
		//System.out.println(result.keySet());
		for(Object key : result.keySet()){
		//	System.out.println(key);
			List<Integer> temp = ((ArrayList<Integer>) (result.get(key)));
			for(int j = 0; j < temp.size(); j++){
		//		System.out.println("i is: "+ key + " j is: "+temp.indexOf(j));
				
				int tempRes= findLongestPrime((int)(key), temp.get(j));
		//		System.out.println("result is: "+ tempRes);
				if(tempRes > finalRes[0]){
					finalRes[0] = tempRes;
					finalRes[1] = (int)key * temp.get(j);
					finalRes[2] = (int)key;
					finalRes[3] = temp.get(j);
				}
			}
		}
		System.out.println(Math.sqrt(-9));
		//		System.out.println(findLongestPrime(61, -999));
		System.out.println(finalRes[0]);
		System.out.println(finalRes[1]);
		System.out.println(finalRes[2]);
		System.out.println(finalRes[3]);
	}

}
