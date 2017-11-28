package euler;

public class Problem4 {
	
	public static Boolean parlindromic(long input){
		String temp = String.valueOf(input);
	//	System.out.println(temp);
		if(temp.equals(new StringBuilder(temp).reverse().toString())){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.out.println(parlindromic(9009));
		long product = 0;
		long temp = 0;
		for(int i = 999; i > 100; i--){
			for(int j = 999; j > 100; j--){
				product = i * j;
				if(parlindromic(product)){
					if (product>temp){
						temp = product;
					} else{
						break;
					}
				}
			}
		}
		System.out.println(temp);
		
	}

}
