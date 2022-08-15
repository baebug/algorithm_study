package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

// 가장 적은 비용을 사용하는 여행 계획
// 갈 수 없는 경우 비용이 0이다.
public class BJ_외판원순회2_10971 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, result = Integer.MAX_VALUE;
	static int[] path;
	static int[][] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N+1][N+1];
		path = new int[N];
		path[0] = 1;
		
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		solve(1, 1, 0|1<<1);
		
		System.out.println(result);	// path [0, 1, 2, 3]
		
	}
	
	// 패스짜고 돌아올 수 있는지 확인
	static void solve(int cnt, int prev, int flag) {
		if (cnt == N) {
			if (input[prev][1] == 0) return;
			int sum = input[prev][1];
			for (int i = 0; i < N-1; i++) {
				sum += input[path[i]][path[i+1]];
			}
			result = Math.min(result, sum);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if ((flag & 1<<i) != 0) continue;
			if (input[prev][i] == 0) continue;
			
			path[cnt] = i;
			solve(cnt+1, i, flag|1<<i);
		}
	}
	
}
