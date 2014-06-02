package test;

/**
 * @author lmh
 *
 */
public class TestClone {

	public static void main(String[] args) {
		int a = 1; 
		int b = a;
		b = 2;
		System.out.println(a);
		System.out.println(b);
		
		String s1 = "abc";
		String s2 = s1;
		s2 = "asdf";
		System.out.println(s1);
		System.out.println(s2);
		
		
		TestCloneClass t1 = new TestCloneClass(1);
		TestCloneClass t2 = t1;
		t2.setValue(2);
		System.out.println(t1);
		System.out.println(t2);
		
	}
}


class TestCloneClass{
	private int value;
	
	public TestCloneClass(int value) {
		this.value = value;
	}
	
	public String toString() {
		return String.valueOf(this.value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}