package lintCode;

public class P2 {

	/*
	 * Write an algorithm which computes the number of trailing zeros in n factorial.
	 */
	
	public static long trailingZeros(long n){
		
		long result = 0L;
		long comparing = 5L;
		while(n >= comparing){
			result = result + (long)(n/comparing);
			comparing*=5;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeros(55555500000L));
	}

}
