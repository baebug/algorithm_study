package ssafy.algorithm.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 중복되는 수열 출력 X --> 중복되는 숫자는 들어옴 --> 들어갈 자리에 같은 수가 있으면 ㄴㄴ?
// 중복허용 X --> isSelected 필요
public class BJ_N과M_9_15663 {
	
	static StringBuilder sb;
	static int N, M;
	static int[] arr, numbers;
	static Set<String> set;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		set = new LinkedHashSet<>();
		arr = new int[N];
		isSelected = new boolean[N];
		numbers = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		perm(0);
		
		sb = new StringBuilder();
		for (String s : set) {
			for (int i = 0; i < s.length(); i++) {
				sb.append(s.charAt(i));
			}
			sb.append('\n');
		}
		System.out.print(sb);

	}
	
	static void perm(int cnt) {
		if (cnt == M) {
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			set.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			numbers[cnt] = arr[i];
			isSelected[i] = true;
			
			perm(cnt+1);
			
			isSelected[i] = false;
		}
	}

}
