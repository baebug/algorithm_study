package ssafy;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

// 0 <= m <= n <= 20억
public class Main {

	static String N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = stk.nextToken();
		M = stk.nextToken();
		
		BigInteger bigN = new BigInteger(N);
		BigInteger bigM = new BigInteger(M);
		
		for (int i = Integer.parseInt(N) - 1; i > Integer.parseInt(N) - Integer.parseInt(M); i--) {
			bigN = bigN.multiply(BigInteger.valueOf(i));
		}
		for (int i = Integer.parseInt(M) - 1; i > 0; i--) {
			bigM = bigM.multiply(BigInteger.valueOf(i));
		}
		
//		BigInteger mod = getGcd(bigN, bigM);
//		BigInteger result = bigN.divide(mod);
		int ans = 0;
		char[] nlist = bigN.toString().toCharArray();
		char[] mlist = bigM.toString().toCharArray();
		
		for (int i = nlist.length-1; i > 0; i--) {
			if (nlist[i] == '0') ans++;
			else break;
		}
		
		for (int i = mlist.length-1; i > 0; i--) {
			if (mlist[i] == '0') ans--;
			else break;
		}
		
		System.out.println(ans);
	}
	
	static BigInteger getGcd(BigInteger A, BigInteger B) {
		BigInteger bigM = A.compareTo(B) == 1 ? A : B;
		BigInteger bigm = A.compareTo(B) == 1 ? B : A;
		
		while (true) {
			BigInteger tmp = bigM.remainder(bigm);
			if (tmp.equals(new BigInteger("0"))) {
				return bigm;
			} else {
				bigM = bigm;
				bigm = tmp;
			}
		}
		
		
	}

}
