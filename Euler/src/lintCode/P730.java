package lintCode;

public class P730 {
	
	/*
	 * Find all the subsets from one N 
	 * 
	 * Memory Limit exceeded...
	 */
	
	public static int[] flagSet(int[] flag){
		
		for(int i = 0; i < flag.length; i++){
			if(flag[i] == 0){
				flag[i] = 1;
				break;
			}else{
				flag[i] = 0;
			}
		}
		return flag;
	}
	
	public static int sumOfSubsets(int n){
		int[] flag = new int[n];
		int[] num = new int[n];
		int result = 0;
		for(int i = 0; i < n; i++){
			num[i] = i+1;
			flag[i] = 0;
		}
		for(int j = 0; j < (int)Math.pow(2,n); j++){
			flagSet(flag);
			for(int i = 0; i < n; i++){
				result = result+ num[i]*flag[i];
			//	System.out.println(result);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumOfSubsets(28));
	}

}
