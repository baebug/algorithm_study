package ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N개의 자연수 중에서 M개를 고른 수열
// 고른 수열은 오름차순이어야 한다. --> start
// 중복 비허용 --> isSelected
public class BJ_N과M_6_15655 {

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
		
		perm(0, 0);
		System.out.print(sb);
	}
	
	static void perm(int cnt, int start) {
		if (cnt == M) {
			for(int i : numbers) {
				sb.append(i + " ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (isSelected[i]) continue;
			
			numbers[cnt] = arr[i];
			isSelected[i] = true;
			
			perm(cnt+1, i+1);
			
			isSelected[i] = false;
		}
	}

}
