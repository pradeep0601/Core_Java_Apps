package com.pradeep.java.practise.object;

public class WrapperTest {

	public static void main(String[] args) {
		Integer a = 150, b = 150;
		System.out.println(a == b);

		Integer c = 100, d = 100;
		System.out.println(c == d);
	}

	/*
	 * output will be : false, true
	 * explanation : https://stackoverflow.com/questions/10149959/using-operator-in-java-to-compare-wrapper-objects?noredirect=1&lq=1
	 */
}
