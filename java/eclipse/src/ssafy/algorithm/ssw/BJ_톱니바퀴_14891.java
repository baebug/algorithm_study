package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

// 맞닿은 극이 다를 때만 회전한다.
// 12시 방향부터 시계 방향으로 주어진다. idx: 6 <--> 2
// 1 : cw ,  -1 : ccw
public class BJ_톱니바퀴_14891 {

	static StringBuilder sb = new StringBuilder();
	static int K;
	static int[][] gears;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		gears = new int[5][8];
		
		for (int i = 1; i < 5; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				gears[i][j] = tmp[j] - '0';
			}
		}
		
		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			solve(n, c);
		}
		
		System.out.println(calc());
		
	}
	
	static void solve(int num, int c) {
		// 영향 받을 애들 찾아놓고 작동
		int cl = gears[num][6];
		int cr = gears[num][2];
		
		// 왼쪽으로 확인
		if (num-1 > 0 && cl != gears[num-1][2]) {	// 내 왼쪽극 이랑 왼쪽기어의 오른쪽 극이 다른가?
			if (num-2 > 0 && gears[num-1][6] != gears[num-2][2]) {// 왼쪽 기어의 왼쪽 극과 왼왼쪽 기어의 오른쪽 극이 다른가?
				if (num-3 > 0 && gears[num-2][6] != gears[num-3][2]) go(gears[num-3], -c);
				go(gears[num-2], c);
			}
			go(gears[num-1], -c);
		}
		
		if (num+1 < 5 && cr != gears[num+1][6]) {	// 내 오극 이랑 오른쪽기어의 왼극이 다른가?
			if (num+2 < 5 && gears[num+1][2] != gears[num+2][6]) {// 오른쪽 기어의 오극과 오오른쪽 기어의 왼극이 다른가?
				if (num+3 < 5 && gears[num+2][2] != gears[num+3][6]) go(gears[num+3], -c);
				go(gears[num+2], c);
			}
			go(gears[num+1], -c);
		}
		
		go(gears[num], c);
	}
	
	static int calc() {
		int result = 0;
		for (int i = 1; i < 5; i++) {
			if (gears[i][0] == 1) result += (int) Math.pow(2, (i-1));
		}
		
		return result;
	}
	
	static void go(int[] arr, int dr) {
		if (dr == 1) cw(arr);
		else if (dr == -1) ccw(arr);
	}
	
	static void cw(int[] arr) {
		int tmp = arr[arr.length-1];
		for (int i = arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = tmp;
	}
	
	static void ccw(int[] arr) {
		int tmp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i-1] = arr[i];
		}
		arr[arr.length-1] = tmp;
	}
}
