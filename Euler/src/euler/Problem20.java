
import java.math.*;

public class Problem20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger result = new BigInteger("1");
		for(int i = 2; i <= 100; i++){
			result = result.multiply(BigInteger.valueOf(i));
		}
		char temp[] = result.toString().toCharArray();
		int resultTemp = 0;
		for(int i = 0; i < temp.length; i++){
			resultTemp += Character.getNumericValue(temp[i]);
		}
		System.out.println(resultTemp);
	}

}
