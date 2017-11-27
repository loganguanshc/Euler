package lintCode;

public class P697 {

	public static boolean checkSumOfSquareNumbers(int num) {
		int i = 0;
		int j = 0;
		
		for(i = 0; i <= (int)Math.sqrt(num)+1; i++){
			for(j = 0; j <= (int)Math.sqrt(num)+1; j++){
				int temp = i*i+j*j;
				System.out.println("i: "+i+" j: "+j+"="+temp);
				if(temp==num){
					return true;
				}
				if(temp>num){
					break;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkSumOfSquareNumbers(549293));

	}

}
