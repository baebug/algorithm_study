package ssafy.live.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest1 {

	static int N, R, totalCnt;
	static int[] numbers;
	static boolean[] isSelected;
	
	// nPr
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		totalCnt = 0;
		sc.close();
		
		numbers = new int[R];			// 뽑힌 애들
		isSelected = new boolean[N+1];	// 사용 유무
		
		perm(0);
		System.out.println("총 경우의 수 : " + totalCnt);
		

	}
	
	private static void perm(int cnt) {
		if (cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			
			if (isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			perm(cnt+1);
			
			isSelected[i] = false;
		}
	}

}
