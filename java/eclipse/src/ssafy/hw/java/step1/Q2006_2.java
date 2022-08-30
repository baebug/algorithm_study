package ssafy.hw.step1;

public class Q2006_2 {

	public static void main(String[] args) {
		
		int count = 0;
		int center = 2;
		
		for (int i = 0; i < 5; i++) {
			int tmp = Math.abs(i - center);
			for (int j = 0; j < 2 - tmp; j++) {
				System.out.printf("%3s", " ");
			}
			for (int j = 0; j < 1 + 2 * tmp; j++) {
				System.out.printf("%3d", ++count);
			}
			System.out.println();
		}

	}

}
