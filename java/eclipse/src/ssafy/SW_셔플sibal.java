package ssafy;

import java.io.*;
import java.util.*;

public class SW_셔플sibal {
	
	static StringBuilder sb = new StringBuilder();
	static int T, N, M, ans;
	static boolean flag;
	static int[] perm, input, left, right, demo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			flag = false;
			N = Integer.parseInt(br.readLine());
			M = N/2;
			input = new int[N];
			left = new int[M];
			right = new int[M];
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(stk.nextToken());
			}
			
			ans = 111;
			System.out.println(Arrays.toString(shuffle(input, 3)));
//			solve(input, 0);
			
			sb.append('#').append(t).append(' ').append(ans).append('\n');
		}
		
		System.out.print(sb);
		
	}
	
	static void solve(int[] input, int cnt) {
		System.out.println(Arrays.toString(input));
		if (cnt >= ans) return;
		if (isUp(input) || isDown(input)) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (cnt == 6) {
			return;
		}
		
		for (int i = 1; i < N; i++) {
			solve(shuffle(input, i), cnt+1);
		}
	}
	
	static void rev(int[] arr) {
		for (int i = 0; i < M; i++) {
			left[i] = arr[i];
		}
		for (int i = 0; i < M; i++) {
			arr[i] = arr[M+i];
		}
		for (int i = M; i < N; i++) {
			arr[i] = left[i-M];
		}
	}
	
	static int[] shuffle(int[] arr, int c) {
		if (c < M) {
			return shuffle0(arr, c);
		} else {
			return shuffle5(arr, N-1-c);
		}
	}
	
	static int[] shuffle0(int[] arr, int c) {
		int[] tmp = arr.clone();
		
		for (int i = 1; i <= c; i++) {
			swap(tmp, M-i, M+1-i);
		}
		for (int i = 2; i <= c; i++) {
			swap(tmp, M-2+i, M-1+i);
		}
		
		return tmp;
	}
	
	static int[] shuffle5(int[] arr, int c) {
		int[] tmp = arr.clone();
		rev(tmp);
		
		for (int i = 1; i <= c; i++) {
			swap(tmp, M-i, M+1-i);
		}
		for (int i = 2; i <= c; i++) {
			swap(tmp, M-2+i, M-1+i);
		}
		
		return tmp;
	}
	
	static boolean isUp(int[] arr) {
		for (int i = 0; i < N; i++) {
			if (arr[i] != i+1) return false;
		}
		return true;
	}
	
	static boolean isDown(int[] arr) {
		for (int i = 0; i < N; i++) {
			if (arr[i] != N-i) return false;
		}
		return true;
	}
	
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
