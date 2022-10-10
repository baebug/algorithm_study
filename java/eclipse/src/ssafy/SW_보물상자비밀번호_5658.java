package ssafy;

import java.io.*;
import java.util.*;

public class SW_보물상자비밀번호_5658 {
	
	static StringBuilder sb = new StringBuilder();
	static int T, N, K;
//	static Set<String> set;
	static Set<Integer> set;
	static List<Integer> result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			K = Integer.parseInt(stk.nextToken());
			String input = br.readLine();
			char[] cl = input.toCharArray();
			set = new HashSet<>();
			StringBuilder tsb = new StringBuilder();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N/4; j++) {
					tsb.append(cl[(i+j)%N]);
				}
//				set.add(tsb.toString());
				set.add(Integer.parseInt(tsb.toString(), 16));
				tsb.setLength(0);
			}
			
//			result = new ArrayList<>();
//			set.forEach(e -> result.add(Integer.parseInt(e, 16)));
			result = new ArrayList<>(set);
			Collections.sort(result, Collections.reverseOrder());
			
			sb.append('#').append(t).append(' ').append(result.get(K-1)).append('\n');
			
		}
		
		System.out.println(sb);
	}
}
