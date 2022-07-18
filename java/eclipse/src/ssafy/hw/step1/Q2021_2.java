package ssafy.hw.step1;

import java.util.Scanner;

public class Q2021_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		
		while (cnt < 3) {
			System.out.print("월 입력>>");
			int m = sc.nextInt();
			
			switch (m) {
				case 1:
					System.out.println(m + "월은 겨울입니다.");
					break;
				case 2:
					System.out.println(m + "월은 겨울입니다.");
					break;
				case 3:
					System.out.println(m + "월은 봄입니다.");
					break;
				case 4:
					System.out.println(m + "월은 봄입니다.");
					break;
				case 5:
					System.out.println(m + "월은 봄입니다.");
					break;
				case 6:
					System.out.println(m + "월은 여름입니다.");
					break;
				case 7:
					System.out.println(m + "월은 여름입니다.");
					break;
				case 8:
					System.out.println(m + "월은 여름입니다.");
					break;
				case 9:
					System.out.println(m + "월은 가을입니다.");
					break;
				case 10:
					System.out.println(m + "월은 가을입니다.");
					break;
				case 11:
					System.out.println(m + "월은 가을입니다.");
					break;
				case 12:
					System.out.println(m + "월은 겨울입니다.");
					break;
			}
			cnt++;
		}
		
		sc.close();

	}

}
