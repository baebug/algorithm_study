package ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 중복 허용 X --> isSelected
// 사전순 증가 --> sort
public class BJ_N과M_9_15663_2 {

	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] arr, numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
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
	
	static void perm(int idx) {
		if (idx == M) {
			for(int i : numbers) {
				sb.append(i + " ");
			}
			sb.append('\n');
			return;
		}
		
		int prev = -1;
		for (int i = 0; i < N; i++) {
			// 이미 사용중인 idx 거나 이전에 나온 수일 경우 넘긴다. (대신 이전에 나온 수 조건은 같은 자리(idx)에서만 유효함)**
			if (isSelected[i] || arr[i] == prev) continue;
			
			numbers[idx] = arr[i];
			isSelected[i] = true;
			prev = arr[i];
			
			perm(idx+1);
			
			isSelected[i] = false;
			
		}
	}

}
