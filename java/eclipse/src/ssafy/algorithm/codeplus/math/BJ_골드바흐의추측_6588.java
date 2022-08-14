package ssafy.algorithm.codeplus.math;

import java.io.*;
import java.util.*;

public class BJ_골드바흐의추측_6588 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, T;
	static boolean[] primes;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		primes = new boolean[1000001];
		Arrays.fill(primes, 2, primes.length, true);
		primes[0] = primes[1] = false;
		
		for (int i = 2; i*i <= primes.length; i++) {
			if (!primes[i]) continue;
			int tmp = i * 2;
			while (tmp < primes.length) {
				primes[tmp] = false;
				tmp += i;
			}
		}
		
		int n = -1;
		
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			boolean flag = false;
			for (int i = 3; i <= n/2; i+=2) {
				if (primes[i] && primes[n-i]) {
					System.out.printf("%d = %d + %d%n", n, i, n-i);
					flag = true;
					break;
				}
			}
			if (!flag) System.out.println("Goldbach's conjecture is wrong.");
		}
	}
	
}
