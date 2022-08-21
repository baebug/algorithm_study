package ssafy;

import java.io.*;
import java.util.*;

public class BJ_스도쿠_2580 {
	
	static StringBuilder sb = new StringBuilder();
	static int[] rflag, cflag;
	static int[][] input, sflag;
	static boolean end;
	static Deque<int[]> empty;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		rflag = new int[9];
		cflag = new int[9];
		sflag = new int[3][3];
		input = new int[9][9];
		empty = new ArrayDeque<>();
		for (int i = 0; i < 9; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int tmp = Integer.parseInt(stk.nextToken());
				input[i][j] = tmp;
				if (tmp != 0) {
					rflag[i] |= 1<<tmp;
					cflag[j] |= 1<<tmp;
					sflag[i/3][j/3] |= 1<<tmp;
				}
				else empty.addLast(new int[] {i, j});
			}
		}
		
		solve();
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(input[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
		
	}
	
	static void solve() {
		if (empty.isEmpty()) {
			end = true;
			return;
		}
		else {
			int[] cur = empty.peekLast();
			int y = cur[0];
			int x = cur[1];
			
			for (int k = 1; k < 10; k++) {
				if ((rflag[y]&1<<k)== 0 && (cflag[x]&1<<k)== 0 && (sflag[y/3][x/3]&1<<k)== 0) {
					rflag[y] |= 1<<k; 
					cflag[x] |= 1<<k; 
					sflag[y/3][x/3] |= 1<<k;
					empty.removeLast();
					input[y][x] = k;
					solve();
					if (end) return;
					
					rflag[y] ^= 1<<k; 
					cflag[x] ^= 1<<k; 
					sflag[y/3][x/3] ^= 1<<k;
					empty.addLast(new int[] {y, x});
					input[y][x] = 0;
				}
			}
		}
	}
}
