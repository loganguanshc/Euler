package lintCode;

public class P1 {
	/*
	 * Write a function that add two numbers A and B. You should not use + or any arithmetic operators.
	 */
	
	public static int aplusb(int a, int b) {
        
		while(b != 0){
			int temp = a&b;
			a = a^b;
			b = temp<<1;
		}
		
        return a;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(aplusb(5,2));
	}

}
