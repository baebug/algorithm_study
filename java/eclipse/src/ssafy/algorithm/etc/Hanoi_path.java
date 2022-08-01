package ssafy.algorithm.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Hanoi_path {

	static StringBuilder sb = new StringBuilder();
	
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
		
		BigInteger ans = new BigInteger("2").pow(n).subtract(new BigInteger("1"));
		sb.append(ans + "\n");
		
		if (n <= 20) {
			print_hanoi(n, 1, 3);
		}
		
		System.out.println(sb.toString());
	}

}
