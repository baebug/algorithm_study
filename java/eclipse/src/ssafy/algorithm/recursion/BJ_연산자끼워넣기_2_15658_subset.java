package ssafy.algorithm.recursion;

import java.io.*;
import java.util.*;

// 수 N 개(순서 바꾸면 안 됨), +-*/ 개수 (N-1보다 많을 수 있다.)
// 식의 계산은 앞에서 부터 진행
// 결과 최대, 최소 출력
// 연산자의 수 M 개 중 N-1 개를 골라서 조합돌린다. --> 시간초과
public class BJ_연산자끼워넣기_2_15658_subset {
	
	static StringBuilder sb = new StringBuilder();
	static int N, ansM = Integer.MIN_VALUE, ansm = Integer.MAX_VALUE;
	static int[] input, opsCnt;
	
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
		}
		
		solve(1, 0, 0, 0, 0, input[0]);
		
		System.out.println(ansM);
		System.out.println(ansm);
		
	}
	
	static void solve(int cnt, int plus, int minus, int mul, int div, int sum) {
		if (cnt == N) {
			if (sum > ansM) ansM = sum;
			if (sum < ansm) ansm = sum;
			return;
		}
		
		if(plus < opsCnt[0]) solve(cnt+1, plus+1, minus, mul, div, sum+input[cnt]);
		if(minus < opsCnt[1]) solve(cnt+1, plus, minus+1, mul, div, sum-input[cnt]);
		if(mul < opsCnt[2]) solve(cnt+1, plus, minus, mul+1, div, sum*input[cnt]);
		if(div < opsCnt[3]) solve(cnt+1, plus, minus, mul, div+1, sum/input[cnt]);
	}
	
}
