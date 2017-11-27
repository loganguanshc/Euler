package lintCode;

public class P13 {

	/*
	 * For a given source string and a target string, you should output the first index(from 0) of target string in source string.
	 */
	
	public static int strStr(String source, String target){
		// this is the brutal method with O(n^2)
		if(source == null || target == null){
			return -1;
		}
		if(target.isEmpty()){
			return 0;
		}
		char[] sor = source.toCharArray();
		char[] tar = target.toCharArray();		
		for(int i = 0; i < sor.length; i++){
			for(int j = 0; j < tar.length; j++){
				if(i+j >= sor.length){
					return -1;
				}
				if(sor[i+j] != tar[j]){
					break;
				}
				if(j == tar.length-1){
					return i;
				}
			}
		}
		
		return -1;
	}
	
	public static int kmp(String str, String target){
		char[] temp = str.toCharArray();
		char[] temp2 = target.toCharArray();
		int[] next = new int[target.length()];
		next = getNext(target);
		int i = 0; 
		int j = 0;
		while(i < str.length() && j < next.length){
			if(j == -1 || temp[i] == temp2[j]){
				i++;
				j++;
			}else{
				j = next[j];
			}
		}
		if(j == next.length){
			return i - j;
		}
		return -1;
	}
	
	public static int[] getNext(String str){
		
		char[] temp = str.toCharArray();
		int[] next = new int[temp.length];
		next[0] = -1;
		int k = -1;
		int j = 0;
		while(j < next.length-1){
			if(k == -1 || temp[j] == temp[k]){
				k++;
				j++;
				next[j] = k;
			}else{
				k = next[k];
			}
		}
		
		return next;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdabd";
		int[] a = new int[s.length()];
		a = getNext(s);
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}

}
