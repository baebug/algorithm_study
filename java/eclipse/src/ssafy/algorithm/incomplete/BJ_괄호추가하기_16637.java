package ssafy.algorithm.incomplete;

import java.io.*;
import java.util.*;

import ssafy.Test;

//값이 최대가 되려면 + 는 괄호 안에 있어야 하고 - 는 괄호 밖에 있어야 한다. --> + 를 우선적으로 수행해야 한다.
// 중첩 괄호는 사용이 안되기 때문에 가장 큰 수를 + 해야한다.
// N 개 --> 숫자 M+1 개 / 연산자 M 개
// 리스트에 따로 넣고
public class BJ_괄호추가하기_16637 {

	static StringBuilder sb = new StringBuilder();
	static int N, M, result = Integer.MIN_VALUE;
	static int[] nums;
	static char[] ops;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		M = N/2;
		nums = new int[M+1];
		ops = new char[M];
		visited = new boolean[M];
		
		int nc = 0;
		int oc = 0;
		
		char[] input = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) {
			char tmp = input[i];
			if (tmp >= '0' && tmp <= '9') nums[nc++] = tmp - '0';
			else ops[oc++] = tmp;
		}

		solve(0, 0);
		
		System.out.println(result);
	}
	
	static void solve(int cnt, int prev) {
		if (cnt == M) {
			result = Math.max(result, prev);
			return;
		}
		
		for (int i = 0; i < M; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			if (cnt == 0) solve(1, calc(i, nums[i+1]));
			else solve(cnt+1, calc(i, prev));
			visited[i] = false;
		}
	}
	
	static int calc(int idx, int prev) {
		char op = ops[idx];
		int n = nums[idx];
		int tmp = 0;
		
		switch (op) {
			case '+':
				tmp = n + prev;
				break;
			case '-':
				tmp = n - prev;
				break;
			case '*':
				tmp = n * prev;
				break;
		}
		
		return tmp;
	}
	
}
