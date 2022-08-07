package ssafy.algorithm.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1부터 N까지 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다.	--> isSelected 없어도 됨
// 고른 수열은 비내림차순이어야 한다. (모든 원소가 이전 원소 이상)
public class BJ_N과M_4_15652 {

	static StringBuilder sb;
	static int N, M;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		
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
			numbers[cnt] = i;
			
			perm(cnt+1, i);
		}
	}

}
