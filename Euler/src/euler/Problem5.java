package euler;

public class Problem5 {

	public static double minDivided(int input){
		double finResult = 1;
		int numOfInput = input;
		int temp[] = new int[input];
		int pow[] = new int[input+1];
		int power = 0;
		for (int i = 0; i < temp.length; i++){
			temp[i] = i + 1;
		}
		
		for(int i = 2; i <= input; i ++){
			pow[i] = 0;
			for(int j = temp.length-1; j >= 2; j --){
				while(temp[j] % i == 0){
					temp[j] = temp[j] / i;
					power ++;
				}
				System.out.println(" temp j "+j+" " +temp[j]);
				if (power > pow[i]){
					pow[i] = power;
				}
				power = 0;
			}
			System.out.println(pow[i]);
		}
		for (int i = 2; i < pow.length; i++){
			finResult = finResult*Math.pow(i, pow[i]);
		}
		
		return finResult;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((long)minDivided(20));
	}
	
}
