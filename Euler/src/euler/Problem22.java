package euler;


import java.io.*;
import java.util.Arrays;

public class Problem22 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("e:/bk/test.txt");
		BufferedReader br = new BufferedReader(fr);
		String tempS[] = br.readLine().split(",");
		Arrays.sort(tempS);
		int sum = 0;
		int sumt = 0;
		int sumsu = 0;
		for(int i = 0; i < tempS.length; i ++){
			char tempC[] = tempS[i].toCharArray();
			for (int j = 1; j< tempC.length-1; j++){
				sumt = sumt + tempC[j] - 'A'+1;
			}
			sum = sum + sumt*(i+1);
			sumt = 0;
		}
		System.out.println(sum);
	}

}
