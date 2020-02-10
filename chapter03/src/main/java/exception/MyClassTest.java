package exception;

public class MyClassTest {

	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		try {
			myClass.danger();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
