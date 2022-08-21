package ssafy.algorithm.dp;

import java.io.*;
import java.util.*;

public class BJ_알고리즘수업피보나치수1_24416 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, code1, code2;
	static int[] f;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		f = new int[41];
		
		N = Integer.parseInt(br.readLine());
		fib(N);
		fibonacci(N);
		
		sb.append(code1).append(' ').append(code2);
		System.out.print(sb);
	}
	
	static int fib(int n) {
		if (n == 1 || n == 2) {
			code1++;
			return 1;
		}
		return (fib(n-1) + fib(n-2)); 
	}
	
	static int fibonacci(int n) {
		f[1] = f[2] = 1;
		for (int i = 3; i <= N; i++) {
			f[i] = f[i-1] + f[i-2];
			code2++;
		}
		return f[n];
	}
}
