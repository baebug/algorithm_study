package hwalgo18_부울경_3반_배충현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Algorithm_18_10026 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, ans;
	static int[][] dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static char[][] input;
	static boolean[][] visited;
	static Deque<int[]> dq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dq = new ArrayDeque<>();
		
		N = Integer.parseInt(br.readLine());
		
		input = new char[N][N];
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		ans = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (!visited[i][j]) bfsNorm(i, j);
		sb.append(ans).append(' ');
		
		ans = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (!visited[i][j]) bfsRG(i, j);
		sb.append(ans).append(' ');
		
		System.out.print(sb);
		
	}
	
	static void bfsNorm(int y, int x) {
		dq.clear();
		visited[y][x] = true;
		dq.addLast(new int[] {y, x});
		
		while(!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			int cy = cur[0];
			int cx = cur[1];
			char cc = input[cy][cx];
			
			for (int d = 0; d < 4; d++) {
				int ny = cy + dt[d][0];
				int nx = cx + dt[d][1];
				
				if (ny<0 || nx<0 || ny>=N || nx>=N) continue;
				if (visited[ny][nx] || cc != input[ny][nx]) continue;
				
				visited[ny][nx] = true;
				dq.addLast(new int[] {ny, nx});
			}
		}
		ans++;
	}
	
	static void bfsRG(int y, int x) {
		dq.clear();
		visited[y][x] = true;
		dq.addLast(new int[] {y, x});
		
		while(!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			int cy = cur[0];
			int cx = cur[1];
			char cc = input[cy][cx];
			
			for (int d = 0; d < 4; d++) {
				int ny = cy + dt[d][0];
				int nx = cx + dt[d][1];
				
				if (ny<0 || nx<0 || ny>=N || nx>=N) continue;
				if (visited[ny][nx]) continue;
				if (cc == 'B' && cc != input[ny][nx]) continue;
				else if (cc != 'B' && input[ny][nx] == 'B') continue;
				
				visited[ny][nx] = true;
				dq.addLast(new int[] {ny, nx});
			}
		}
		ans++;
	}

}
