package ssafy.algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 좌 <--> 우 반복
// 좌 <--> 우 반복되는 중간에 상하가 반복된다.
// 좌 <--> 우 한 번 실행되면 그 다음 실행되는 숫자의 수가 하나 줄어든다.
public class SW_달팽이숫자_1954_3 {
	
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
			
			// 시작좌표, 방향
			int y = 0;
			int x = -1; // 더해질 1 보정
			int d = 1; // 1: 증가, -1: 감소

			int num = 1; // 시작 숫자
			
			int cnt = n; // 숫자를 기록할 칸 수, 점점 줄어든다.
			int total = n*n;
			
			while (num <= total) {
				// 우 -> 좌 -> 우 -> 좌 반복
				for (int i = 0; i < cnt; i++) {
					x += d;
					arr[y][x] = num++;
				}
				
				cnt--; // 우 또는 좌를 전부 기록하면 줄어든다.
				
				// 하 -> 상 -> 하 -> 상
				for (int i = 0; i < cnt; i++) {
					y += d;
					arr[y][x] = num++;
				}
				
				// 방향 전환
				d *= -1;
			}
			
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

}
