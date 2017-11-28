package euler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Problem13 {
	public static void main(String args[]){
		String FILENAME;
		FILENAME = "/home/l2/temp1.txt";
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
		long tempL[] = new long[temp.size()];
		long result = 0;
		for(int i = 0; i < tempL.length; i++){
			tempL[i] = Long.parseLong(temp.get(i).substring(0, 15));
			result = result + tempL[i];
		}
		System.out.println(result/10000);
	}
}
