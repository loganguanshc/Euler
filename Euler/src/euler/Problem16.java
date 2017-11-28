package euler;
import java.math.BigInteger;

public class Problem16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = BigInteger.valueOf(2).pow(1000).toString();
		char b[] = new char[a.length()];
		long sum = 0;
		for(int i = 0; i < a.length(); i++){
			b[i]=a.charAt(i);
			sum = sum + Character.getNumericValue(b[i]);
			
		}
		System.out.print(sum);
	}
}
