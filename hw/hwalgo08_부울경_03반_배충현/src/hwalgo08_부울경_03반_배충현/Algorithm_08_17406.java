package hwalgo08_부울경_03반_배충현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_08_17406 {

	static int N, M, K, min;
	static int[][] input;
	static Order[] orders;
	static Order[] myOrder;
	static boolean[] used;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		input = new int[N+1][M+1];
		orders = new Order[K];
		myOrder = new Order[K];
		used = new boolean[K];
		
		
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		for (int i = 0; i < K; i++) {
			stk = new StringTokenizer(br.readLine());
			orders[i] = new Order(stk.nextToken(), stk.nextToken(), stk.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		make(0);
		
		System.out.println(min);
		

	}
	
	// 재귀적으로 order 의 조합을 생성, 조합이 완성되면 auto 메소드를 호출한다.
	static void make(int cnt) {
		if (cnt == K) {
			auto(myOrder);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (used[i]) continue;
			
			used[i] = true;
			myOrder[cnt] = orders[i];
			make(cnt+1);
			used[i] = false;
		}
	}
	
	// 조합 리스트 넘기면 자동으로 해주는 로직
	static void auto(Order[] ol) {
		int[][] tmpArray = deepCopy(input);
		for (Order o : ol) {
			rotate(o.r, o.c, o.s, tmpArray);
		}
		getMin(tmpArray);
	}
	
	// 파라미터 세개 넘겨서 연산 수행하는 로직
	static void rotate(int r, int c, int s, int[][] arr) {
		if (s == 0) return;
		int sy = r - s; int sx = c - s; int ey = r + s; int ex = c + s;
		
		int tmp = arr[sy][sx];
		for (int i = sy; i < ey; i++) {
			arr[i][sx] = arr[i+1][sx];
		}
		for (int i = sx; i < ex; i++) {
			arr[ey][i] = arr[ey][i+1];
		}
		for (int i = ey; i > sy; i--) {
			arr[i][ex] = arr[i-1][ex];
		}
		for (int i = ex; i > sx; i--) {
			arr[sy][i] = arr[sy][i-1];
		}
		arr[sy][sx+1] = tmp;
		
		rotate(r, c, s-1, arr);
	}
	
	static class Order {
		int r;
		int c;
		int s;
		
		public Order(String r, String c, String s) {
			this.r = Integer.parseInt(r);
			this.c = Integer.parseInt(c);
			this.s = Integer.parseInt(s);
		}
	}
	
	// 계산 로직 (각 행의 합 중 최솟값 반환)
	static void getMin(int[][] arr) {
		for (int i = 1; i < arr.length; i++) {
			int[] row = arr[i];
			int tmp = 0;
			for(int n : row) {
				tmp += n;
			}
			min = Math.min(tmp, min);
		}
	}
	

	// 이차원 배열 deepcopy 하는 메소드
	static int[][] deepCopy(int[][] arr) {
		int[][] tmp = new int[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			tmp[i] = arr[i].clone();
		}
		return tmp;
	}
}
