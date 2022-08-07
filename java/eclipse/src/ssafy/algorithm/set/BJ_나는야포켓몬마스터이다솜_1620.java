package ssafy.algorithm.set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_나는야포켓몬마스터이다솜_1620 {

	static int N, M;
	static String[] input;
	static HashMap<String, Integer> map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new String[N+1];
		map = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String pkm = br.readLine();
			map.put(pkm, i);
			input[i] = pkm;
		}
		
		for (int i = 0; i < M; i++) {
			String target = br.readLine();
			int ans = map.getOrDefault(target, -1);
			if (ans == -1) {
				sb.append(input[Integer.parseInt(target)] + "\n");
			}
			else sb.append(ans + "\n");
		}
		
		System.out.println(sb);
		
	}
	
}
