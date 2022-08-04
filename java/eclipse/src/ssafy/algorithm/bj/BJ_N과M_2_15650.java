package ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1 부터 N 까지의 자연수 중에서 중복 없이 M 개를 고른 수열
// 단, 고른 수열은 오름차순이어야 한다.
public class BJ_N과M_2_15650 {

	static StringBuilder sb;
	static int N, M, cnt, start;
	static boolean[] isSelected;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[N+1];
		numbers = new int[M];
		cnt = 0;
		start = 0;
		
		perm(0, 1);
		System.out.print(sb);

	}
	
	static void perm(int cnt, int start) {
		if (cnt == M) {
			for(int i : numbers) {
				sb.append(i + " ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = start; i <= N; i++) {
			if (isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			perm(cnt+1, i+1);
			
			isSelected[i] = false;
			
		}
	}

}
