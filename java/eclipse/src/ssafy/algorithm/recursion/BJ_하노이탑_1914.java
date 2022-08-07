package ssafy.algorithm.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_하노이탑_1914 {

	static StringBuilder sb = new StringBuilder();
	
	// '출력'에 포커싱을 두고, array 가 아닌 sb 를 활용하여 출력해 줄 문자열을 작성한다.
	static void print_hanoi(int n, int st, int ed) {
		if (n == 1) {
			sb.append(st + " " + ed + "\n");
			return;
		}
		
		int tmp = 6 - st - ed;
		
		print_hanoi(n-1, st, tmp);
		sb.append(st + " " + ed + "\n");
		print_hanoi(n-1, tmp, ed);
		
	}
	
	public static void main(String[] args) throws Exception {
		// 하노이 탑 이동 경로를 출력하여라
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		// int 는 약 2^32, long 은 약 2^63 까지 담을 수 있으므로 BigInteger 클래스를 활용해야 한다.
		BigInteger ans = new BigInteger("2").pow(n).subtract(new BigInteger("1"));
		sb.append(ans + "\n");
		
		if (n <= 20) {
			print_hanoi(n, 1, 3);
		}
		
		System.out.println(sb.toString());
	}

}
