package ssafy.algorithm.recursion;

import java.io.*;
import java.util.*;

// 수 N 개(순서 바꾸면 안 됨), +-*/ 개수 (N-1보다 많을 수 있다.)
// 식의 계산은 앞에서 부터 진행
// 결과 최대, 최소 출력
// 연산자의 수 M 개 중 N-1 개를 골라서 조합돌린다. --> 시간초과
public class BJ_연산자끼워넣기_2_15658_comb_to {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, result, ansM = Integer.MIN_VALUE, ansm = Integer.MAX_VALUE;
	static int[] input, opsCnt, ops, uops;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		
		opsCnt = new int[4];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			opsCnt[i] = Integer.parseInt(stk.nextToken());
			M += opsCnt[i];
		}
		
		ops = new int[M];
		uops = new int[N];
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < opsCnt[i]; j++) {
				ops[idx] = i;
				idx++;
			}
		}
		
		solve(1, 0);
		
		System.out.println(ansM);
		System.out.println(ansm);
		
	}
	
	static void solve(int cnt, int flag) {
		if (cnt == N) {
			result = calc();
			if (result > ansM) ansM = result;
			else if (result < ansm) ansm = result;
			return;
		}
		
		for (int i = 0; i < M; i++) {
			if ((flag & 1<<i) != 0) continue;
			uops[cnt] = ops[i];
			solve(cnt+1, flag|1<<i);
		}
	}
	
	// input 과 uops 를 가지고 연산 수행
	static int calc() {
//		int[] tmp = input.clone();
		int tmp = input[0];
		for (int i = 1; i < N; i++) {
			switch (uops[i]) {
				case 0:
					tmp += input[i];
					break;
				case 1:
					tmp -= input[i];
					break;
				case 2:
					tmp *= input[i];
					break;
				case 3:
					tmp /= input[i];
					break;
			}
		}
		return tmp;
	}
	
	
}
