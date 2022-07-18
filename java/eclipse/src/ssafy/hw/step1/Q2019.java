package ssafy.hw.step1;

import java.util.Scanner;

public class Q2019 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 >> ");
		int n = sc.nextInt();
		
		sc.close();
		
		int sum = 0;
		
		for(int i = 0; i <= n; i++) {
			if ((i & 1) == 0) {
				sum += i;
			}
		}
		
		System.out.println("1부터 " + n + "까지 수 중 짝수의 합 = " + sum);
		

	}

}
