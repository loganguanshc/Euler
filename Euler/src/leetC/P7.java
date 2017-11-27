package leetC;

public class P7 {

	/*
	 * Example1: x = 123, return 321
	   Example2: x = -123, return -321
	   return 0 when the reversed integer overflows
	 */
	
	/*
	 * Wrong answers:
	 * the (-1)Integer.MIN_VALUE is itself not zero in java 
	 */
	
	
    public int reverse(int x) {
        boolean symbol = false;
        
        if(x == Integer.MIN_VALUE){
            return 0;
        }
            
		if(x < 0 && x > Integer.MIN_VALUE){
			symbol = true;
			x = -x;
		}
		String temp = Integer.toString(x);
		String rev = (new StringBuffer(temp)).reverse().toString();
		double result = Double.valueOf(rev);
		if(symbol == false && result <= Integer.MAX_VALUE){
			return (int)result;
		}
		if(symbol == true){
			result = -result;
			if(result >= Integer.MIN_VALUE){
				return (int)result;
			}
		}
		return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P7 test = new P7();
		test.reverse(-2147483648);
		System.out.println(-Integer.MAX_VALUE);
		/*
		 * solution: 
		 * 1. check if >0 or <0
		 * 2. to string
		 * 3. reverse
		 * 4. check overflow
		 * 5. add symbol to int
		 */
	}

}
