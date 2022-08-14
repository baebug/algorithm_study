package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[][] input, demo;
	static boolean[][] visited;
	static int[] paper = {0, 5, 5, 5, 5, 5};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		input = new int[10][10];
		
		for (int i = 0; i < 10; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++)
				input[i][j] = Integer.parseInt(stk.nextToken());
		}
		
		solve();
		
	}
	static void solve() {
		demo = copy();
		
		for (int i = 1; i <= 5; i++) {
			
		}
	}
	
	static boolean p(int y, int x, int l) {
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				int ny = y+i; int nx = x+j;
				if (ny<0 || nx<0 || ny>=10 || nx>=10) return false;
				if (demo[ny][nx] == 0 || visited[ny][nx]) return false;
				else visited[ny][nx] = true;
			}
		}
		return true;
	}
	
	static int[][] copy() {
		int[][] tmp = new int[10][];
		
		for (int i = 0; i < 10; i++) {
			tmp[i] = input[i].clone();
		}
		
		return tmp;
	}
}
