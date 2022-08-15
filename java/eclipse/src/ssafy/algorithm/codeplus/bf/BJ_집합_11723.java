package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

public class BJ_집합_11723 {
	
	static StringBuilder sb = new StringBuilder();
	static int M, flag, n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			String command = stk.nextToken();
			if (stk.hasMoreTokens()) {
				n = Integer.parseInt(stk.nextToken());
			}
			switch (command) {
				case "add" :
					flag |= 1<<n;
					break;
				case "remove" :
					flag &= ~(1<<n);
					break;
				case "check" :
					if ((flag & 1<<n) != 0) sb.append(1).append('\n');
					else sb.append(0).append('\n');
					break;
				case "toggle" :
					flag ^= 1<<n;
					break;
				case "all" :
					for (int j = 1; j <= 20; j++) flag |= 1<<j;
					break;
				case "empty" :
					flag = 0;
					break;
			}
		}
		
		System.out.println(sb);
		
	}
	
}
