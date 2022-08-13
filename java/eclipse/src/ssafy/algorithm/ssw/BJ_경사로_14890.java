package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

// 세로 길, 가로 길 따로 판단 (방향 다름)
// 같은 수 나오면 cnt 쌓다가 +- 1 높이가 나오면 cnt 를 L 만큼 까면서 경사로를 설치한다, cnt 가 L 보다 작으면 false
// 설치 가능한지 확인하는 메소드 (평지 L칸) visited 찍혀있으면 false
// 행 하나만 확인할 수 있으면 된다.
public class BJ_경사로_14890 {

	static StringBuilder sb = new StringBuilder();
	static int N, L, result;
	static int[][] input;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		L = Integer.parseInt(stk.nextToken());
		input = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			if (checkRow(i)) result++;
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			if (checkCol(i)) result++;
		}
		
		System.out.println(result);
		
	}
	
	// 낮아지면 1 이 들어오고, 높아지면 -1 이 들어온다.
	static boolean checkRow(int y) {
		int ny = y;
		int nx = 0;
		
		while (true) {
			int cur = input[ny][nx];
			nx += 1;
			// 끝에 도달하면 true 를 반환한다.
			if (nx>=N) break;
			int next = input[ny][nx];
			
			// 높이가 같으면 넘어간다. 2이상 차이가 나면 false를 반환한다.
			if (cur == next) continue;
			if (Math.abs(cur - next) > 1) return false;
			
			// 나보다 높아지는 경우 L칸 만큼 뒤를 확인하고, visited 이거나 cur 과 높이가 다르면 false 를 반환한다.
			else if (cur < next) {
				for (int i = 1; i <= L; i++) {
					if (nx-i<0) return false;
					int tmp = input[ny][nx-i];
					if (visited[ny][nx-i] || tmp != cur) return false;
				}
				// 통과하면 visited 를 찍어준다.
				for (int i = 1; i <= L; i++) {
					visited[ny][nx-i] = true;
				}
			}
			// 나보다 낮아지는 경우 앞을 확인한다. 범위를 넘어서면 false 를 반환한다.
			else if (cur > next) {
				for (int i = 0; i < L; i++) {
					if (nx+i>=N) return false;
					int tmp = input[ny][nx+i];
					if (visited[ny][nx+i] || tmp != next) return false;
				}
				// 통과하면 visited 를 찍어준다.
				for (int i = 0; i < L; i++) {
					visited[ny][nx+i] = true;
				}
			}
		}
		return true;
	}
	
	// 낮아지면 1 이 들어오고, 높아지면 -1 이 들어온다.
	static boolean checkCol(int x) {
		int ny = 0;
		int nx = x;
		
		while (true) {
			int cur = input[ny][nx];
			ny += 1;
			// 끝에 도달하면 true 를 반환한다.
			if (ny>=N) break;
			int next = input[ny][nx];
			
			// 높이가 같으면 넘어간다. 2이상 차이가 나면 false를 반환한다.
			if (cur == next) continue;
			if (Math.abs(cur - next) > 1) return false;
			
			// 나보다 높아지는 경우 L칸 만큼 뒤를 확인하고, visited 이거나 cur 과 높이가 다르면 false 를 반환한다.
			else if (cur < next) {
				for (int i = 1; i <= L; i++) {
					if (ny-i<0) return false;
					int tmp = input[ny-i][nx];
					if (visited[ny-i][nx] || tmp != cur) return false;
				}
				// 통과하면 visited 를 찍어준다.
				for (int i = 1; i <= L; i++) {
					visited[ny-i][nx] = true;
				}
			}
			// 나보다 낮아지는 경우 앞을 확인한다. 범위를 넘어서면 false 를 반환한다.
			else if (cur > next) {
				for (int i = 0; i < L; i++) {
					if (ny+i>=N) return false;
					int tmp = input[ny+i][nx];
					if (visited[ny+i][nx] || tmp != next) return false;
				}
				// 통과하면 visited 를 찍어준다.
				for (int i = 0; i < L; i++) {
					visited[ny+i][nx] = true;
				}
			}
		}
		return true;
	}
}
