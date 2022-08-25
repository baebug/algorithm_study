package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_암호만들기_1759 {
	
	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static char[] input, pass;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		L = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		input = new char[C];
		pass = new char[L];
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			input[i] = stk.nextToken().charAt(0);
		}
		Arrays.sort(input);
		
		solve(0, 0, 0, 0);
		
		System.out.print(sb);
	}
	
	static void solve(int st, int cnt, int jc, int mc) {
		if (cnt == L) {
			if (jc>=2 && mc>=1) {
				for(char c : pass) {
					sb.append(c);
				}
				sb.append('\n');
			}
			return;
		}
		
		for (int i = st; i < C; i++) {
			pass[cnt] = input[i];
			if (input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') {
				solve(i+1, cnt+1, jc, mc+1);
			}
			else solve(i+1, cnt+1, jc+1, mc);
		}
	}
}
