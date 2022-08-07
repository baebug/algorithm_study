package ssafy.algorithm.set;

import java.io.*;
import java.util.*;

// N, M은 50만 이하의 자연수
public class BJ_듣보잡_1764 {

	static int N, M, cnt;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		cnt = 0;
		
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 1);
		}
		
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			if (map.getOrDefault(tmp, -1) == 1) {
				list.add(tmp);
				cnt++;
			}
		}
		
		Collections.sort(list);
		sb.append(cnt + "\n");
		for (String s : list) {
			sb.append(s + '\n');
		}
		
		System.out.println(sb);
	}
	
}
