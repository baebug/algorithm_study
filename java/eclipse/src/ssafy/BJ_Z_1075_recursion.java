package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Z_1075_recursion {
	
	static int N, r, c, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		// N 은 2의 제곱수이므로 N을 실제 좌, 우에 해당하는 길이로 보정
		N = (int) Math.pow(2, N-1);
		
		solve(0, 0, N);
		
		System.out.print(ans);
		
	}
	
	static void solve(int sx, int sy, int n) {
		if (n == 0) {
			ans += r - sy;
			ans += c - sx;
			return;
		}
		
		if (r < sy + n && c < sx + n) solve(sy, sx, n/2);
		else if (r < sy + n && c >= sx + n) {
			ans += n*n*1;
			solve(sy, sx+n, n/2);
		} else if (r >= sy + n && c < sx + n) {
			ans += n*n*2;
			solve(sy+n, sx, n/2);
		} else if (r >= sy + n && c >= sx + n) {
			ans += n*n*3;
			solve(sy+n, sx+n, n/2);
		}
	}

}
