
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "/home/logan/saveTempFile/temp2.txt";
		BufferedReader br = null;
		StringBuffer sB = new StringBuffer();
		
		try {
			String curLine;
			br = new BufferedReader(new FileReader(fileName));
			while((curLine = br.readLine())!= null) {
				sB.append(curLine);
				sB.append("\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
		}
		String temp[] = sB.toString().split("\n");
		int tempInt[][] = new int[temp.length][];
		for (int i = 0; i < temp.length; i++) {
			String temp2[] = temp[i].split(" ");
			tempInt[i] = new int[temp2.length];
			for(int j = 0; j < temp2.length; j++) {
				tempInt[i][j] = Integer.parseInt(temp2[j]);
		//		System.out.println(tempInt[i][j]);
			}
		}
		
		for(int i = 1; i < tempInt.length; i++) {
			for(int j = 0; j < tempInt[i].length; j++) {
				
				if(j > 0 && j < tempInt[i].length-1) {
					if (tempInt[i-1][j-1] <= tempInt[i-1][j]) {
						tempInt[i][j] = tempInt[i][j] + tempInt[i-1][j];
					} else {
						tempInt[i][j] = tempInt[i][j] + tempInt[i-1][j-1];
					}
				}
				
				if(j == 0) {
					tempInt[i][j] = tempInt[i][j] + tempInt[i-1][j];
				} 
			
				if(j == tempInt[i].length-1) {
					tempInt[i][j] = tempInt[i][j] + tempInt[i-1][j-1];
				} 
			}
		}
		int maxiSum = tempInt[tempInt.length-1][0];
		for(int j = 1; j < tempInt[tempInt.length-1].length; j++) {
			if(tempInt[tempInt.length-1][j]> maxiSum) {
				maxiSum = tempInt[tempInt.length-1][j];
			}
		}
		System.out.print(maxiSum);
	}

}
