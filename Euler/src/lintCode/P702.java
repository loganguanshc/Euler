package lintCode;

import java.util.HashSet;

public class P702 {
	
	public static String concatenetedString(String s1, String s2) {
        // write your code here
		if(s1.isEmpty() && s2.isEmpty()){
			return null;
		}
		if(s1.isEmpty()){
			return s2;
		}
		if(s2.isEmpty()){
			return s1;
		}
		HashSet<Character> S1 = new HashSet<Character>();
		HashSet<Character> S2 = new HashSet<Character>();
		for(int i = 0; i< s1.length(); i++){
			S1.add(s1.charAt(i));
		}
		for(int i = 0; i< s2.length(); i++){
			S2.add(s2.charAt(i));
		}
		StringBuilder sb1 = new StringBuilder(s1);
		int j = 0;
		for(int i = 0; i< s1.length(); i++){
			if(S2.contains(sb1.charAt(i-j))){
				sb1.deleteCharAt(i-j);
				j++;
			}
		}
		j = 0;
		StringBuilder sb2 = new StringBuilder(s2);
		for(int i = 0; i< s2.length(); i++){
			if(S1.contains(sb2.charAt(i-j))){
				sb2.deleteCharAt(i-j);
				j++;
			}
		}
		String result = sb1.toString()+sb2.toString();
		return result;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(concatenetedString("abcs","cxzca"));
	}

}
