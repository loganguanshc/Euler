package lintCode;

public class P28 {

	/*
	 * Write an efficient algorithm that searches for a value in an m x n matrix.
	 */
	
    public static boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
    	
    	if(matrix == null || matrix.length==0 ){
    		return false;
    	}
    	
    	int a = 0;
    	int b = matrix.length*matrix[0].length-1;
    	
    	while(a+1 < b){
    		int mid = (a+b)/2;
    		int temp = matrix[mid/matrix[0].length][mid%matrix[0].length];
    		if(target == temp){
    			return true;
    		}
    		if(target > temp){
    			a = mid;
    		}
    		if(target < temp){
    			b = mid;
    		}
    	}
    	
    	if(matrix[a/matrix[0].length][a%matrix[0].length] == target){
    		return true;
    	}
    	if(matrix[b/matrix[0].length][b%matrix[0].length] == target){
    		return true;
    	}
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
