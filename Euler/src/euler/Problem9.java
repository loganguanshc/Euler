package euler;

public class Problem9 {
	
	public static void main(String args[]){
		int x,y,z;
		for(int i = 1; i <= 997; i++){
			for(int j = 1; j <=997; j++){
				if (i*i + j*j == (1000-i-j)*(1000-i-j)){
					System.out.print(i*j*(1000-i-j));
				}
			}
		}
	}
}
