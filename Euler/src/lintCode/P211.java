package lintCode;

import java.util.HashMap;
import java.util.Map;

public class P211 {

    public static boolean Permutation(String A, String B) {
        // write your code here
    	
    	if(A.isEmpty() && B.isEmpty()){
    		return true;
    	}
    	if(A.isEmpty() || B.isEmpty()){
    		return false;
    	}
    	
    	Map<Character, Integer> temp = new HashMap<Character, Integer>();
    	char[] tempA = A.toCharArray();
    	char[] tempB = B.toCharArray();
    	for(int i = 0; i < tempA.length; i++){
    		if(!temp.containsKey(tempA[i])){
    			temp.put(tempA[i], 1);
    		} else{
    			int j = temp.get(tempA[i])+1;
    			temp.put(tempA[i], j);
    		}
    	}
    	for(char i : temp.keySet()){
    		System.out.println( "char: "+i+"\t"+"times: "+temp.get(i));
    		
    	}
    	for(int i = 0; i < tempB.length; i++){
    		if(!temp.containsKey(tempB[i])){
    			return false;
    		} else{
    			int j = temp.get(tempB[i])-1;
    			if(j < 0){
    				return false;
    			}
    			temp.put(tempB[i], j);
    		}
    	}
    	
    	for(int i : temp.values()){
    		if(i > 0){
    			return false;
    		}
    	}

    	return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "asfhjhsajfhjahsfueuhuqpasjfnmxznbdsafueqhuuuhuhuihu7y8u87890-0---kjsafkjaskjfsalkfnmzxncmncfafuenfjasnfjkanhds";
		String B = "afkjaskhjaafuehfasfhjhsajfhuh-kjsjasnfjkanhdshsfuihu7y8u87890-0-fueqhuuujfqpalkfnmz-ueuhufnmsjsaxznbdsaxncmncf";
		System.out.println(Permutation(A,B));
	}

}
