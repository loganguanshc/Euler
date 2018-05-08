package practice;

public class BoundedClassReferences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<? extends Number> bounded = int.class;
		bounded = float.class;
		bounded = double.class;
	}

}
