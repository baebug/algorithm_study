package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

// 재귀 밑바닥에서 스태틱변수로 가지고 올라온다.
// 위에서 그리면서 내려온다.
// 리스트에 담으면서 90도 회전을 반복한다. (끝점 -- 현재 점)
public class BJ_드래곤커브_15685 {

	static StringBuilder sb = new StringBuilder();
	static int K, ny, nx, result;
	static int[][] input, dt = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};	// 우 상 좌 하
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		input = new int[101][101];
		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			int g = Integer.parseInt(stk.nextToken());
			
			curve(y, x, d, g);
		}
		
		for (int i = 0; i < input.length-1; i++) {
			for (int j = 0; j < input[0].length-1; j++) {
				if (input[i][j] == 1 && input[i][j+1] == 1 && input[i+1][j] == 1 && input[i+1][j+1] == 1) result++;
			}
		}
		
		System.out.print(result);
		
	}
	
	static void curve(int y, int x, int d, int g) {
		List<int[]> list = new ArrayList<>();
		list.add(new int[] {y, x});
		list.add(new int[] {y+dt[d][0], x+dt[d][1]});
		
		while (true) {
			if (g==0) break;
			
			ny = list.get(list.size()-1)[0];
			nx = list.get(list.size()-1)[1];
			
			for (int i = list.size()-2; i >= 0; i--) {
				list.add(rotate(list.get(i)[0], list.get(i)[1]));
			}
			
			g--;
		}
		
		for(int[] p : list) {
			input[p[0]][p[1]] = 1;
		}
	}
	
	// 점 (y, x)에 대해 끝점(ny, nx)을 기준으로 돌리는(복사하는) 메소드
	// 복사된 첫점 --> 끝점이 된다.
	static int[] rotate(int y, int x) {
		int dy = Math.abs(ny - y);
		int dx = Math.abs(nx - x);
		int ry = 0, rx = 0;
				
		if (y>=ny && x>=nx) {	// 우하 --> 좌하
			ry = ny + dx;
			rx = nx - dy;
		} else if (y>=ny && x<nx) {	// 좌하 --> 좌상
			ry = ny - dx;
			rx = nx - dy;
		} else if (y<ny && x<nx) {	// 좌상 --> 우상 
			ry = ny - dx;
			rx = nx + dy;
		} else if (y<ny && x>=nx) {	// 우상 --> 우하
			ry = ny + dx;
			rx = nx + dy;
		}
		
		return new int[] {ry, rx};
	}
}
