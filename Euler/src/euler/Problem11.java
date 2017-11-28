package euler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Problem11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String FILENAME;
		FILENAME = "/home/l2/temp.txt";
		BufferedReader br = null;
		FileReader fr = null;
		List <String> temp = new ArrayList<String>();
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			br = new BufferedReader(new FileReader(FILENAME));
			while ((sCurrentLine = br.readLine()) != null) {
					temp.add(sCurrentLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
					if (fr != null)
						fr.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
		int tempInt[][] = new int[temp.size()][temp.get(0).split(" ").length];
		
	//	String temp1[] = temp.get(0).split(" ");
		for(int i = 0; i < temp.size(); i++){
			for(int j = 0; j < temp.get(0).split(" ").length; j++){
				tempInt[i][j] = Integer.parseInt(temp.get(i).split(" ")[j]);
				System.out.print(tempInt[i][j]+ " ");
			}
			System.out.println();	
		}
		long result = 1;
		for(int i = 0; i < temp.size()-3; i++){
			for(int j = 0; j < temp.get(0).split(" ").length-3; j++){
				if(tempInt[i][j]*tempInt[i+1][j+1]*tempInt[i+2][j+2]*tempInt[i+3][j+3] > result){
					result = tempInt[i][j]*tempInt[i+1][j+1]*tempInt[i+2][j+2]*tempInt[i+3][j+3];
				}
				if(tempInt[i][j]*tempInt[i][j+1]*tempInt[i][j+2]*tempInt[i][j+3] > result){
					result = tempInt[i][j]*tempInt[i][j+1]*tempInt[i][j+2]*tempInt[i][j+3];
				}
				if(tempInt[i][j]*tempInt[i+1][j]*tempInt[i+2][j]*tempInt[i+3][j] > result){
					result = tempInt[i][j]*tempInt[i+1][j]*tempInt[i][j+2]*tempInt[i][j+3];
				}
			}
		}
		for(int i = temp.size()-1; i > 2; i--){
			for(int j = 0; j < temp.get(0).split(" ").length-3; j++){
				if(tempInt[i][j]*tempInt[i-1][j+1]*tempInt[i-2][j+2]*tempInt[i-3][j+3] > result){
					result = tempInt[i][j]*tempInt[i-1][j+1]*tempInt[i-2][j+2]*tempInt[i-3][j+3];
				}

		//		tempInt[i][j] = Integer.parseInt(temp.get(i).split(" ")[j]);
		//		System.out.print(tempInt[i][j]+ " ");
			}
		//		
		}
		System.out.println(result);
	}		
}


