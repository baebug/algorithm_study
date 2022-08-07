package ssafy.algorithm.set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 정수가 적혀있는 카드 N개
// 정수 M개에 대해 각 카드를 몇장 가지고 있는지
// 크기가 정해져있으면 배열이 좋지만, 이런 상황에서는 Map 을 사용
public class BJ_숫자카드2_10816 {

	static int N, M;
	static Map<Integer, Integer> map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(stk.nextToken());
			int cnt = map.getOrDefault(num, 0);
			map.put(num, ++cnt);
		}
		
		M = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sb.append(map.getOrDefault(Integer.parseInt(stk.nextToken()), 0) + " ");
		}
		
		System.out.println(sb);
		
	}
	
}
