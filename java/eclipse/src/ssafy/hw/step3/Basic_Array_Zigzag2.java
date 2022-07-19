package ssafy.hw.step3;

public class Basic_Array_Zigzag2 {
	
	static int py, px, d;

	public static void main(String[] args) {
		
		int[][] dt = {{-1, 1}, {1, -1}};
		
		int[][] arr = {
			{ 1,  2,  3,  4,  5,  6,  7},
			{ 8,  9, 10, 11, 12, 13, 14},
			{15, 16, 17, 18, 19, 20, 21},
		};
		
		int r = arr.length;
		int c = arr[0].length;
		int n = r + c - 1;
		
		for (int i = 0; i < n; i++) {
			if ((i & 1) == 0) {
				d = 0;
				if (i < r) {
					// 시작점 [i, 0]
					py = i;
					px = 0;
				} else {
					// 시작점 [r-1, i-r+1]
					py = r-1;
					px = i-r+1;
				}
			} else if ((i & 1) == 1){
				d = 1;
				if (i < c) {
					// 시작점 [0, i]
					py = 0;
					px = i;
				} else {
					// 시작점 [i-c+1, c-1]
					py = i-c+1;
					px = c-1;
				}
			}
			
			int ny = py;
			int nx = px;

			System.out.print(arr[ny][nx] + " ");
			
			while (true) {
				ny += dt[d][0];
				nx += dt[d][1];
				
				if (nx < 0 || ny < 0 || ny >= r || nx >= c) break;
				
				System.out.print(arr[ny][nx] + " ");
			}
			
			
			
		}

	}

}
