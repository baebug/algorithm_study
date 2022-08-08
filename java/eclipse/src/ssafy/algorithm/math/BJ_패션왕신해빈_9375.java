package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

public class BJ_패션왕신해빈_9375 {

	static int T, N, result, kind;
	static Map<String, Integer> map;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				stk.nextToken();
				String wear = stk.nextToken();
				int cnt = map.getOrDefault(wear, 0);
				map.put(wear, ++cnt);
			}
			
			kind = map.size();
			input = map.values().stream().mapToInt(i -> i).toArray();
			result = N;
			
			for (int i = 2; i <= kind; i++) {
				solve(0, 0, i, 1);
			}
			
			sb.append(result + "\n");
		}
		
		System.out.print(sb);
	}
	
	static void solve(int cnt, int start, int max, int sum) {
		if (cnt == max) {
			result += sum;
			return;
		}
		
		for (int i = start; i < kind; i++) {
			int tmp = sum;
			tmp *= input[i];
			solve(cnt+1, i+1, max, tmp);
		}
	}
	
	
}
