package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

public class BJ_부등호_2529 {
	
	static StringBuilder sb = new StringBuilder();
	static int k;
	static long M = Long.MIN_VALUE, m = Long.MAX_VALUE;
	static char[] input;
	static boolean[] visited;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
	
		k = Integer.parseInt(br.readLine());
		input = new char[k];
		numbers = new int[k+1];
		visited = new boolean[10];
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			input[i] = stk.nextToken().charAt(0);
		}
		
		solve(0);
		
		String format = "%0"+(k+1)+"d%n";
		System.out.printf(format, M);
		System.out.printf(format, m);
	}
	
	static void solve(int cnt) {
		if (cnt == k+1) {
			if (isValid()) {
				long num = 0;
				for (int i = 0; i < k+1; i++) {
					num = num * 10 + numbers[i];
				}
				calc(num);
			}
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = i;
			solve(cnt+1);
			visited[i] = false;
			
		}
	}

	static boolean isValid() {
		for (int i = 0; i < k; i++) {
			if (input[i] == '<' && numbers[i] < numbers[i+1]) continue;
			else if (input[i] == '>' && numbers[i] > numbers[i+1]) continue;
			else return false;
		}
		
		return true;
	}
	
	static void calc(long n) {
		M = Math.max(M, n);
		m = Math.min(m, n);
	}
	
	
}
