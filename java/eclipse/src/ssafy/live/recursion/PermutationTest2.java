package ssafy.live.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest2 {

	static int N, R, totalCnt;
	static int[] numbers, input;
	static boolean[] isSelected;
	
	// n개의 입력받은 수 중에 뽑기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		totalCnt = 0;
		
		input = new int[N];
		isSelected = new boolean[N];
		numbers = new int[R];			// 뽑힌 애들
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		sc.close();
		
		perm(0);
		System.out.println("총 경우의 수 : " + totalCnt);

	}
	
	private static void perm(int cnt) {
		if (cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 가능한 모든 수에 대해 시도 --> input 배열의 모든 수
		for (int i = 0; i < N; i++) {
			
			if (isSelected[i]) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			
			// 다음 수 뽑으러 가기
			perm(cnt+1);
			
			// 사용했던 수에 대한 선택 되돌리기
			isSelected[i] = false;
		}
	}

}
