package lintCode;

public class P14 {

	public static int binarySearch(int[] nums, int target){
		
		int a = 0;
		int b = nums.length-1;
		int temp;
		while(a+1 < b){
			temp = (a+b)/2;
			if(target > nums[temp]){
				a = temp;
			}else{
				b = temp;
			}
		}
		if(a == target){
			return a;
		}
		if(b == target){
			return b;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
