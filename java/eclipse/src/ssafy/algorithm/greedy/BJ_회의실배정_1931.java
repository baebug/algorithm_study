package ssafy.algorithm.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BJ_회의실배정_1931
// 회의실을 사용할 수 있는 최대 회의 수
// N
// st ed
public class BJ_회의실배정_1931 {

	static int N, result;
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
		
		int ed = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (ed <= list[i].st) {
				result++;
				ed = list[i].ed;
			}
		}
		
		System.out.println(result);
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
			return this.ed == o.ed ? this.st - o.st : this.ed - o.ed;
		}
	}
}
