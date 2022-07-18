package ssafy.hw.step1;

import java.util.Scanner;

public class Q2021_1 {

	public static void main(String[] args) {
		// for 문과 if 문을 사용하여 구현
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			System.out.print("월 입력>>");
			int m = sc.nextInt();
			
			if (m == 3 || m == 4 || m == 5) {
				System.out.println(m + "월은 봄입니다.");
			} else if (m == 6 || m == 7 || m == 8) {
				System.out.println(m + "월은 여름입니다.");
			} else if (m == 9 || m == 10 || m == 11) {
				System.out.println(m + "월은 가을입니다.");
			} else if (m == 12 || m == 1 || m == 2) {
				System.out.println(m + "월은 겨울입니다.");
			}
		}
		
		sc.close();
	}

}
