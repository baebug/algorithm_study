package ssafy.algorithm.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_N과M_1_15649 {

	static boolean[] isSelected;
	static int[] numbers;
	static int N, M, cnt;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[N+1];
		
		numbers = new int[M];
		cnt = 0;
		
		// 1 부터 N 까지 자연수 중에서 중복 없이 M 개를 고른 수열
		perm(0);
		
		System.out.print(sb);
	}
	
	static void perm(int cnt) {
		if (cnt == M) {
			for(int i : numbers) {
				sb.append(i + " ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			perm(cnt + 1);
			
			isSelected[i] = false;
		}
	}

}
