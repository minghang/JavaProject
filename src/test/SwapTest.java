package test;

public class SwapTest {

	
	public static void main(String[] args) {
		int i = 1;
		int j = 2;
		System.out.println(i);
		System.out.println(j);
		swap(i, j);
		System.out.println(i);
		System.out.println(j);
		
		
		String s1 = "i am a";
		String s2 = "i am b";
		System.out.println(s1);
		System.out.println(s2);
		swap(s1, s2);
		System.out.println(s1);
		System.out.println(s2);
		
		
		ForSwapTest f1 = new ForSwapTest("f1");
		ForSwapTest f2 = new ForSwapTest("f2");
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		swap(f1, f2);
		System.out.println(f1.toString());
		System.out.println(f2.toString());
	}
	
	
	public static void swap(int i, int j) {
		int temp = i; 
		i = j;
		j = temp;
		System.out.println(i);
		System.out.println(j);
//		i = 9;
//		j = 8;
	}
	
	public static void swap(String i, String j) {
		String temp = i;
		i = j;
		j = temp;
		System.out.println(i);
		System.out.println(j);
		
//		i = "i am c";
//		j = "i am d";
	}
	
	
	public static void swap(ForSwapTest f1, ForSwapTest f2) {
		ForSwapTest temp = f1;
		f1 = f2;
		f2 = temp;
		System.out.println(f1.toString());
		System.out.println(f2.toString());
	}
	
	
	
}

class ForSwapTest {
	
	private String att;
	
	public ForSwapTest(String att) {
		this.att = att;
	}
	
	public String toString() {
		return  att;
	}

	public String getAtt() {
		return att;
	}

	public void setAtt(String att) {
		this.att = att;
	}
	
}

