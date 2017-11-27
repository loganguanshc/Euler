package leetC;

import java.util.ArrayList;
import java.util.List;

public class P3 {
	
	/*
	 * wrong answer:
	 * 1. subList(from, to): includes from excludes to so to should be size() not size()-1 
	 * 2.time limit exceeded TT 
	 * because in ArrayList, the actual objects are never stored at contiguous locations. 
	 * References of the actual objects are stored at contiguous locations.
	 * 
	 * go v2 for the optimization ... 
	 */
	
    public static int lengthOfLongestSubstring(String s) {
    	
    	int result = 0;
    	List<Character> temp = new ArrayList<Character>();
    	//init
    	if(s == null){
    		return 0;
    	}
    	char[] tempChar = s.toCharArray();

    	//loop the string
    	for(int i = 0; i < s.length(); i++){
    		// not repeated, add the char to the end of the tempArray
    		
    		if(!temp.contains(tempChar[i])){
    			temp.add(tempChar[i]);
    		} 
    		// repeated, transform the tempArray. 
    		else{
    			if(temp.indexOf(tempChar[i])+1 >= temp.size()){
    				temp.clear();
    				temp.add(tempChar[i]);
    			} 
    			else{
        			int j = temp.indexOf(tempChar[i])+1;
        			temp = temp.subList(j, temp.size());
        			System.out.println(temp.size());
        			temp.add(tempChar[i]);
        			
    			}

    		}
    		if(temp.size()>result){
    			result = temp.size();
    		}
    		
    	}
    	
    	return result;
    	
    }
	
	/*
	 * Given "abcabcbb", the answer is "abc", which the length is 3.

	   Given "bbbbb", the answer is "b", with the length of 1.

       Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 */
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dvdf"));
		// TODO Auto-generated method stub
		/*
		 * solution:
		 * save the unrepeated string appears in an array, update the array when repeated occurs,
		 * 
		 * 
		 * 
		 */
	}

}
