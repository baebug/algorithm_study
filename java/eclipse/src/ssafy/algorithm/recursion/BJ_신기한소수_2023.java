package ssafy.algorithm.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 7331 소수, 733 소수, 73 소수, 7 소수 --> 신기한 소수 
// 첫 자리 부터 확인하는 게 좋다.
// 첫자리를 제외한 자리에 짝수가 들어있으면 절대 신기한소수가 안되므로 계속 걸러주면 된다.
// 자리를 확인 --> % 10^n 보다는 String -> char -> int 가 낫다?
public class BJ_신기한소수_2023 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 홀수만 확인하기
		int[] start = new int[] {2, 3, 5, 7};
		for (int k = 0; k < 4; k++) {
			int st = start[k] * (int) Math.pow(10, N-1) + 1;
			int ed = (start[k] + 1) * (int) Math.pow(10, N-1);
			for (int i = st; i < ed; i += 2) {
				// 1 ~ N 자리까지 isPrime 체크
				if (!isValid(i)) continue;
				for (int j = N-1; j >= 0; j--) {
					int mod = (int) Math.pow(10, j);
					if (!isPrime(i/mod)) break;
					if (j == 0) sb.append(i + "\n");
				}
			}
		}
		
		System.out.print(sb);
		
	}
	
	static boolean isPrime(int n) {
		if (n == 1) return false;
		if (n == 2) return true;
		if ((n&1) == 0) return false;
		int sqrt = (int) Math.sqrt(n);
		
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) return false;
		}
		
		return true;
	}
	
	static boolean isValid(int n) {
		// 홀수
		// 첫 자리 수 2 3 5 7
		// 나머지 자리에 2 4 5 6 8 0 이 들어있으면 안된다. -> 짝수거나 5
		if (n == 1) return false;
		if (n == 2) return true;
		if ((n&1) == 0) return false;
		
		char[] digit = Integer.toString(n).toCharArray();
		int tmp = digit[0]-'0';
		if (tmp == 2 || tmp == 3 || tmp == 5 || tmp == 7) {
			for (int i = 1; i < digit.length; i++) {
				tmp = digit[i] - '0';
				if ((tmp&1) == 0) return false;
				if (tmp == 5) return false;
			}
		}
		
		return true;
	}

}
