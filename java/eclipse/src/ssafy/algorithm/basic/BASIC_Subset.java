package ssafy.algorithm.basic;

import java.util.Arrays;

public class BASIC_Subset {
	
	static int COUNT = 0;
	static int[] src = { 1, 2, 3, 4, 5 };
	// tgt 없다.
	
	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
		subset(0);	// src
		System.out.println(COUNT);
	}
	
	static void subset(int srcIdx) {
		// 기저조건
		if (srcIdx == src.length) {	
			// complete code : 현재 시점의 select 배열의 상태
			printSubset();
			COUNT++;
			return;
		}
		
		select[srcIdx] = true;	// 선택
		subset(srcIdx + 1);
		
		select[srcIdx] = false;	// 비선택
		subset(srcIdx + 1);
		
	}
	
	static void printSubset() {
		for (int i = 0; i < select.length; i++) {
			if (select[i]) System.out.print(src[i] + " ");
		}
		System.out.println();
	}
	
	

}
