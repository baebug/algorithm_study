package ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 중복 허용 --> isSelected X
// 비내림차순 --> start 사용
public class BJ_N과M_12_15666 {

	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] input, numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		input = new int[N];
		numbers = new int[M];
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(input);
		
		perm(0, 0);
		
		System.out.print(sb);

	}
	
	static void perm(int idx, int start) {
		if (idx == M) {
			for(int i : numbers) {
				sb.append(i + " ");
			}
			sb.append('\n');
			return;
		}
		
		int prev = -1;
		for (int i = start; i < N; i++) {
			if (input[i] == prev) continue;
			
			prev = numbers[idx] = input[i];
			
			perm(idx+1, i);
		}
	}

}
