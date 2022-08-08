package ssafy.algorithm.deque;

import java.io.*;
import java.util.*;

public class BJ_요세푸스문제_1158 {

	static int N, K;
	static Deque<Integer> dq = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		sb.append('<');
		
		for (int i = 1; i <= N; i++) {
			dq.addLast(i);
		}
		
		while (!dq.isEmpty()) {
			for (int i = 1; i < K; i++) {
				dq.addLast(dq.removeFirst());
			}
			
			sb.append(dq.removeFirst()).append(", ");
		}
		
		sb.setLength(sb.length()-2);
		sb.append('>');
		System.out.println(sb);
		
	}
	
}
