package lintCode;

import java.util.ArrayList;
import java.util.List;

public class P22 {

	/*
	 * Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.
	 * Given [1,2,[1,2]], return [1,2,1,2].
	   Given [4,[3,[2,[1]]]], return [4,3,2,1].
	 */
    public List<Integer> flatten(List<NestedInteger> nestedList){
		
    	List<Integer> result = new ArrayList<Integer>();
    	for(int i = 0; i < nestedList.size(); i++){
    		if(nestedList.get(i).isInteger()){
    			result.add(nestedList.get(i).getInteger());
    		}
    		else{
    			result.addAll(flatten(nestedList.get(i).getList()));
    		}
    	}
    	return result;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface NestedInteger {

     // @return true if this NestedInteger holds a single integer,
     // rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds,
     // if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds,
     // if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }
