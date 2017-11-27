package lintCode;

public class P366 {

	public int fibonacci(int n) {
        // write your code here
		if(n == 1){
			return 0;
		}
		if(n == 2){
			return 1;
		}
		int i = 0;
		int j = 1;
		int result = 0;
		for(int index = 1; index < n; index++){
			if(index % 2 == 0){
				i = i+j;
				result = i;
			} else{
				j = j+i;
				result = j;
			}
			
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
