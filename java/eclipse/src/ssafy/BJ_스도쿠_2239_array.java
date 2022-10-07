package ssafy;

import java.util.*;
import java.io.*;

public class BJ_스도쿠_2239_array {
	
	static StringBuilder sb = new StringBuilder();
	static int[][] input;
	static List<Node> zero = new ArrayList<>();
	static boolean isComplete = false;
	static int size;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		input = new int[9][9];
		for(int i=0; i<9; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<9; j++) {
				input[i][j] = line[j] - '0';
				if (input[i][j] == 0) zero.add(new Node(i, j));
			}
		}
		
		size = zero.size();
		
		solve(0);
		
		System.out.println(sb);
	}
	
	static void solve(int idx) {
		if (isComplete) return;
		if (idx == size) {
			isComplete = true;
			
			// 출력
			for(int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					sb.append(input[i][j]);
				}
				sb.append('\n');
			}
			return;
		}
		
		int y = zero.get(idx).y;
		int x = zero.get(idx).x;
		
		// valid 체크
		boolean[] visited = new boolean[10];
		for(int i=0; i<9; i++) {
			visited[input[y][i]] = true;
		}
		for(int i=0; i<9; i++) {
			visited[input[i][x]] = true;
		}
		
		int ny = (y/3)*3;
		int nx = (x/3)*3;
		for(int i=ny; i<ny+3; i++) {
			for(int j=nx; j<nx+3; j++) {
				visited[input[i][j]] = true;
			}
		}
		
		for(int i=1; i<=9; i++) {
			if (visited[i]) continue;
			input[y][x] = i;
			solve(idx+1);
			input[y][x] = 0;
		}
		
	}
	
	static class Node {
		int y, x;
		
		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
}