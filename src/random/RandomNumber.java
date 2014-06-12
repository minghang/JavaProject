package random;

import java.util.Random;

public class RandomNumber {

	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			System.out.println(Math.random());
		}
		
		
		Random r = new Random(10);
		
		for (int i = 0; i < 3; i++) {
			System.out.println(r.nextInt());
		}
		
	}
}
