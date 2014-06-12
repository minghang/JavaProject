package verify;

public class TestAssert {

	public static void main(String[] args) {
		int a = 1;
		
		try {
//			assert a == 2;
			assert a == 2 : a = 2;
		} catch (AssertionError ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("123");
			System.out.println(a);
		}
		
		System.out.println(1);

		
	}
}
