package lintCode;

public class P8 {

	/*
	 * Given a string and an offset, rotate string by offset. (rotate from left to right)
	 */
	
	public static void rotateString(char[] str, int offset){
		char temp;
		if(str.length == 0){
			return;
		}
		offset = offset % str.length;
		for(int i = 1; i <= offset; i++){
			temp = str[str.length-1];
			for(int j = str.length-1; j > 0; j--){
				str[j] = str[j-1];
			}
			str[0]=temp;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = "abcdefg".toCharArray();
		int offset = 3;
		rotateString(str, offset);
	}

}
