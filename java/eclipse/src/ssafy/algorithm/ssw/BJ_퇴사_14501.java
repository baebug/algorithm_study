package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

// N 일 동안 상담을 진행
// 상담을 완료하는데 걸리는 기간 T , 받을 수 있는 금액 P
public class BJ_퇴사_14501 {

	static StringBuilder sb = new StringBuilder();
	static int N, result = Integer.MIN_VALUE;
	static int[][] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			input[i] = new int[] {Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
		}
		
		solve(0, 0, 0, 0);
		
		System.out.println(result);
	}
	
	static void solve(int money, int date, int st, int ed) {
		if (ed > N) return;
		
		result = Math.max(money, result);
		
		for (int i = date; i < N; i++) {
			if (i < ed) continue;
			
			int[] task = input[i];
			solve(money+task[1], i, Math.max(i, ed), Math.max(i, ed)+task[0]);
		}
			
	}
}
