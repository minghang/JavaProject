package array.memory.demo;

import java.util.ArrayList;
import java.util.List;

public class ArrayMemDemo {
	 public static void main(String args[]) {
	        List<String> lst = new ArrayList<String>();
	        while (true) {
	            lst.add(Long.toString(System.currentTimeMillis()).substring(3));
	            System.out.println("List size:" + lst.size());
	            System.out.println("free memory:"
	                    + Runtime.getRuntime().freeMemory() / 1024 + "K");
	            
	        }
	    }
}
