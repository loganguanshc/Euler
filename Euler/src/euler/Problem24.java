package euler;
import java.util.ArrayList;
import java.util.List;

public class Problem24 {

	public static List lexicographic() {
		int input[] = {0,1,2,3,4,5,6,7,8,9};
		List<Integer> result = new ArrayList<Integer>();
		int count = 1000000;
		for(int i = input.length-1; i >= 1; i --) {
			int factor = factorial(i);
			int internalCount = 0;
			while(count > 0) {
				if(count - factor > 0) {
					count = count -factor;
					internalCount++;
					
				} else {
					break;
				}
			}
			System.out.println(factor);
//			if(input.length == 0) {
//				break;
//			}
			result.add(input[(int)internalCount]);
			input = newArray(input, input[internalCount]);
			
		}
		result.add(input[0]);
		return result;
	}
	
	public static int[] newArray(int[] arrayInput, int element){
		
		int[] outputArray = new int[arrayInput.length-1];
		for(int i = 0, j = 0; i < outputArray.length; i++) {
			if (arrayInput[i] != element) {
				outputArray[i] = arrayInput[i+j];
			} else {
				j = 1;
				outputArray[i] = arrayInput[i+j];
			}
			
		}
		
		return outputArray;
	}

	public static int factorial(int x) {

	        int fact = 1;
	        for (int i = 2; i <= x; i++) {
	            fact *= i;
	        }
	        return fact;
	    }

	
	public static void main(String args[]) {
		int input[] = {0,1,2,3,4,5,6,7,8,9};
		List result = lexicographic();
		for(int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
		}
	}
	
}

















