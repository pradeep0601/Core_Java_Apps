package com.pradeep.java.practise.collection;

import java.util.ArrayList;
import java.util.List;

public class ToArrayTest {

	private String name;
	
	public ToArrayTest(String name) {
	this.name = name;
	}
	public static void main(String[] args) {
		List<ToArrayTest> toArrayTests = new ArrayList<>();
		toArrayTests.add(new ToArrayTest("test1"));
		toArrayTests.add(new ToArrayTest("test2"));
		toArrayTests.add(new ToArrayTest("test3"));
		
		ToArrayTest[] arrayData = getArrayData(toArrayTests);
		
		for(ToArrayTest arrayTest : arrayData){
			System.out.println(arrayTest);
		}
	}
	
	private static ToArrayTest[] getArrayData(List<ToArrayTest> arrayTests){
		/*
		 * The toArray() method without passing any argument returns Object[]. So you have to pass an array as an argument, which will be filled with the data from the list, and returned. You can pass an empty array as well, but you can also pass an array with the desired size.
		 */
		return (ToArrayTest[]) arrayTests.toArray(new ToArrayTest[0]);
	}
	@Override
	public String toString() {
		return "ToArrayTest [name=" + name + "]";
	}

	
}
