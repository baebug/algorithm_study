package ssafy.algorithm.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 일직선 도로 위 N개의 도시
// 도시의 수 10만		거리, 가격 10억 이하의 정수
// 거리, 가격, 비용 이 주어진다.
public class BJ_주유소_13305 {

	static int N;
	static long result;
	static int[] d, p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		d = new int[N];
		p = new int[N];
		d[0] = 0;
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 1; i < N; i++) {
			d[i] = Integer.parseInt(stk.nextToken());
		}
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(stk.nextToken());
		}
		
		int idx = 1;
		int tmpPrice = p[0];		// 현재 도시의 가격
		long tmpDist = 0;			// 누적 거리
		
		result = 0;
		
		while(true) {
			// 나보다 가격이 싼 도시가 나올 때 까지 거리를 쌓는다.
			// result += 내 가격 * 누적거리, 누적거리 = 0, 현재가격 = p[i]
			tmpDist += d[idx];
			
			if (tmpPrice > p[idx]) {
				result += tmpDist * tmpPrice;
				tmpDist = 0;
				tmpPrice = p[idx];
			}
			
			idx++;
			
			if (idx == N) {
				result += tmpDist * tmpPrice;
				break;
			}
		}
		
		System.out.print(result);
		
	}

}
