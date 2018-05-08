package practice;
import java.lang.reflect.*;

class MethodSelector implements InvocationHandler{
	private Object proxied;
	public MethodSelector(Object proxied){
		this.proxied = proxied;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		if(method.getName().equals("interesting")){
			System.out.println("proxy detected the interesting method");
		}
		
		return method.invoke(proxied, args);
	}
	
}

interface SomeMethods{
	void br1();
	void br2();
	void interesting(String arg);
	void br3();
}

class Implementation implements SomeMethods{

	@Override
	public void br1() {
		// TODO Auto-generated method stub
		System.out.println("br1");
	}

	@Override
	public void br2() {
		// TODO Auto-generated method stub
		System.out.println("br2");
	}

	@Override
	public void interesting(String arg) {
		// TODO Auto-generated method stub
		System.out.println("interesting " + arg);
	}

	@Override
	public void br3() {
		// TODO Auto-generated method stub
		System.out.println("br3");
	}
	
}

public class SelectingMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(), 
				new Class[] {SomeMethods.class}, 
				new MethodSelector(new Implementation()));
		proxy.br1();
		proxy.br2();
		proxy.br3();
		proxy.interesting("boom!");
	}
}











