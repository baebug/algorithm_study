package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

public class BJ_리모컨_1107 {
	
	static StringBuilder sb = new StringBuilder();
	static String s;
	static int N, M, l, result;
	static int[] input;
	static List<Integer> numbers;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		s = br.readLine();
		l = s.length();
		N = Integer.parseInt(s);					// 5457
		input = new int[l];
		numbers = new ArrayList<>();
		
		M = Integer.parseInt(br.readLine());
		visited = new boolean[10];
		
		if (M != 0) {
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int tmp = Integer.parseInt(stk.nextToken());
				visited[tmp] = true;
			}
		}
		
		result = Math.abs(N - 100);
		// 목표채널과 가장 가까운 채널로 이동한 뒤 +/- 로 가야한다.
		solve(0, l-1);
		solve(0, l);
		solve(0, l+1);
		
		System.out.println(result);
		
	}
	
	static void solve(int cnt, int ed) {
		if (ed == 0) return;
		if (cnt == ed) {
			int sum = 0;
			for (int i = 0; i < ed; i++) {
				sum = sum * 10 + numbers.get(i);
			}
			result = Math.min(result, Math.abs(sum-N)+ed);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if (visited[i]) continue;
			numbers.add(cnt, i);
			solve(cnt+1, ed);
			numbers.remove(cnt);
		}
	}
	
}
