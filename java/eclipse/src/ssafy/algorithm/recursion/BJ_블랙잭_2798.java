package ssafy.algorithm.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_블랙잭_2798 {

	static int N, M, max;
	static int[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new int[N];
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(input);
		
		max = Integer.MIN_VALUE;
		
		bj(0, 0, 0);
		
		System.out.println(max);
		
	}
	
	static void bj(int cnt, int st, int sum) {
		if (max >= M) return;
		if (cnt == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = st; i < N; i++) {
			int tmp = sum + input[i];
			
			if (tmp <= M) {
				bj(cnt+1, i+1, tmp);
			}
		}
		
	}
	
}
