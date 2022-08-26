package ssafy;

import java.io.*;
import java.util.*;

public class SW_특이한자석_4013 {
	
	static StringBuilder sb = new StringBuilder();
	static int T, K, ans;
	static int[][] input;
	static List<int[]> rl = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			
			input = new int[6][8];
			for (int i = 1; i <= 4; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					input[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			for (int i = 0; i < K; i++) {
				stk = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(stk.nextToken());
				int d = Integer.parseInt(stk.nextToken());
				find(n, d);
				rotate();
			}
			
			ans = 0;
			for (int i = 1; i <= 4; i++) {
				if (input[i][0] == 1) ans += Math.pow(2, i-1);
			}
			
			sb.append('#').append(t).append(' ').append(ans).append('\n');
			
		}
		
		System.out.print(sb);
	}
	
	static void rotate() {
		for(int[] r : rl) {
			if(r[1] == 1) {
				cw(input[r[0]]);
			} else if (r[1] == -1) {
				ccw(input[r[0]]);
			}
		}
	}
	
	static void find(int n, int d) {
		rl.clear();
		rl.add(new int[] {n, d});
		
		int td = -d;
		for (int tn = n-1; tn >= 0; tn--) {
			if (input[tn][2] != input[tn+1][6]) {
				rl.add(new int[] {tn, td});
				td *= -1;
			} else break;
		}
		
		td = -d;
		for (int tn = n+1; tn < 5; tn++) {
			if (input[tn-1][2] != input[tn][6]) {
				rl.add(new int[] {tn, td});
				td *= -1;
			} else break;
		}
	}
	
	static void cw(int[] arr) {
		int tmp = arr[7];
		
		// 6 -> 7 , 5 -> 6 , ... 0 -> 1
		for (int i = 0; 7 - i > 0; i++) {
			arr[7-i] = arr[6-i];
		}
		
		arr[0] = tmp;
	}
	
	static void ccw(int[] arr) {
		int tmp = arr[0];
		
		// 1 -> 0 , 2 -> 1 , ... , 7 -> 6
		for (int i = 0; i < 7; i++) {
			arr[i] = arr[i+1];
		}
		
		arr[7] = tmp;
	}
}
