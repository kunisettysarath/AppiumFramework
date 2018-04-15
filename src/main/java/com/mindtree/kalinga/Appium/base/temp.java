package com.mindtree.kalinga.Appium.base;

import java.util.Arrays;
import java.util.Scanner;

public class temp {

	public void solution(int n)
	{
		
		int p;
		for(int i=2;i<=n;i++)
		{
		p=0;
		for(int j=2;j<i;j++)
		{
		if(i%j==0)
		p=1;
		}
		if(p==0){
		System.out.println(i);
		}
		}
		
		}
	
	
	
	
	public static void main(String[] args)
	{
		temp t = new temp();
		t.solution(11);
	}
}

