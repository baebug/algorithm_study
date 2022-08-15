package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

// N 개의 정수로 이루어진 배열 A --> 각 자리의 수 차이가 가장 크도록 배열 만들기
public class BJ_차이를최대로_10819 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, result = Integer.MIN_VALUE;
	static int[] input, numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		numbers = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		
		solve(0, 0);
		
		System.out.print(result);
	}
	
	static void solve(int cnt, int flag) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(numbers[i] - numbers[i+1]);
			}
			result = Math.max(result, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1<<i) != 0) continue;
			numbers[cnt] = input[i];
			solve(cnt+1, flag | 1<<i);
		}
	}
	
}
