import java.util.Scanner;

public class ThreeDice2 {

	public static void main(String[] args) {
		int[] result = new int[7];
		
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			result[sc.nextInt()]++;
		}
		sc.close();
		
		int max = 0;
		
		for(int x : result) {
			max = Math.max(x, max);
		}
		
		if (max == 3) {
			for(int i = 6; i > 0; i--) {
				if (result[i] == 3) {
					System.out.println(10000 + i * 1000);
					return;
				}
			}
		} else if (max == 2) {
			for(int i = 6; i > 0; i--) {
				if (result[i] == 2) {
					System.out.println(1000 + i * 100);
					return;
				}
			}
		} else if (max == 1) {
			for(int i = 6; i > 0; i--) {
				if (result[i] == 1) {
					System.out.println(i * 100);
					return;
				}
			}
		}
	}

}
