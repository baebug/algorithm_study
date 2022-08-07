package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

public class BJ_팩토리얼0의개수_1676 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int cnt2 = 0;
		int cnt5 = 0;
		
		for (int i = N; i > 0; i--) {
			int tmp = i;
			while (true) {
				if (tmp % 5 == 0) {
					tmp /= 5;
					cnt5++;
				} else if ((tmp&1) == 0) {
					tmp /= 2;
					cnt2++;
				}
				
				if (tmp % 5 != 0 && tmp % 2 != 0) break;
			}
		}
		
		System.out.println(Math.min(cnt2, cnt5));
		
		
	}

}
