package ssafy.algorithm.slidingwindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 데이터가 엄청 크게 들어오면 어떻게 할건데?
// input 을 미리 만들어두는 게 아니라 받으면서 해결할 수 있을까?
// 뺄 애가 누군지 몰라서 힘들 것 같은데
// 1. 들어오는 애가 cur 에 없으면 max 연산해보기? --> max 연산이 아니라 크기를 그냥 계속 수동 조절해주기 (1 이면 빼면서 같이 빼고, 0이면 넣으면서 같이 올리고)
// 2. 쿠폰 초밥은 기본적으로 하나 들고 있기
public class BJ_회전초밥_15961 {
	
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
		
		// 회전을 고려해서 N 을 길게 받는다. (N+k 까지 고려하면 됨)
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			input[i] = num;
			if (i < k) {
				input[N+i] = num;
			}
		}
		
		// idx 0 ~ k-1 까지 input 에 들어 있는 초밥을 확인해서 cur 에 추가한다, 쿠폰초밥은 기본적으로 하나 깔고 간다.
		for (int i = 0; i < k; i++) {
			cur[input[i]]++;
		}
		cur[c]++;
		
		// cur 에 들어있는 초밥의 종류 수를 확인한다.
		int cnt = 0;
		for (int i : cur) {
			if (i != 0) cnt++;
		}
		result = cnt;
		
		// 버릴 초밥번호 (input[st]) --, 새로 먹을 초밥 (input[ed]) ++
		// 똑같은 게 나가고 들어왔는데, 종류는 추가되는 문제가 있다.
		for (int st = 0, ed = k; st < N ; st++, ed++) {
			int out = input[st];	// 나가는 애
			int in = input[ed];		// 들어오는 애
			
			cur[out]--;
			cur[in]++;
			
			if (cur[out] == 0) cnt--;
			if (cur[in] == 1 && in != out) cnt++;
			
			if (cnt > result) result = cnt;
		}
		
		System.out.println(result);
		
	}

}
