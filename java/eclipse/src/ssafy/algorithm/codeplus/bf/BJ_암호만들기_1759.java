package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

// 서로 다른 L 개의 알파벳 소문자들로 구성, 최소 한개의 모음 + 최소 두개의 자음
// 가능성 있는 암호들을 모두 구하는 프로그램을 작성하라.
public class BJ_암호만들기_1759 {
	
	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static char[] input, result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		L = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		result = new char[L];
		input = new char[C];
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			input[i] = stk.nextToken().charAt(0);
		}
		Arrays.sort(input);
		
		solve(0, 0);
		
		System.out.print(sb);
		
	}
	
	static void solve(int idx, int cnt) {
		if (cnt == L) {
			int m = 0, j = 0;
			for(char c : result) {
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') m++;
				else j++;
			}
			if (m >= 1 && j >= 2) {
				for (int i = 0; i < L; i++) {
					sb.append(result[i]);
				}
				sb.append('\n');
			}
			return;
		}
		
		for (int i = idx; i < C; i++) {
			result[cnt] = input[i];
			solve(i+1, cnt+1);
		}
	}
	
}
