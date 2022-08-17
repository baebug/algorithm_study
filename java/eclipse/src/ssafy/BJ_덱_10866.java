package ssafy;

import java.io.*;
import java.util.*;

public class BJ_덱_10866 {

	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> dq;
	static int N, num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		dq = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			String command = stk.nextToken();
			if (stk.hasMoreTokens()) num = Integer.parseInt(stk.nextToken());
			
			switch (command) {
				case "push_front" :
					dq.addFirst(num);
					break;
				case "push_back" :
					dq.addLast(num);
					break;
				case "pop_front" :
					if (dq.isEmpty()) sb.append(-1);
					else sb.append(dq.removeFirst());
					sb.append('\n');
					break;
				case "pop_back" :
					if (dq.isEmpty()) sb.append(-1);
					else sb.append(dq.removeLast());
					sb.append('\n');
					break;
				case "size" :
					sb.append(dq.size());
					sb.append('\n');
					break;
				case "empty" :
					if (dq.isEmpty()) sb.append(1);
					else sb.append(0);
					sb.append('\n');
					break;
				case "front" :
					if (dq.isEmpty()) sb.append(-1);
					else sb.append(dq.peekFirst());
					sb.append('\n');
					break;
				case "back" :
					if (dq.isEmpty()) sb.append(-1);
					else sb.append(dq.peekLast());
					sb.append('\n');
					break;
			}
		}
		
		System.out.print(sb);
	}

}
