package practice;
import java.lang.reflect.*;
import java.util.regex.*;


public class ShowMethods {

	private static String usage = "usage:\n";
	
	private static Pattern p = Pattern.compile("\\w+\\.");
	
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(Class.forName("practice."+args[0]));
		if(args.length < 1){
			System.out.print(usage);
			System.exit(0);
		}
		int lines = 0;
		Class<?> c = Class.forName("practice."+args[0]);
		Method[] methods = c.getMethods();
		Constructor[] ctors = c.getConstructors();
		if(args.length == 1){
			for(Method method : methods){
				System.out.println(method.toString());
				System.out.println(p.matcher(method.toString()).replaceAll(""));
			}
			for(Constructor ctor : ctors){
				System.out.println(ctor.toString());
				System.out.println(p.matcher(ctor.toString()).replaceAll(""));
			}
			lines = methods.length + ctors.length;
		} else{
			System.out.println("more than 1");
			for(Method method : methods){
				System.out.println(method.toString().indexOf(args[1]));
				if(method.toString().indexOf(args[1]) != -1){
					System.out.println(p.matcher(method.toString()).replaceAll(""));
					lines++;
				}
			}
			for(Constructor ctor : ctors){
				if(ctor.toString().indexOf(args[1]) != -1){
					System.out.println(p.matcher(ctor.toString()).replaceAll(""));
					lines++;
				}
			}
		}
	}

}
