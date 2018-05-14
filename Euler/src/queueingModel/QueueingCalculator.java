package queueingModel;

import java.math.BigDecimal;

public class QueueingCalculator {
	
	/*
	 * This class contains the calculation functions used in the pso.
	 */
	
	double l; // lamda
	double m; // mu
	int c; // capacity
	double deadline; // task deadline
	
	double a;
	double p;
	double l_block;
	
	public QueueingCalculator(double l, double m, int c, double deadline){
		// constructor

		this.l = l;
		this.m = m;
		this.c = c;
		this.deadline = deadline;
		this.l_block = this.l_block();
		this.a = this.l/this.m;
		this.p = this.l/(this.m*this.c);
		
	//	System.out.println(this.l);
		
		
	}
	
	int factorialLoop(int n) {
        // 阶乘对整数才有意义
        if (n < 0) {
            return -1;
        }
 
        // 0！=1，（0 的阶乘是存在的）
        if (n == 0) {
            return 1;
        }
 
        // 初始值必须为1才有意义
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
 
        return result;
    }

	
	double p0(){
		// this function is used to calculate p0, which is further used to calculate pj and others.
		double sum1 = 0;
		for(int j = 0; j <= c-1; j++){
			sum1 += (Math.pow(a, j))/(this.factorialLoop(j));
		}
		double sum2 = 0;
		sum2 = ((Math.pow(a, c))/(this.factorialLoop(c)))*(1/(1-p));
		return 1/(sum1+sum2);
	}
	
	double erlangC(){
		// this function is to calculate the erlang c formula results.
		double pC = 0;
		double result = 0;
		pC = this.p0()*((Math.pow(a, c))/(this.factorialLoop(c)));
		result = pC/(1-p);
		return result;
	}
	
	double e_Nq(){
		// this function is to calculate mean number in queue.
		double mean_in_queue = p/(1-p)*this.erlangC();
		return mean_in_queue;
	}
	
	double e_W(){
		// this function is to calculate the mean waiting time in queue.
		double mean_waiting_time = this.e_Nq()/l;
		return mean_waiting_time;
	}
	
	double e_T(){
		// this is the function to calculate the mean total time in system.
		double mean_total_time = this.e_W() + 1/m;
		return mean_total_time;
	}
	
	double e_N(){
		// this is the function to calculate the mean number in system.
		double mean_number_system = this.e_Nq() + a;
		return mean_number_system;
	}
	
	double l_block(){
		// this function is to calculate the blocking rate based on the task deadline.
		double l_block = 0;
		if(l >= c*m){
			l_block = l - (c-1)*m;
			this.l = (c-1)*m;
		}
		else{
			l_block = 0;
		}

		return l_block;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(QueueingCalculator.factorial(new BigDecimal(5)).intValue());
		QueueingCalculator test = new QueueingCalculator(11,2,5,1);
		System.out.println("p0: "+ test.p0());
		System.out.println("mean number in queue: "+ test.e_Nq());
		System.out.println("mean waiting time in queue: "+ test.e_W());
		System.out.println("mean total time in system: " + test.e_T());
		System.out.println("mean number in system: " + test.e_N());
		
	}

}
