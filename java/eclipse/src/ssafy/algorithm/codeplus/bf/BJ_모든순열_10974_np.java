package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

public class BJ_모든순열_10974_np {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		
		do {
			for (int i = 0; i < N; i++) {
				sb.append(input[i] + " ");
			}
			sb.append('\n');
		} while (np());
		
		System.out.print(sb);
	}
	
	static boolean np() {
		int i = N-1;
		while (i>0 && input[i-1] > input[i]) i--;
		if (i == 0) return false;
		
		int j = N-1;
		while (input[i-1] > input[j]) j--;
		int tmp = input[i-1];
		input[i-1] = input[j];
		input[j] = tmp;
		
		int k = N-1;
		while (i<k) {
			tmp = input[i];
			input[i] = input[k];
			input[k] = tmp;
			k--; i++;
		}
		
		return true;
	}
}
