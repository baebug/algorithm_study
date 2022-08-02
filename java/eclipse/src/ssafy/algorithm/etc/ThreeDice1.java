package ssafy.algorithm.etc;
import java.util.Scanner;

public class ThreeDice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		int second = sc.nextInt();
		int third = sc.nextInt();
		sc.close();
		
		if (first == second && first == third) {
			System.out.println(10000 + first * 1000);
		} else if (first == second || first == third) {
			System.out.println(1000 + first * 100);
		} else if (second == third) {
			System.out.println(1000 + second * 100);
		} else {
			System.out.println(Math.max(first, Math.max(second, third)) * 100);
		}

	}

}
