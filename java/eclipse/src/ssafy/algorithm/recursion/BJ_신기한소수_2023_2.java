package ssafy.algorithm.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 7331 소수, 733 소수, 73 소수, 7 소수 --> 신기한 소수 
// 첫 자리 부터 확인하는 게 좋다.
// 첫자리를 제외한 자리에 짝수가 들어있으면 절대 신기한소수가 안되므로 계속 걸러주면 된다.
// 자리를 확인 --> % 10^n 보다는 String -> char -> int 가 낫다?
public class BJ_신기한소수_2023_2 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	static int[] numbers, first, remains;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 수열로 만들어서 소수인지 확인?
		first = new int[] {2, 3, 5, 7};
		remains = new int[] {1, 3, 7, 9};
		numbers = new int[N];
		
		makeNum(0, 0);
		
		System.out.print(sb);
		
	}
	
	static void makeNum(int idx, int num) {
		if (idx == N) {
			sb.append(num + "\n");
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			// 파라미터로 받아오더라도 따로 변수 선언해서 사용하자 --> return 과정에서의 변수 상태를 고려 안해줘도 됨.
			int tmp = num;
			if (idx == 0) {
				tmp += first[i];
//				num += first[i];
			} else {
				tmp = 10 * tmp + remains[i];
//				num = 10 * num + remains[i];
			}
			
			if(isPrime(tmp)) {
				makeNum(idx+1, tmp);
			}
//			if(!isPrime(num)) {
//				num /= 10;
//				continue;
//			}
			
//			makeNum(idx+1, num);
			
//			num /= 10;
		}
	}
	
	static boolean isPrime(int n) {
		if (n < 2) return false;
		
		for (int i = 2; i*i <= n; i++) {
			if (n % i == 0) return false;
		}
		
		return true;
	}

}
