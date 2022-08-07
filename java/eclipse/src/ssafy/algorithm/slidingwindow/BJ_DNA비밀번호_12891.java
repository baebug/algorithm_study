package ssafy.algorithm.slidingwindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문자열의 길이, 부분문자열의 길이, 문자열이 주어지고 조건을 만족하는 부분문자열을 판별한다.
// A, C, G, T 알파벳이 일정 개수 이상이면 조건을 만족할 때, 나올 수 있는 부분문자열의 수를 구하기.
// 알파벳 --> 크기 26 --> 크기가 고정된 배열을 생성하면 편하다.
// 부분문자열 --> 한 칸 씩 움직이는 것에 포커싱
public class BJ_DNA비밀번호_12891 {

	static int S, P, result;	// 문자열 길이, 부분문자열 길이
	static int[] req, cur;		// 요구사항, 현재 가지고 있는 문자의 수(모든 알파벳에 대한 크기 26짜리 배열)
	static char[] input, cl;	// 주어진 문자열, 문자의 종류
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		S = Integer.parseInt(stk.nextToken());
		P = Integer.parseInt(stk.nextToken());
		
		cl = new char[] {'A', 'C', 'G', 'T'};
		input = br.readLine().toCharArray();

		req = new int[4];
		cur = new int[26];

		// req = ['A'의 수, 'C'의 수, 'G'의 수, 'T'의 수]
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			req[i] = Integer.parseInt(stk.nextToken());
		}
		
		// 처음 부분문자열 (index 0 ~ P-1) 의 문자 수를 확인하고, 해당 알파벳 위치의 값을 ++ 해준다.
		for (int i = 0; i < P; i++) {
			char tmp = input[i];
			cur[tmp - 'A']++;
		}
		
		// req 와 cur 을 비교하고, 조건에 맞으면 result++
		for (int i = 0; i < 4; i++) {
			if (cur[cl[i] - 'A'] < req[i]) break;
			if (i == 3) result++;
		}

		// 부분문자열 이동 --> 버려질 원소 (st) --, 새로 먹는 원소 (ed) ++
		// 0 ~ P-1 --> 1 ~ P --> S-P ~ S-1
		for (int st = 0, ed = P; ed < S; st++, ed++) {
			cur[input[ed] - 'A']++;
			cur[input[st] - 'A']--;
			
			for (int i = 0; i < 4; i++) {
				if (cur[cl[i] - 'A'] < req[i]) break;
				if (i == 3) result++;
			}
		}
		
		System.out.println(result);
		
	}

}
