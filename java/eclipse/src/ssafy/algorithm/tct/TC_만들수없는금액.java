package ssafy.algorithm.tct;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TC_만들수없는금액 {

	// 계산을 위한 money 변수 --> 동전이 사용되면 계속 빼주다가 0 이 되면 종료
	static int N, money;
	
	// 동전을 가지고 있는 배열
	static int[] coin;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		coin = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(coin);
		
		// 최소 금액을 확인하기 위한 result 변수 (1 씩 증가)
		int result = 1;
		
		// 가장 작은 동전이 1원보다 크면 종료
//		if (coin[0] > result) {
//			System.out.println(result);
//			return;
//		};
		
		// result 를 무한히 올려나가면서 계산이 안되면 break
		while (true) {
			/**
			 *  쓸 수 없다 --> 1. 이미 쓰고 있는 동전이어서, 2. 금액이 초과해서
			 *  순차적으로 보고 있으므로 이미 쓰고 있는 동전일 경우는 없다.
			 *  금액이 초과하는 경우 어차피 다음 동전도 사용할 수 없다.
			 *  마지막으로 들어간 동전을 빼고 그 다음 동전을 넣어본다.
			 *  뺄 동전이 없다면 종료
			 */
			money = result;
			use(0);
				
			if (money != 0) break;
			result++;
		}
		System.out.println(result);
	}
	
	// 특정 idx의 동전이 이번에 사용 가능한 지 확인 --> 하고 사용까지 해야 하나?
	static void use(int idx) {
		// 채워야 하는 금액보다 동전이 작거나 같다. (사용중인지는 고려 안해도 되나?)
		if (idx == N) return;
		if (money <= 0) return;
		
		for (int i = idx; i < N; i++) {
			// money = result?
			money -= coin[i];
			
			// 넣어보고 안되면 그 다음 index 에 대해서 시도 할 필요가 있음
			use(i + 1);
			
		}
		
	}
}
