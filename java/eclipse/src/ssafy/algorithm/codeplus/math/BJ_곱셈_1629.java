package ssafy.algorithm.codeplus.math;

import java.io.*;
import java.util.*;

public class BJ_곱셈_1629 {
	
	static StringBuilder sb = new StringBuilder();
	static int A, B, C, p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		A = Integer.parseInt(stk.nextToken());
		B = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		
		p = A % C;
		
		System.out.println(solve(B));
		
	}
	
	static long solve(int n) {
		if (n == 0) return 1;
		long tmp = solve(n/2);
		tmp = (tmp * tmp) % C;
		if ((n&1)==1) {
			return (tmp * p) % C;
		} else {
			return (tmp) % C;
		}
	}
}
