package lintCode;

public class P6 {

	/*
	 * Merge two given sorted integer array A and B into a new sorted integer array.
	 */
	
	public static int[] mergeSortedArray(int[] a, int[] b){
		int[] res = new int[a.length+b.length];
		int aa = 0;
		int bb = 0;
		int i = 0;
		while(i < a.length + b.length ){
			if(aa == a.length){
				for(; bb < b.length; i++, bb++){
					res[i] = b[bb];
				}
				break;
			}
			if(bb == b.length){
				for(; aa < a.length; i++, aa++){
					res[i] = a[aa];
				}
				break;
			}
			if(a[aa] <= b[bb] ){
				res[i] = a[aa];
				i++;
				aa++;
			}else{
				res[i] = b[bb];
				i++;
				bb++;
			}
		}

		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3};
		int[] b = {1,2,3,4,5};
		int[] c = mergeSortedArray(a,b);
		for(int i = 0; i < c.length; i++){
			System.out.println(c[i]);
		}
		
	}

}
