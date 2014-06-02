package test.TestInnerClass;

public class OuterClass {

	public InnerClass getInnerClass() {
		return new InnerClass();
	}
	
	public class InnerClass {
		public OuterClass getOuterClass() {
			return  OuterClass.this;
		}
	}
	
	public class InnerClass1 implements Interface1 {
		
		public void method1() {
			
		}
	}
	
	protected class InnerClass2 implements Interface2 {
		public void method2() {
			
		}
	}
	
	private class InnerClass3 implements Interface3 {
		public void method3() {
			
		}
	}
	
	public Interface1 interface1() {
		class PartialClass implements Interface1 {
			public void method1() {
				System.out.println("I am  from a partial class.");
				method();
			}
			
			public void method() {
				System.out.println("I am a method only in subclass from a partial class");
			}
		}
		
		return new PartialClass();
	}
	
	// 匿名内部类
	public Interface2 interface2(int i) {
		return new Interface2() {
			public void method2() {
				
			}
		};
	}
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		InnerClass inObject= outerClass.getInnerClass();
		System.out.println(outerClass);
		System.out.println(inObject.getOuterClass());
		System.out.println(inObject.getOuterClass() == outerClass); // true
		
		InnerClass1 in1 = outerClass.new InnerClass1();
		InnerClass2 in2 = outerClass.new InnerClass2();
		InnerClass3 in3 = outerClass.new InnerClass3();
		
		
	}
}
