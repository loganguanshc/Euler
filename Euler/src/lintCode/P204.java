package lintCode;

public class P204 {
    /**
     * @return: The same instance of this class every time
     */
     private static P204 a = new P204(); 
     
     private P204(){
         
     }
     
     
    public static P204 getInstance() {
        // write your code here
        return a;
    }
}


