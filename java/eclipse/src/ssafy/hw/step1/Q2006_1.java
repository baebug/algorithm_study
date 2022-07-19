package ssafy.hw.step1;

public class Q2006_1 {

	public static void main(String[] args) {
		
		int count = 0;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i > j) {
					System.out.printf("%3s", " ");
				} else {
					System.out.printf("%3d", ++count);
				}
				
			}
			System.out.println();
		}

	}

}
