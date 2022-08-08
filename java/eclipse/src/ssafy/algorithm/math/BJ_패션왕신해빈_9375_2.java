package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

public class BJ_패션왕신해빈_9375_2 {

	static int T, N, result, kind;
	static Map<String, Integer> map;
	static Integer[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				stk.nextToken();
				String wear = stk.nextToken();
				int cnt = map.getOrDefault(wear, 0);
				map.put(wear, ++cnt);
			}
			
			kind = map.size();
			input = map.values().toArray(new Integer[0]);
			result = 1;
			
			// 약수 개수 구하는 개념
			// 해당 옷을 입는 경우는 각 종류 + 1(안입는경우) 가 있다.
			for (int i = 0; i < input.length; i++) {
				result *= input[i] + 1;
			}
			
			// 1의 경우 (누드) 제외
			result--;
			
			sb.append(result + "\n");
		}
		
		System.out.print(sb);
	}
	
}
