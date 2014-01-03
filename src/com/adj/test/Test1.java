package com.adj.test;

public class Test1 {
	public static void main(String[] args){
		String a = ",''asd123asd123',,'''";
		boolean flag1 = true ;
		boolean flag2 = true ;
		while (flag1) {
			//String s = new Character('a').toString();
			if (a.charAt(0) == new Character(',')||a.charAt(0) == new Character('\'')) {
				a = a.substring(1, a.length());
			}
			else {
				flag1 = false;
			}
		}
		while (flag2) {
			//String s = new Character('a').toString();
			if (a.charAt(a.length()-1) == new Character(',')||a.charAt(a.length()-1) == new Character('\'')) {
				a = a.substring(0, a.length() - 1);
			}
			else {
				flag2 = false;
			}
		}
		System.out.println(a);
	}
}
