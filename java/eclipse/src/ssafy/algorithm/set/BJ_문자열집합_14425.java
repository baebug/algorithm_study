package ssafy.algorithm.set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_문자열집합_14425 {

	static int N, M;
	static String[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new String[N];
		
		
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();
		}
		Arrays.sort(input);
		
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String cur = br.readLine();
			if (Arrays.binarySearch(input, cur) >= 0) cnt++;
		}
		
		System.out.println(cnt);
		
		
	}
	
}
