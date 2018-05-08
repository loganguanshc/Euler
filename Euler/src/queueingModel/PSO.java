package queueingModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PSO {

	/*
	 * This is the PSO to find the optimized resource allocation solution.
	 * 
	 * The problem is a m X n matrix, find the position of the matrix which contains the highest fitness value.
	 * 
	 * Fitness value = objective value - penalty value
	 * 
	 * objective value = average communication energy cost + idle power * waiting time in system
	 * 
	 * penalty value = mean waiting time in system - task execution time deadline
	 *
	 * in the simple case where we only consider the offloading task execution time and task deadline. so we can 
	 * change the fitness value as mean time in system and the penalty as the same. 
	 * 
	 * to implement, we need to:
	 * 
	 * 1. initial the matrix, 
	 * 2. random generate the task set with parameters as lamda, mu, deadline.
	 * 3. implement fitness function
	 * 4. define the pso loop end status
	 * 5. begin pso loop
	 * 
	 */
	
	int n_cl = 0; // num of cl resources
	int n_task = 0; // number of task types
	int[][] position; 
	int[][] volocity;
	Random seed;
	
	public PSO(int n_cl, int n_task, int seed){
		this.n_cl = n_cl;
		this.n_task = n_task;
		position = new int[this.n_task][this.n_cl];
		volocity = new int[this.n_task][this.n_cl];
		this.seed = new Random(seed);
	}
	
	double[][] taskGen(){
		/*  
		 * this is the function to generate the task set, where the n_task is the number of tasks and 3 means the [0] l, 
 		 *	[1] m, [2] deadline respectively
		 */
		double[][] taskSet = new double[this.n_task][3];
		
		for(int i = 0; i < this.n_task; i++){
			for(int j = 0; j < 3; j++){
				taskSet[i][j] = seed.nextInt(10);
				System.out.println("taskset[i][j]: "+i+" "+j+" "+ taskSet[i][j]);
			}
		}
		
		return taskSet;
	}
	
	void brutalForceAlgo(){
		/*
		 *  this is the function to perform the brutal force searching. it will return a vector where each element represents
		 *  the number of resources scheduled to the task type. [0] to task type [0], etc.
		 */
		
		List<char[]> bf = new ArrayList<char[]>();
		bf = findBF();
		for(int i = 0; i < bf.size(); i++){
			System.out.println(bf.get(i));
		}
		int[][] result = new int[bf.size()][this.n_task]; 
		for(int i = 0; i < bf.size(); i++){
			for(int j = 0; j < this.n_task; j++){
				for(int k = 0; k < this.n_cl; k++){
					
				}
			}
		}
		
	}
	
	List<char[]> findBF(){
		/*
		 *  this is used for brutalForce to find all solutions, bits = n_cl,  for each bit, 
		 *  there are n_task numbers, here we simply use decimal system to do the encoding
		 *  for further complex system we can use hundred-based system instead
		 */
		List<char[]> result = new ArrayList<char[]>();
		
		char[] check = new char[10-this.n_task];
		check[0] = '0';
		for(int i = 1; i < check.length; i++){
			check[i] = (char)(this.n_task+i);
		}

//		for(int i = 0; i < check.length; i++){
//			System.out.println(check[i]);
//		}
		
		for(int i = (int) Math.pow(10,n_cl-1); i < (n_task+1)*Math.pow(10,n_cl-1); i++){
			boolean flag = false;
			for(int j = 0; j < check.length; j++){
				if(String.valueOf(i).indexOf(check[j]) == -1){
					flag = true;
					break;
				}
			}
			if(flag){
				continue;
			}
			result.add(String.valueOf(i).toCharArray());
		//	System.out.println(result.get((int) (i-Math.pow(10,n_cl-1))));
		}
		
		return result;
	}
	
	double fitness(){
		// this is the function to calculate the fitness value.
		
		
		return 0;
	}
	
	double objective(){
		// this is the function to calculate objective value
		
		
		return 0;
	}
	
	double penalty(){
		// this is the function to calculate the penalty value.
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PSO test = new PSO(6,4,1);
		test.taskGen();
		test.findBF();
		test.brutalForceAlgo();
	}

}
