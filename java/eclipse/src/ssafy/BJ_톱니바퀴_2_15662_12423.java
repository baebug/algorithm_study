package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_톱니바퀴_2_15662_12423 {
	
	static int T, K, ans;
	static int[][] input;
	static List<int[]> tl;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		T = Integer.parseInt(br.readLine());
		input = new int[T+1][8];
		for (int i = 1; i <= T; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				input[i][j] = tmp[j] - '0';
			}
		}
		tl = new ArrayList<>();
		
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			stk = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(stk.nextToken());
			int dr = Integer.parseInt(stk.nextToken());
			check(num, dr);
			rotate();
		}
		
		for (int i = 1; i <= T; i++) {
			if (input[i][0] == 1) ans++;
		}
		
		System.out.println(ans);
	}
	
	static void rotate() {
		for(int[] t : tl) {
			if (t[1] == 1) {
				cw(t[0]);
			} else if (t[1] == -1) {
				ccw(t[0]);
			}
		}
	}
	
	// 2 <--> 6
	static void check(int num, int dr) {
		tl.clear();
		tl.add(new int[] {num, dr});
		
		int tdr = -dr;
		for (int i = num; i > 1; i--) {
			if (input[i][6] != input[i-1][2]) {
				tl.add(new int[] {i-1, tdr});
				tdr *= -1;
			} else break;
		}
		
		tdr = -dr;
		for (int i = num; i < T; i++) {
			if (input[i][2] != input[i+1][6]) {
				tl.add(new int[] {i+1, tdr});
				tdr *= -1;
			} else break;
		}
	}
	
	// 0 --> 1 ... 7 --> 0
	static void cw(int num) {
		int[] target = input[num];
		int tmp = target[7];
		
		for (int i = 6; i >= 0; i--) {
			target[i+1] = target[i];
		}
		target[0] = tmp;
	}
	
	static void ccw(int num) {
		int[] target = input[num];
		int tmp = target[0];
		
		for (int i = 0; i < 7; i++) {
			target[i] = target[i+1];
		}
		target[7] = tmp;
	}

}
