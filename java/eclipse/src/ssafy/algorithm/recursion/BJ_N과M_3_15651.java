package ssafy.algorithm.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1부터 N까지 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다. --> 중복체크 안함 --> isSelected 버림
public class BJ_N과M_3_15651 {

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
			numbers[cnt] = i;
			
			perm(cnt + 1);
		}
	}

}
