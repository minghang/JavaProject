package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		RealSubject rs = new RealSubject();
		InvocationHandler ih = new DynamicSubject(rs);
		
		Class cls = rs.getClass();
		
		Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ih);
		
		subject.request("OK");
		
		
	}
}
