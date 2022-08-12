package ssafy;

import java.io.*;
import java.util.*;

// 평일 오후 축구, 의무X
// N(짝수)명이 모여서 팀을 나눈다. (4~20명)
// i 와 j 가 같은 팀이 되면 팀 능력치가  +Sij, +Sji 된다. 둘은 다를 수 있다.
// 두 팀의 능력치 차이를 최소로 하려고 한다.
// 가운데 줄을 기준으로 접어버리면 두명 씩 뽑았을 때 증가하는 능력치 --> 애초에 N*N 으로 받을 필요가 없다? --> 조합
// 팀 --> 멤버번호로 만들 수 있는 원소가 두개인 부분집합(오름차순) 의 총 합
public class BJ_스타트와링크_14889 {
	
	static int N, M, result = Integer.MAX_VALUE;
	static int[][] input;
	static int[] stMem, linkMem;
	static boolean[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		M = N/2;
		input = new int[N+1][N+1];
		selected = new boolean[N+1];
		stMem = new int[M];
		linkMem = new int[M];
		
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if (i >= j) input[j][i] += Integer.parseInt(stk.nextToken());
				else input[i][j] += Integer.parseInt(stk.nextToken());
			}
		}
		
		getTeam(1, 0);
		
		System.out.print(result);
	}
	
	// 전체 멤버 조합하고 결과가 나오면 계산 메서드를 호출한다.
	static void getTeam(int start, int cnt) {
		if (cnt == M) {
			for (int idx=0, i=1; i<=N; i++) {
				if (!selected[i]) linkMem[idx++] = i;
			}
			result = Math.min(result, Math.abs(getSpec(stMem) - getSpec(linkMem)));
			return;
		}
		
		for (int i = start; i <= N; i++) {
			stMem[cnt] = i;	// 1 ~ 20
			selected[i] = true;
			getTeam(i+1, cnt+1);
			selected[i] = false;
		}
	}
	
	// stMem 과 linkMem 을 가지고 스펙 차이를 계산한다.
	static int getSpec(int[] mem) {
		int sum = 0;
		
		for (int i = 0; i < M-1; i++) {
			for (int j = i+1; j < M; j++) {
				sum += input[mem[i]][mem[j]];
			}
		}
		return sum;
	}
}
