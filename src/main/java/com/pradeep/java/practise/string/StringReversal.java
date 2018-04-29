package com.pradeep.java.practise.string;
import java.util.Scanner;

public class StringReversal {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	String input = sc.next();
	System.out.println(getReveresdString(input));
	}
/**
 * Input: Ab,c,de!$$$

Output: ed,c,bA!$$$

Input: !!!!abcd?#

Output: !!!!dcba?#

Input: ab%%xyz

Output: zy%%xba
 * @param input
 * @return
 */
	private static String getReveresdString1(String input){
		char[] charArray = input.toCharArray();
		int size = charArray.length;
		char[] result = new char[size];
		
		for(int i = charArray.length-1; i>=0; i--){
			if((charArray[i] >= 'A' && charArray[i] <= 'Z') ||( charArray[i] >= 'a' && charArray[i] <= 'z'  ) ){
				result[size-1-i] = charArray[i];
			}else{
				result[i] = charArray[i];
				size--;
			}
		}
		return String.valueOf(result);
	}
	private static String getReveresdString(String input){
		char[] charArray = input.toCharArray();
		int size = charArray.length;
		for(int i =0, j = size-1; i < j && j > i;){
			if(isAlphabet(charArray[i]) && isAlphabet(charArray[j])){
				char tmp = charArray[i];
				charArray[i] = charArray[j];
				charArray[j] = tmp;
				i++;
				j--;
			}else{
				if(!isAlphabet(charArray[i])){
					i++;
				}
				if(!isAlphabet(charArray[j])){
					j--;
					}
			} 
					}
		return String.valueOf(charArray);
	}
	
	private static boolean isAlphabet(char input){
		if((input >= 'A' && input <= 'Z') ||( input >= 'a' && input <= 'z'  ) ){
			return true;
		}else{
			return false;
		}
	}
}
