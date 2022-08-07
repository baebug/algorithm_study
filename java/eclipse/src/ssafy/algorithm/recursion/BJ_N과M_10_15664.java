package ssafy.algorithm.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 중복을 허용하지 않는다 --> isSelected
// 비내림차순 --> start
// 중복된 수가 들어온다 --> 같은 자리에서 확인 필요
public class BJ_N과M_10_15664 {

	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] input, numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		input = new int[N];
		isSelected = new boolean[N];
		numbers = new int[M];
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(input);
		
		perm(0, 0);
		
		System.out.print(sb);
		
		
	}
	
	static void perm(int idx, int start) {
		if (idx == M) {
			for(int i : numbers) {
				sb.append(i + " ");
			}
			sb.append('\n');
			return;
		}
		
		int prev = -1;
		for (int i = start; i < N; i++) {
			if (isSelected[i] || input[i] == prev) continue;
			
			numbers[idx] = input[i];
			isSelected[i] = true;
			prev = input[i];
			
			// 비내림차순이라 같은 위치에서 시작하면 된다. start 는 for 문에서 한 번만 쓰이고 나머지는 다 i 를 사용한다.
			perm(idx+1, i);
			
			isSelected[i] = false;
		}
	}

}
