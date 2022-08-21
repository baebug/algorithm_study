package ssafy.algorithm.deque;

import java.io.*;
import java.util.*;

public class BJ_큐_10845 {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static Deque<Integer> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		dq = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			String command = stk.nextToken();
			int num = 0;
			if (stk.hasMoreTokens()) num = Integer.parseInt(stk.nextToken());
			
			switch (command) {
				case "push":
					dq.addLast(num);
					break;
				case "pop" :
					if (dq.isEmpty()) sb.append(-1).append('\n');
					else sb.append(dq.removeFirst()).append('\n');
					break;
				case "size" :
					sb.append(dq.size()).append('\n');
					break;
				case "empty" :
					if (dq.isEmpty()) sb.append(1).append('\n');
					else sb.append(0).append('\n');
					break;
				case "front" :
					if (dq.isEmpty()) sb.append(-1).append('\n');
					else sb.append(dq.peekFirst()).append('\n');
					break;
				case "back" :
					if (dq.isEmpty()) sb.append(-1).append('\n');
					else sb.append(dq.peekLast()).append('\n');
					break;
			}
		}
		System.out.print(sb);
	}

}
