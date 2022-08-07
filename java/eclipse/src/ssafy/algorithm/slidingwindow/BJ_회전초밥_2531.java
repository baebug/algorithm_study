package ssafy.algorithm.slidingwindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// k 개를 연속으로 먹는다.
public class BJ_회전초밥_2531 {
	
	static int N, d, k, c, result;
	static int[] cur, input;		// 현재 먹는 초밥의 종류와 수(N+1 크기의 배열)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		d = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		
		input = new int[N + k]; 
		cur = new int[d+1];
		result = 0;
		
		// 회전을 고려해서 N 을 길게 받는다. (N+k 까지 고려하면 됨)
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			input[i] = num;
			if (i < k) {
				input[N+i] = num;
			}
		}
		
		// idx 0 ~ k-1 까지 input 에 들어 있는 초밥을 확인해서 cur 에 추가한다.
		for (int i = 0; i < k; i++) {
			cur[input[i]]++;
		}
		
		// cur 에 들어있는 초밥의 종류 수를 확인하고 쿠폰초밥이 없으면 +1 해준다.
		int tmp = 0;
		for (int i : cur) {
			if (i != 0) tmp++;
		}
		if (cur[c] == 0) tmp++;
		result = Math.max(tmp, result);
		
		// 버릴 초밥 (st) --, 새로 먹을 초밥 (ed) ++
		for (int st = 0, ed = k; st < N ;st++, ed++) {
			cur[input[st]]--;
			cur[input[ed]]++;
			
			tmp = 0;
			for (int i : cur) {
				if (i != 0) tmp++;
			}
			if (cur[c] == 0) tmp++;
			result = Math.max(tmp, result);
		}
		
		System.out.println(result);
		
	}

}
