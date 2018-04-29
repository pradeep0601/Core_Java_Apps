package com.pradeep.java.practise.object;

class A{
	private String name;
	public A() {
		System.out.println("===A()===");
	}
	public A(String name){
		System.out.println("===A(-)===");
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "A [name=" + name + "]";
	}
	
}

class B extends A  implements Cloneable{
	private String name;
	public B() {
		System.out.println("===B()===");
	}
	public B(String name){
		System.out.println("===B(-)===");
		this.name = name;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	@Override
	public String toString() {
		return "B [name=" + name + "]";
	}
}
public class SubclassCloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		B b = new B("sub class");
		B clonedB = (B) b.clone();
		System.out.println("original B = "+b);
		System.out.println("cloned B = "+clonedB);
		
	}

}
