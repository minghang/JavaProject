package proxy;

public class RealSubject implements Subject{

	public void request(String str) {
		System.out.println("Real subject and str is " + str);
	}
}
