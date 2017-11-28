package euler;
import java.util.HashMap;
import java.util.Map;

public class Problem26 {

	public static int curLong(int num){
		Map<Integer,Integer>  hp = new HashMap<Integer, Integer>();
		int temp = 1;
		int count = 1;
		if(num > 10){
		//	hp.put(0, 0);
			temp = temp * 10;
		}
		if(num > 100){
		//	hp.put(1, 0);
			temp = temp* 10;
		}
		while(true){
			temp = temp * 10;
			temp = temp % num;
			System.out.println(temp);
			if(temp == 0){
				return 0;
			}
			hp.put(count, temp);
			count++;
			if(num > temp*10 ){
					hp.put(count, temp*10);
					temp = temp * 10;
					count++;
				}
			if(num > temp*100){
					hp.put(count, temp*10);
					temp = temp* 10;
					count++;
			}
			if(hp.containsValue((temp*10) % num)){
				break;
			}
		}
		return hp.size();
	}
	
	public static int findLongCycle(int num){
		int currentLongest = 0;
		int result = 0;
		int temp = 0;
		for(int i = 1; i <= num; i++){
			temp = curLong(i);
			if (temp > currentLongest){
				currentLongest = temp;
				result = i;
			}
	//		System.out.println(i);
	//		System.out.println(result);
		}
			
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLongCycle(1000));
		
	}

}






































