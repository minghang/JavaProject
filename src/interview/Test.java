package interview;

import java.util.ArrayList;
import java.util.List;

public class Test{
	static int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
	public void Test(int index, int value, String str,int sum) { 
		for (int i = index; i < array.length; i++) {
			if ((value - array[i]) == 0){
				if ((sum- array[i]) == 0) { 
					System.out.println(str + "" + array[i]); 
				} 
			} else if ((value - array[i]) > 0) {//继续找 
				str += array[i] + ","; 
				sum = sum - array[i]; 
				for (int j = i + 1; j < array.length; j++) {
					Test(j, value - array[i], str, sum); 
				} 
			} 
		} 
	} 
//	
	public static void main(String[] args) {
		Test t = new Test();
//		for (int i = 0; i < array.length; i++) {
////			t.Test(i, 20,"",20); 
//			// 记录计算过的数据
//			// 提前退出循环
//			t.method(i, 20, "");
//			
//		} 
		
//		for (int i = 0; i < array.length; i++) {
//			method(i, 20, "");
//		}
		
//		System.out.println((int)'a');
//		System.out.println((int)'z');
//		
//		
//		char[] chares = new char[]{'c', 'd', 'e', 'r', 'a', 't', 'r'};
//		System.out.println(chares);
//		new Test().quickSort(chares, 0, chares.length - 1);
//		System.out.println(chares);
//		
//		
//		new Test().display("I am a(boy*#@!!");
//		
//		String i = "1a"; 
//		String j = "2b";
//		new Test().swap(i,  j);
//		System.out.println(i);
//		System.out.println(j);
		
		String string = "abcd";
		String patthern1 = "^ab";
		String patthern2 = "^ab$";
		String patthern3 = "bc$";
		String pattern4 = "abc";
		
		System.out.println(new Test().matchWithoutStart(patthern1, string));
		System.out.println(new Test().matchWithoutStart(patthern2, string));
		System.out.println(new Test().matchWithoutStart(patthern3, string));
		System.out.println(new Test().matchWithoutStart(pattern4, string));
		
		
	}
	
	
	public void swap (String i, String j) {
		String temp = i;
		i = j;
		j = temp;
	}
	
	
	/**
	 * 	index 起始下标
	 *  sum 总和
	 *  string 输出结果的字符串
	 * */
	public void method(int index, int sum, String string) {
		for (int i = index; i < array.length; i++) {
			if (sum - array[i] == 0) {
				System.out.println(string + array[i]);
			} else if (sum - array[i] > 0) {
				sum -= array[i];
				string += array[i] + ",";
				for (int j = i + 1; j < array.length; j++) {
					method(j, sum, string);
				}
			}
		}
	}
	
	
	public void display(String str) {
		char[] chares = str.toLowerCase().toCharArray();
		quickSort(chares, 0, chares.length - 1);
		for (int i = 0; i < chares.length; i++) {
			if (chares[i] >= 97 && chares[i] <= 122) {
				System.out.print(chares[i]);
			}
		}
	}
	
	
	/**
	 * I am a boy --> aaboiy
	 * */
	
	public void quickSort(char[] chares, int left, int right) {
		
		int i = left;
		int j = right;
		if (i >= j) {
			return ;
		}
		char temp = chares[i];
		
		while (i != j) {
			while(i < j && temp < chares[j]) {
				j--;
			}
			if (i < j) {
				chares[i] = chares[j];
				i++;
			}
			while(i < j && temp > chares[i]) {
				i++;
			}
			if (i < j) {
				chares[j] = chares[i];
				j--;
			}
		}
		
		chares[i] = temp;
		quickSort(chares, left, i - 1);
		quickSort(chares, i + 1, right);
	}
	
	public final char START_CHAR = '^';
	public final char END_CHAR = '$';
//	public final char ANYCHAR = '*';
	
	public boolean matchWithoutStart(String pattern, String str) {
//		char[] patternChar = pattern.toCharArray();
//		char[] strChar = str.toCharArray();
//		
//		if (patternChar[0] == START_CHAR && patternChar[patternChar.length - 1] == END_CHAR) {
//			if (patternChar.length - strChar.length == 2) {
//				int i = 0;
//				while (i < strChar.length) {
//					
//				}
//			} 
//		} else if (patternChar[0] == START_CHAR && patternChar[patternChar.length - 1] != END_CHAR) {
//			
//		} else if (patternChar[0] != START_CHAR && patternChar[patternChar.length - 1] == END_CHAR) {
//			
//		} else if (patternChar[0] != START_CHAR && patternChar[patternChar.length - 1] != END_CHAR) {
//			
//		}
		
		if (pattern.startsWith("^") && pattern.endsWith("$"))  {
			return  str.equals(pattern.substring(1, pattern.length() - 1));
		} 
		
		if (!(pattern.startsWith("^") || pattern.endsWith("$"))) {
			return str.contains(pattern);
		}

		if (!pattern.startsWith("^") && pattern.endsWith("$")) {
			return str.endsWith(pattern.substring(0, pattern.length() - 1));
		}
		
		if (pattern.startsWith("^") && !pattern.endsWith("$")) {
			String temp = pattern.substring(1, pattern.length());
			return str.startsWith(temp);
		}
		
		
		return false;
	}
	
	/**
	 * 如果包含，返回的是第一相同字符的下标
	 * 如果不包含，返回-1
	 * subString 可能含有*号  // *不能是第一个字符
	 * */
	public void isContain(String subString, String string) {
		if (subString.startsWith("*")) {
			System.out.println("Pattern Error!");
			return;
		}
		
		
		int[] res = new int[10];
		char[] subChares = subString.toCharArray();
		char[] stringChares = string.toCharArray();
		
		for (int i = 0; i < subChares.length; i++) {
			for (int j = 0; j < string.length(); j++) {
//				if (subChares[i] == )
			}
		}
		
		return;
	}
	
	
	public int isMatch(String pattern, String string) {
		if (pattern.startsWith("*")) {
			System.out.println("Pattern Error!");
			return -2;
		}
		
		char[] patternChar = pattern.toCharArray();
		char[] stringChar = string.toCharArray();
		
		for (int i = 0; i < stringChar.length; i++) {
			
			// Find the first match char.
			while(patternChar[0] != stringChar[i]) {
				i++;
			}
			
			if (i < stringChar.length) {
//				int j = i + 1;
				int k = 1; // index of pattern
				int j = i + 1;// j is index of string
				while (isCharMatch(patternChar, k, stringChar, j) && k < patternChar.length && j < stringChar.length) {
					k++;
					j++;
				}
				
				if (j == string.length() - 1) {
					return i;
				}
			} 
		}
		
		System.out.println("Not found!");
		return -1;
		
	}
	
	
	
	
}
