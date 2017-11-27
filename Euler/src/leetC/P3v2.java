package leetC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class P3v2 {
	
	/*
	 * this is for the optimization of time limits,
	 * using hashmap as each key is char and value is suffix
	 * when finding repeated, 
	 * 1. delete all kv with value smaller that it (sliding window to reduce computing complexity)
	 * 2. update the repeated char
	 * 3. update current length
	 */
	
	/*
	 * wrong answer:
	 * 1.cannot delete or remove in the iteration
	 * 2. how to target the elements that should be deleted: use the source to target the ones need to be deleted 
	 * on the destination
	 */
	
	public static int lengthOfLongestSubstring(String s){
		
		int result = 0;
		char charS[] = s.toCharArray();
		
		//init:
		if(s.length() == 0){
			return 0;
		}
		
		HashMap<Character, Integer> tempH = new HashMap<Character, Integer>();
		int tempLength = 0;
		//main loop that traverse the char array
		for(int i = 0, j = 0; i < charS.length; i++){
			if(!tempH.containsKey(charS[i])){
				tempH.put(charS[i], i);
				tempLength++;
				System.out.println("i: "+i);
				System.out.println("size: "+tempH.size());
				if(tempLength > result){
					result = tempLength;
				}
			}
			else{
				int temp = tempH.get(charS[i]);
				
				System.out.println("i: "+i);
				System.out.println("temp: "+temp);
				System.out.println("pre-size: "+tempH.size());
				for(int k = j; k <= temp; k++){
					tempH.remove(charS[k]);
				}
				
//				Iterator<Map.Entry<Character, Integer>> iter = tempH.entrySet().iterator();
//				while(iter.hasNext()){
//					Map.Entry<Character, Integer> entry = iter.next();
//					if(entry.getValue() < temp){
//						iter.remove();
//					}
//				}
//				for(Map.Entry<Character, Integer> entry : tempH.entrySet()){
//					if(entry.getValue() < temp){
//						tempH.remove(entry.getKey());
//					}
//				}
				j = temp+1;
				
				
				System.out.println("changed "+tempH.put(charS[i],i));
				tempLength = tempH.size();
				System.out.println("after-size: "+tempH.size());
				System.out.println("j: "+j);
				
			}
			
		}
		if(tempLength > result){
			result = tempLength;
		}
		//end
		return result;
	}
	
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
            System.out.println(set.size());
        }
        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

}
