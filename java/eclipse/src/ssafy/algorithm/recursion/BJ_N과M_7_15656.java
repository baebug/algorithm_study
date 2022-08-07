package ssafy.algorithm.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N개의 자연수중 M개를 고른 수열
// 중복 허용 --> isSelected 불필요
public class BJ_N과M_7_15656 {
	
	static StringBuilder sb;
	static int N, M;
	static int[] arr, numbers;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		numbers = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
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
		
		for (int i = 0; i < N; i++) {
			numbers[cnt] = arr[i];
			
			perm(cnt+1);
		}
	}

}
