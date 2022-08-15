package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

public class BJ_다음순열_10972 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		
		if (np()) for (int i = 0; i < N; i++) sb.append(input[i] + " "); 
		else sb.append(-1);
		
		System.out.println(sb);
		
	}
	
	static boolean np() {
		// 나보다 작은 게 나오면 멈춘다.
		int i = N-1;
		while (i>0 && input[i-1] > input[i]) i--;
		if (i == 0) return false;

		// 작은 애보다 큰 게 나오면 멈춘다.
		int j = N-1;
		while (input[i-1] > input[j]) j--;
		
		swap(i-1, j);

		// 이후 값 다 뒤집는다.
		int k = N-1;
		while (i < k) {
			swap(i++, k--);
		}
		
		return true;
	}
	
	static void swap(int i, int j) {
		int tmp = input[j];
		input[j] = input[i];
		input[i] = tmp;
	}
}
