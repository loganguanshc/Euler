package lintCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class P684 {
	public List<String> missingString(String str1, String str2) {
	        // Write your code here
		String[] arraystr1 = str1.split(" ");
		String[] arraystr2 = str2.split(" ");
		List<String> result = new LinkedList<String>();
		HashSet<String> setstr2 = new HashSet<String>();
		for(int i = 0; i < arraystr2.length; i++){
			if(!setstr2.contains(arraystr2[i])){
				setstr2.add(arraystr2[i]);
			}
		}
		for(int i = 0; i < arraystr1.length; i++){
			if(!setstr2.contains(arraystr1[i])){
				result.add(arraystr1[i]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
