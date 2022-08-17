package ssafy;

import java.io.*;
import java.util.*;

// 무조건 더하기 먼저하면 최소?
public class BJ_잃어버린괄호_1541_stk {
	
	static StringBuilder sb = new StringBuilder();
	static int sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		StringTokenizer stMinus = new StringTokenizer(br.readLine(), "-");
		
		int sizeMinus = stMinus.countTokens();	// 현재 시점에 남아 있는 토큰 수
		for (int i = 0; i < sizeMinus; i++) {
			String token = stMinus.nextToken();
			
			int num = 0;
			StringTokenizer stPlus = new StringTokenizer(token, "+");
			int sizePlus = stPlus.countTokens();
			
			for (int j = 0; j < sizePlus; j++) {
				num += Integer.parseInt(stPlus.nextToken());
			}

			if(i == 0) sum = num;
			else sum -= num;
		}
		
		System.out.println(sum);
	}				
}
