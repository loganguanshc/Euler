package practice;
import java.lang.reflect.*;

class DynamicProxyHandler implements InvocationHandler{
	
	private Object proxied;
	
	public DynamicProxyHandler(Object proxied){
		this.proxied = proxied;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("**proxy: " + proxy.getClass() +", method: " + method + ", args: "+ args);
		if(args != null){
			for(Object arg : args){
				System.out.println(" " + arg);
			}
		}
		
		return method.invoke(proxied, args);
	}
	
}

public class SimpleDynamicProxy {

	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("boom!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RealObject real = new RealObject();
		consumer(real);
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), 
				new Class[] {Interface.class}, 
				new DynamicProxyHandler(real));
		consumer(proxy);
		
	}

}


























