package queueingModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
	
	double[][] taskSet;
	double[] deviceSet;
	double[][] allTaskSet;
	Random seed;
	
	public PSO(int n_cl, int n_task, int seed){
		this.n_cl = n_cl;
		this.n_task = n_task;
		position = new int[this.n_task][this.n_cl];
		volocity = new int[this.n_task][this.n_cl];
		this.seed = new Random(seed);
		this.taskSet = this.taskGen(100); // 100 is the value for nextInt
		this.deviceSet = this.deviceGen(10); // 100 is the value for nextInt
		this.allTaskSet = this.groupingTask();
	}
	
	double[][] groupingTask(){
		/*
		 * this function is to grouping the taskset and deviceset together.
		 */
		double[][] result = new double[this.taskSet.length+1][this.taskSet[0].length];
		for(int i = 0; i < result.length-1; i++){
			for(int j = 0; j < result[0].length; j++){
				result[i][j] = this.taskSet[i][j];
				System.out.println("taskset[i][j]: "+i+" "+j+" "+ taskSet[i][j]);
			}
		}
		for(int j = 0; j < result[0].length; j++){
			result[result.length-1][j] = deviceSet[j];
			System.out.println("taskset[result.length-1][j]: "+j+" "+ result[result.length-1][j]);
		}
		return result;
	}
	
	double[][] taskGen(int n){
		/*   n is the value for nextInt
		 * this is the function to generate the task set, where the n_task is the number of tasks and 3 means the [0] l, 
 		 *	[1] m, [2] deadline respectively
		 */
		double[][] taskSet = new double[this.n_task][3];
		
		for(int i = 0; i < this.n_task; i++){
			for(int j = 0; j < 3; j++){
				if(j == 0){
				taskSet[i][j] = seed.nextInt(n);
				}else{
					taskSet[i][j] = seed.nextInt(n) + taskSet[i][0];
				}
			}
		}
		
		return taskSet;
	}
	
	double[] deviceGen(int n){
		/* n is for the nextInt
		 * this is the method to generate device-based taskset and cloud.  
		 * noting that the l is not the final value, the final value still needs to add the blocking l from each computing task. 
		 * the cloud l is the blocking l of the device-based queue.
		 */
		
		double[] deviceSet = new double[3];
		for(int i = 0; i < deviceSet.length; i++){
			deviceSet[i] = seed.nextInt(n);
			if(i == 0){
			deviceSet[i] = seed.nextInt(n);
			}else{
				deviceSet[i] = seed.nextInt(n) + deviceSet[0];
			}
		}
		
		return deviceSet;
	}
	
	int[] brutalForceAlgo(){
		/*
		 *  this is the function to perform the brutal force searching. it will return a vector where each element represents
		 *  the number of resources scheduled to the task type. 
		 */
		
		List<char[]> bf = new ArrayList<char[]>();
		bf = charBF();
		System.out.println("passed the creat char[] function");
//		for(int i = 0; i < bf.size(); i++){
//			System.out.println(bf.get(i));
//		}
		
		Map<Double, int[]> findRes = new HashMap<Double, int[]>();
		int count = 0;
		for(char[] b : bf){
			int[] temp = this.intTask(b);
			double[][] tempAllTaskSet = this.autoFitTaskDeadline(temp);
			double tempDouble = this.fitness(temp, tempAllTaskSet);

			if(!findRes.containsKey(tempDouble)){
				findRes.put(tempDouble, temp);
				count++;
				System.out.println(count +" "+ tempDouble);
			}
		}
		
		//System.out.println(findRes.size());
		double tempMinD = 400; // a very high value
		int[] tempMinInt = null;
		for(Map.Entry<Double, int[]> entry: findRes.entrySet()){
			if(entry.getKey() < tempMinD){
				tempMinD = entry.getKey();
				tempMinInt = entry.getValue();
			}
		}
		System.out.println("the int[] is: "+ tempMinInt+" value: "+ tempMinD);
		
		return tempMinInt;
	}
	
	double[][] autoFitTaskDeadline(int[] cl){
		/*  cl: the number of resources array 
		 *  result: result[0]--the number of task for device; result[1]--the number of task for cloud
		 *  this is the auto fit function, in which the tasks will adapt to the task deadline. the steps are as follows:
		 *  1. calculate the average time in system 
		 *  2. compare the average time to the task deadline
		 *  3. if the average time is larger, then send the extra task to the device-based solutions -- reduce the l for that task and
		 *  add the l in the device queue.
		 *  4. if the average time in device-based queue is also larger than task deadline -- reduce the l for the device queue and 
		 *  add the l in the cloud queue 
		 *  this.taskSet[][]
		 */
		double randomFactor = this.seed.nextDouble()*0.1;
		
		double[][] tempTaskSet = new double[allTaskSet.length][allTaskSet[0].length];
		for(int i = 0; i < tempTaskSet.length; i++){
			for(int j = 0; j < tempTaskSet[0].length; j++){
				tempTaskSet[i][j] = allTaskSet[i][j];
		//		System.out.println(tempTaskSet[i][j]);
			}
		}
		
		
		for(int i = 0; i < this.taskSet.length; i++){
			if(cl[i] == 0){
				continue;
			}
			QueueingCalculator qc = new QueueingCalculator(taskSet[i][0], taskSet[i][1], cl[i], taskSet[i][2]);
			double temp = qc.e_T();


		}
		
		double[][] result;
		
		
		return tempTaskSet;
	}
	
	int[] intTask(char[] task){
		/*
		 * this is the function to translate char[] to int[] which indicates the number of each type
		 * of tasks.
		 */
		Map<Character, Integer> tempMap = new HashMap<Character, Integer>();
		for(int i = 1; i <= this.n_task+1; i++){
			tempMap.put((char) (i+'0'), 0);
		}
		
		for(int i = 0; i < task.length; i++){
		//	System.out.println("task_i is: "+task[i]);
			if(tempMap.containsKey(task[i])){
				tempMap.put(task[i], tempMap.get(task[i])+1);
			}
		}
		
		int[] result = new int[this.n_task+1];
		for(int i = 0; i < result.length; i++){
			result[i] = tempMap.get((char)(i+1+'0'));
		//	System.out.println("result_i is: "+result[i]);
		}
		
		return result;
	}
	
	List<char[]> charBF(){
		/*
		 *  this is used for brutalForce to find all solutions, bits = n_cl,  for each bit, 
		 *  there are n_task numbers, here we simply use decimal system to do the encoding
		 *  for further complex system we can use hundred-based system instead
		 *  
		 *  i.e. given 5 cloudlet res and 4 task types then we can use 11111 to 44444 for representation
		 *  
		 *  
		 */
		
		int bit = this.n_cl;
		int num = this.n_task+1; // 1 is for the device-based
		List<char[]> result = new LinkedList<char[]>();
		for(long i = (long)Math.pow(10, bit-1); i <=(long)((num+1)*Math.pow(10, bit-1)); i++){
			char[] temp = String.valueOf(i).toCharArray();
			result.add(temp);
		}
		return result;
	}
	
	
	double fitness(int[] cl, double[][] allTaskSet){
		/*
		 *  this is the function to calculate the fitness value. Based on the functions in the calculator class
		 *  cl is the number of resources for each task type. 
		 *  this.taskSet is the tasks generated by the taskGen() function where [0] l, [1] m, [2] deadline respectively. 
		 *  the steps are as follows:
		 *  1. calculate all avg time in task-based queues
		 *  2. calculate avg time in device queue
		 *  3. calculate the transmission time for each
		 *  4. calculate the energy cost function
		 */
		
		double result = 0;
		for(int i = 0; i < allTaskSet.length; i++){
			if(cl[i] == 0){
				result+=100;
				continue;
			}
			QueueingCalculator qc = new QueueingCalculator(allTaskSet[i][0], allTaskSet[i][1], cl[i], allTaskSet[i][2]);
			double temp = qc.e_T();
		//	System.out.println(temp);
			result+=temp;
		}
//		if(result < 5){
//			System.out.println("total time in system: "+result);
//			for(int i = 0; i < cl.length; i++){
//				System.out.println("i is: "+i+" m is: "+cl[i]);
//			}
//		}

		return result;
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
		
		PSO test = new PSO(7,4,1);
		int[] result = test.brutalForceAlgo();
		for(int i = 0; i < result.length; i++){
			System.out.println("i is: "+i + " result is: "+result[i]);
		}
//		test.taskSet = test.taskGen();
//		List<char[]> results = test.findBF();
//		for(char[] result : results){
//			System.out.println(result);
//		}
		
//		char[] testChar = new char[4];
//		testChar[0] = '1';
//		testChar[1] = '3';
//		testChar[2] = '9';
//		testChar[3] = '2';
//		test.numOfT(testChar);
//		for(int i =0; i < testInt.length; i++){
//			System.out.println(testInt[i]);
//		}
	}

}
