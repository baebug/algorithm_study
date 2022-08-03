package ssafy.algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_달팽이숫자_1954_2 {
	
	static int T, n;
	static int[][] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			sb = new StringBuilder();
			
			arr = new int[n][n];
			
			// 테두리 채우기, st_num 넘겨주기, n-2 재귀
			snail(n, 0, 0, 1);

			
			System.out.println("#" + t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}

	}
	
	static void snail(int n, int y, int x, int num) {
		if (n == 0) {
			return;
		} else if (n == 1) {
			arr[y][x] = num;
			return;
		}
		
		// 양 모서리에서 시작해서 토네이도
		for (int i = 0; i < n; i++) {
			arr[y][x+i] = num + i;
			arr[y+i][x+n-1] = num + (n-1) + i;
			arr[y+n-1][x+n-1-i] = num + 2 * (n-1) + i;
			arr[y+n-1-i][x] = num + 3 * (n-1) + i;
		}
		
		arr[y][x] = num;
		
		snail(n-2, y+1, x+1, num + 4 * (n-1));
		
		
	}

}
