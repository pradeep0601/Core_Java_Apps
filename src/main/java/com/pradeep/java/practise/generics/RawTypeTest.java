package com.pradeep.java.practise.generics;

import java.util.ArrayList;
import java.util.List;

public class RawTypeTest {

	public static void main(String[] args) {
		//type unsafe
		
		List typeUnsafeObjects = new ArrayList();
		typeUnsafeObjects.add(new Employee("employee1"));
		typeUnsafeObjects.add(new Employee("employee2"));
		typeUnsafeObjects.add(new String("test String"));
		typeUnsafeObjects.add(new Integer(123));
		System.out.println("typeUnsafeObjects = "+typeUnsafeObjects);
		
		
		//type safe
		List<Object> typeSafeObjects = new ArrayList<>();
		typeSafeObjects.add(new Employee("employee1"));
		typeSafeObjects.add(new Employee("employee2"));
		typeSafeObjects.add(new String("test String"));
		typeSafeObjects.add(new Integer(123));
		System.out.println("typeSafeObjects ="+typeSafeObjects);
		
		//test
		List<Integer> integers = typeUnsafeObjects;
		System.out.println(integers);
		//for(Integer integer : integers){
		//	System.out.println(integer);//will throw java.lang.ClassCastException
		//}
		//List<Integer> integers2 = typeSafeObjects;//Compilation Error
		
		//Unbounded wild card use
		System.out.println("===Unbounded wild card test===");
		List<Integer> integers2 = new ArrayList<>();
		integers2.add(1);
		integers2.add(2);
		integers2.add(3);
		
		//integers2 = modifyListUnsafely(integers2);
		//for(Integer integer : integers2){// will throw  java.lang.ClassCastException
		//	System.out.println(integer);
		//}
		
	}
	
	private static List modifyListUnsafely(List objects){
		objects.add("object added by modifyListUnsafely");
		return objects;
	}
	
	private static List modifyListSafely(List<?> objects){
		//objects.add("object added by modifyListUnsafely");// won't allow to add any element except null
		objects.add(null);
		return objects;
	}

	static class Employee {
		private String name;

		public Employee(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + "]";
		}
		
		
	}
}
