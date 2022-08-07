package ssafy.algorithm.twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


// N, M은 50만 이하의 자연수
public class BJ_소수의연속합_1644 {

	static int N, ans;
	static boolean[] primes;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		primes = new boolean[N+1];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		
		int i = 2;
		while (i * i <= N) {
			if (primes[i]) {
				int tmp = 2 * i;
				while (tmp <= N) {
					primes[tmp] = false;
					tmp += i;
				}
			}
			i++;
		}
		
		int[] tmp = new int[N+1];
		int idx = 0;
		for (int j = 0; j <= N; j++) {
			if(primes[j]) tmp[idx++] = j;
		}
		
		ans = 0;
		int st = 0;
		int ed = 0;
		int sum = 0;
		
		while(st<=ed && ed <= N) {
			if (sum < N) {
				sum += tmp[ed++];
			} else {
				if (sum == N) {
					ans++;
				}
				sum -= tmp[st++];
			}
		}
		
		System.out.println(ans);
		
	}
	
}
