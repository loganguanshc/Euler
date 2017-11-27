package leetC;

import java.util.Arrays;

public class P1 {

	/*
	 * Given nums = [2, 7, 11, 15], target = 9,
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
	 */
	
	/*
	 * Wrong answers:
	 * 1. the return value is the original array not the sorted one
	 * 2. the array may have the same int value elements.
	 *    use flag and continue 
	 */
	
    public int[] twoSum(int[] nums, int target){
    	// input: array, the sum target
    	// output: the subcript of addends
    	int[] temp = new int[nums.length];
    	for(int i = 0; i < temp.length; i++){
    		temp[i] = nums[i];
    	}
    	int[] result = new int[2];
    	Arrays.sort(nums);
    	result[0] = 0;
    	result[1] = nums.length - 1;
    	while(result[0] != result[1]){
    		if(nums[result[0]]+nums[result[1]] == target){
    			break;
    		}
    		if(nums[result[0]]+nums[result[1]] > target){
    			result[1]--;
    		}
    		if(nums[result[0]]+nums[result[1]] < target){
    			result[0]++;
    		}
    	}
    	boolean flag1 = false;
    	boolean flag2 = false;
    	for(int i = 0; i < temp.length; i++){
    		if(flag1 == false && temp[i] == nums[result[0]]  ){
    			result[0] = i;
    			flag1 = true;
    		}
    		if( flag2 == false && temp[i] == nums[result[1]] ){
    			result[1] = i;
    			flag2 = true;
    		}
    	}

    	return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * The solution is 
		 * 1) sort nlogn
		 * 2) find result n
		 */
	}

}
