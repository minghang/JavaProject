package test.TestInnerClass;

import test.TestInnerClass.OuterClass.InnerClass;
import test.TestInnerClass.OuterClass.InnerClass1;
import test.TestInnerClass.OuterClass.InnerClass2;

public class InvokeOuterClass {

	public static void main(String[] args) {
//		InnerClass in = new OuterClass().getInnerClass();
//		OuterClass out = new OuterClass();
//		InnerClass in1 = out.new InnerClass();
//		
		OuterClass outerClass = new OuterClass();
		InnerClass inObject= outerClass.getInnerClass();
		System.out.println(outerClass);
		System.out.println(inObject.getOuterClass());
		System.out.println(inObject.getOuterClass() == outerClass); // true
		
		InnerClass1 in1 = outerClass.new InnerClass1();
		InnerClass2 in2 = outerClass.new InnerClass2();
		// InnerClass3 is private 
//		InnerClass3 in3 = outerClass.new InnerClass3();
		
		Interface1 if1 = outerClass.interface1();
		if1.method1();
		
	}
}
