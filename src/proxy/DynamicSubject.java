package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler{

	private Object sub;
	
	public DynamicSubject() {
		
	}
	
	public DynamicSubject(Object sub) {
		this.sub = sub;
	}
	
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		System.out.println(proxy);
		System.out.println("Before calling");
		method.invoke(sub, args);
		System.out.println("After calling");
		return null;
	}
}
