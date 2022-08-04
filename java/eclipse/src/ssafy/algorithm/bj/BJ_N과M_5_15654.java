package ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N 개의 자연수와 자연수 M 이 주어진다.
// N 개의 자연수 중에서 M 개를 고른 수열
// 중복 불가
public class BJ_N과M_5_15654 {
	
	static StringBuilder sb;
	static int N, M;
	static int[] arr, numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		isSelected = new boolean[N];
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
			for (int i : numbers) {
				sb.append(i + " ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			
			numbers[cnt] = arr[i];
			isSelected[i] = true;
			
			perm(cnt + 1);
			
			isSelected[i] = false;
		}
	}

}
