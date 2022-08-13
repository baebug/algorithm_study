package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

public class BJ_백설공주와일곱난쟁이_3040 {

	static StringBuilder sb = new StringBuilder();
	static int[] input, result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		input = new int[9];
		result = new int[7];
		
		for (int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(input);
		
		solve(0, 0, 0);
		
		System.out.print(sb);
	}
	
	static void solve(int st, int cnt, int sum) {
		if (sum > 100) return;
		if (cnt == 7) {
			if (sum == 100) {
				for(int i : result) {
					sb.append(i).append('\n');
				}
			}
			return;
		}
		
		for (int i = st; i < 9; i++) {
			result[cnt] = input[i];
			solve(i+1, cnt+1, sum+input[i]);
		}
		
		
	}
}
