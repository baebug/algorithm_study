package ssafy.algorithm.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 난쟁이 키의 합이 100
// 오름차순으로 출력한다.
public class BJ_일곱난쟁이_2309 {

	static int[] key, list;
	static StringBuilder sb;
	static int totalCnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		key = new int[9];
		list = new int[7];
		
		for (int i = 0; i < 9; i++) {
			key[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(key);
		
		find(0, 0, 0);
		
	}
	
	static void find(int cnt, int start, int sum) {
		if (cnt == 7) {
			if (sum == 100 && totalCnt == 0) {
				sb = new StringBuilder();
				for (int i = 0; i < 7; i++) {
					sb.append(list[i] + "\n");
				}
				System.out.print(sb);
				totalCnt++;
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			int tmp = sum;
			tmp += key[i];
			
			if (tmp > 100) {
				return;
			}
			
			list[cnt] = key[i];
			find(cnt+1, i+1, tmp);
		}
	}

}
