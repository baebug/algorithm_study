package ssafy;

import java.io.*;
import java.util.*;

/*
 1
 5
 1 3 2 5 4 
 */
public class SW_최장증가부분수열_3307_bs {
	
	static StringBuilder sb = new StringBuilder();
	static int T, N, len;
	static int[] input, memoi;	// 부분수열의 길이별 가장 작은 값 저장
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			memoi = new int[N];
			
			stk = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				input[i] = Integer.parseInt(stk.nextToken());
			}
			
			// LIS 의 len 을 구한다.
			len = 0;
			for(int i=0; i<N; i++) {
				
				int pos = Arrays.binarySearch(memoi, 0, len, input[i]);
				if (pos < 0) pos = Math.abs(pos) - 1;
				memoi[pos] = input[i];
				if (len == pos) len++;
			}
			
			sb.append('#').append(t).append(' ').append(len).append('\n');
		}
		
		System.out.print(sb);
		
	}
}
