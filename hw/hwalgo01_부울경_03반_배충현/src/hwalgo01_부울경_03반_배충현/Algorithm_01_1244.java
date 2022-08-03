package hwalgo01_부울경_03반_배충현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_01_1244 {

	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int g = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (g == 1) {
				// 학생의 성별이 남자일 때
				for (int j = num; j <= N; j += num) {
					change(j);
				}
			} else if (g == 2) {
				// 학생의 성별이 여자일 때 	
				change(num);
				
				int left = num - 1;
				int right = num + 1;
				
				while ( left > 0 && right <= N) {
					if (arr[left] == arr[right]) {
						change(left);
						arr[right] = arr[left];
					} else {
						break;
					}
					left--;
					right++;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}
	
	static void change(int i) {
		if (arr[i] == 1) {
			arr[i] = 0;
		} else {
			arr[i] = 1;
		}
	}
	
}
