package ssafy.algorithm.recursion;

import java.io.*;
import java.util.*;

public class BJ_부분수열의합_14225 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] input, nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		nums = new int[2000000];
		input = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		
		solve(0, 0, 0);
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == 0) {
				System.out.println(i);
				return;
			}
			
		}
	}
	
	static void solve(int idx, int cnt, int sum) {
		if (cnt == N || idx == N) {
			nums[sum]++;
			return;
		}
		
		solve(idx+1, cnt+1, sum+input[idx]);
		solve(idx+1, cnt, sum);
	}
}
