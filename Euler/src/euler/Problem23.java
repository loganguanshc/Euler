package euler;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, 
 * which means that 28 is a perfect number.
A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant 
if this sum exceeds n.
it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
 *Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers
 */
public class Problem23 {

	public static List<Integer> findAbundant(int upperlimit){
		
		List<Integer> abundantNum = new ArrayList<Integer>();
		
		for(int i = 12; i <= upperlimit; i++) {
			if(sumOfDivide(i)>i) {
				abundantNum.add(i);
			}
		}
		
		return abundantNum;
	}
	
	public static double SumOfAbu(int list[]) {
		double sum = 0;
		Set<Integer> result = new HashSet<Integer>();
		for(int i = 0; i < list.length -1; i ++) {
			for (int j = i; j < list.length; j ++) {
				if(list[i]+list[j]<28123) {
				//	System.out.println(list[i]+list[j]);
					result.add(list[i] + list[j]);
				
				}
			}
		}
		for(int i : result) {
			sum = sum + i;
		}
		System.out.println(sum);
		return sum;
	}
	
	public static int sumOfDivide(int num) {
		int sum = 1;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num != i*i) {
				if(num % i == 0) {
					sum = sum + i + num / i;
				}
				
			} else {
				sum = sum + i;
			}
			
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumOfDivide(12));
		List abuList = findAbundant(28123);
		System.out.println(abuList.size());
		int abuArray[] = new int[abuList.size()];
		for(int i = 0; i < abuArray.length; i++) {
			abuArray[i]=(int) abuList.get(i);
		}
		double sumTotal = 0;
		for (int i = 0; i < 28123; i ++) {
			sumTotal = sumTotal +i;
		}
		
//		Set<Integer> result = new HashSet<Integer>();
//		result.add(1);
//		result.add(2);
//		for(int i : result) {
//			System.out.println(i);
//		}
		System.out.println(sumTotal-SumOfAbu(abuArray));
		
		
	}

}











