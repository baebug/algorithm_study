package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

// 인원수가 같지 않아도 된다.
public class BJ_링크와스타트_15661 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, result = Integer.MAX_VALUE;
	static int[][] input;
	static List<Integer> teamA, teamB;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N+1][N+1];
		teamA = new ArrayList<>();
		teamB = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if (i >= j) input[j][i] += Integer.parseInt(stk.nextToken());
				else input[i][j] += Integer.parseInt(stk.nextToken());
			}
		}
		
		comb(1, 0);
		
		System.out.println(result);
	}
	
	static int getSpec(List<Integer> team) {
		int l = team.size();
		int sum = 0;
		
		for (int i = 0; i < l-1; i++) {
			for (int j = i+1; j < l; j++) {
				sum += input[team.get(i)][team.get(j)];
			}
		}
		return sum;
	}
	
	static void comb(int idx, int flag) {
		// (idx == N) 만들어진 팀으로 계산 --> 1 3 5 / 2 4 6
		if (idx == N) {
			teamA.clear(); teamB.clear();
			for (int i = 1; i <= N; i++) {
				if ((flag & 1<<i) != 0) teamA.add(i);
				else teamB.add(i);
			}
			result = Math.min(result, Math.abs(getSpec(teamA) - getSpec(teamB)));
			return;
		}

		flag |= 1<<idx;
		comb(idx+1, flag);
		flag ^= 1<<idx;
		comb(idx+1, flag);
	}
}
