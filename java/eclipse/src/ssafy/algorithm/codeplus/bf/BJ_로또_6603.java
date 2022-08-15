package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

public class BJ_로또_6603 {
	
	static StringBuilder sb = new StringBuilder();
	static int k;
	static int[] input, numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		
		while (true) {
			stk = new StringTokenizer(br.readLine());
			k = Integer.parseInt(stk.nextToken());
			if (k == 0) break;
			
			input = new int[k];
			numbers = new int[6];
			for (int i = 0; i < k; i++) {
				input[i] = Integer.parseInt(stk.nextToken());
			}
			
			solve(0, 0);
			sb.append('\n');
		}
		
		System.out.print(sb);
		
	}
	
	static void solve(int st, int cnt) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(numbers[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = st; i < k; i++) {
			numbers[cnt] = input[i];
			solve(i+1, cnt+1);
		}
	}
	
}
