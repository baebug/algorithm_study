package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

public class BJ_이전순열_10973 {
	
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
		
		if (pp()) for (int i = 0; i < input.length; i++) sb.append(input[i] + " ");
		else sb.append(-1);
		
		System.out.print(sb);
			
	}
	
	static boolean pp() {
		int i = N-1;
		
		while (i>0 && input[i-1] < input[i]) i--;
		if (i == 0) return false;
		
		int j = N-1;
		while(input[i-1] < input[j]) j--;
		int tmp = input[j];
		input[j] = input[i-1];
		input[i-1] = tmp;
		
		int k = N-1;
		while(i<k) {
			tmp = input[i];
			input[i] = input[k];
			input[k] = tmp;
			i++; k--;
		}
		
		return true;
	}
}
