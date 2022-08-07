package ssafy.algorithm.set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N
// N개의 정수
// M
// M개의 정수
public class BJ_숫자카드_10815 {

	static int N, M;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(input);
		
		M = Integer.parseInt(br.readLine());
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int tmp = 1;
			int cur = Integer.parseInt(stk.nextToken());
			if (Arrays.binarySearch(input, cur) < 0) tmp = 0;
			sb.append(tmp + " ");
		}
		
		System.out.println(sb);
		
		
	}
	
}
