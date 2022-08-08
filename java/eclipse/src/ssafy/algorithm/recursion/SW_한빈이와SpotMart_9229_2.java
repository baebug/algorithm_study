package ssafy.algorithm.recursion;

import java.io.*;
import java.util.*;

// 정렬해서 넣기 때문에 이전 과자는 고려할 필요가 없다.
public class SW_한빈이와SpotMart_9229_2 {

	static int T, N, M, result;
	static int[] input;
	static boolean[] isSelected;
	static Deque<Integer> dq = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			result = -1;
			
			input = new int[N];
			isSelected = new boolean[N];
			
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(stk.nextToken());
			}
			Arrays.sort(input);
			
			solve(0, 0, 0);
			
			sb.append('#').append(t).append(" ").append(result).append('\n');
			
		}
		
		System.out.println(sb);
	}
	
	static void solve(int cnt, int start, int sum) {
		if (result == M) return;
		if (cnt == 2) {
			result = Math.max(result, sum);
			return;
		}
		
		for (int i = start; i < N; i++) {
			int tmp = sum;
			if (isSelected[i]) continue;
			
			tmp += input[i];
			
			if (tmp <= M) {
				isSelected[i] = true;
				solve(cnt+1, i+1, tmp);
				isSelected[i] = false;
			}
			
		}
	}
	
}
