package com.automationcalling.seleniumcore;

public class Sum {
	static int total;
	
	public  static int sum(int a, int b){
		return total=a+b;
		
	}
	
	public static void main(String args[]){
		Sum sum= new Sum();
		total=sum.sum(5, 3);
		System.out.println(total);
	}

}
