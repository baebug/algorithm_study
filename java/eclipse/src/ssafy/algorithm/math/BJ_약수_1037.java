package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

// A가 N의 약수 --> N이 A의 배수 && A != 1, N
// 진짜 약수가 모두 주어지면 N 을 구하여라.
public class BJ_약수_1037 {

	static int N;
	static int input[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(input);
		
		if ((N&1) == 1) {
			System.out.println(input[N/2] * input[N/2]);
		} else {
			System.out.println(input[0] * input[N-1]);
		}
	}
}
