package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Z_1074 {
	
	static int N, r, c, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		// N 은 2의 제곱수이므로 N을 실제 좌, 우에 해당하는 길이로 보정
		N = (int) Math.pow(2, N);
		
		int y = 0;
		int x = 0;
		
		// 분할정복
		while (N > 1) {
			N /= 2;
			
			if (r < y + N && c < x + N) ;
			else if (r < y + N && c >= x + N) {
				ans += N*N*1;
				x += N;
			} else if (r >= y + N && c < x + N) {
				ans += N*N*2;
				y += N;
			} else if (r >= y + N && c >= x + N) {
				ans += N*N*3;
				y += N;
				x += N;
			}
			
		}
		
		System.out.print(ans);
		
	}

}
