package ssafy.algorithm.incomplete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BJ_회의실배정_1931
// 회의실을 사용할 수 있는 최대 회의 수
// N
// st ed
public class BJ_회의실배정_1931 {

	static int N, result = 0, total = 1;
	static Meeting[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		list = new Meeting[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			list[i] = new Meeting(stk.nextToken(), stk.nextToken());
		}
		
		Arrays.sort(list);
		
		for (int i = 0; i < N; i++) {
			meet(i, 0, 1);
		}
		
		System.out.println(result);
		
	}
	
	static void meet(int start, int last, int cnt) {
		if (list[N-1].st < list[last].ed) {
			result = Math.max(result, cnt);
			return;
		}
		
		Meeting prev = list[last];
		for (int i = start; i < N; i++) {
			// 이전 회의의 마치는 시간보다 시작이 빠르면 continue;
			if (prev.ed > list[i].st) continue;
			
			meet(i+1, i, cnt+1);
		}
		
		
	}
	
	
	static class Meeting implements Comparable<Meeting>{
		int st;
		int ed;
		
		public Meeting(String st, String ed) {
			this.st = Integer.parseInt(st);
			this.ed = Integer.parseInt(ed);
		}

		@Override
		public int compareTo(Meeting o) {
			// TODO Auto-generated method stub
			return this.st == o.st ? this.ed - o.ed : this.st - o.st;
		}
		
		
	}
	
	
}
