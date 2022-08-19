package ssafy;

import java.io.*;
import java.util.*;

// s+2의 가로와 2s+3의 세로. 나머지는 공백
public class BJ_LCDTest_2290_73453 {
	
	static StringBuilder sb = new StringBuilder();
	static int s, n, l;
	static char[][] monitor;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		s = Integer.parseInt(stk.nextToken());
		String n = stk.nextToken();
		l = n.length();
		monitor = new char[2*s+3][(s+3)*l];
		
		for (int i = 0; i < monitor.length; i++) {
			for (int j = 0; j < monitor[0].length; j++) {
				monitor[i][j] = ' ';
			}
		}
		
		for (int i = 0; i < l; i++) {
			print(n.charAt(i), i);
		}
		
		for (int i = 0; i < monitor.length; i++) {
			for (int j = 0; j < monitor[0].length; j++) {
				sb.append(monitor[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	static void print(char c, int idx) {
		int st = idx * (s+3);
		int ed = st + s + 1;
		switch (c) {
		
			case '1':
				printCT(ed);
				printCB(ed);
				return;
			case '2':
				printRT(st);
				printCT(ed);
				printRM(st);
				printCB(st);
				printRB(st);
				return;
			case '3':
				printRT(st);
				printCT(ed);
				printRM(st);
				printCB(ed);
				printRB(st);
				return;
			case '4':
				printCT(st);
				printCT(ed);
				printRM(st);
				printCB(ed);
				return;
			case '5':
				printRT(st);
				printCT(st);
				printRM(st);
				printCB(ed);
				printRB(st);
				return;
			case '6':
				printRT(st);
				printCT(st);
				printRM(st);
				printCB(st);
				printCB(ed);
				printRB(st);
				return;
			case '7':
				printRT(st);
				printCT(ed);
				printCB(ed);
				return;
			case '8':
				printRT(st);
				printCT(st);
				printCT(ed);
				printRM(st);
				printCB(st);
				printCB(ed);
				printRB(st);
				return;
			case '9':
				printRT(st);
				printCT(st);
				printCT(ed);
				printRM(st);
				printCB(ed);
				printRB(st);
				return;
			case '0':
				printRT(st);
				printCT(st);
				printCT(ed);
				printCB(st);
				printCB(ed);
				printRB(st);
				return;
		}
	}
	
	static void printCT(int st) {
		for (int i = 1; i <= s; i++) monitor[i][st] = '|';
	}
	
	static void printCB(int st) {
		for (int i = 1; i <= s; i++) monitor[s+1+i][st] = '|';
	}
	
	static void printRT(int st) {
		for (int i = 1; i <= s; i++) monitor[0][st+i] = '-';
	}
	static void printRM(int st) {
		for (int i = 1; i <= s; i++) monitor[s + 1][st+i] = '-';
	}
	static void printRB(int st) {
		for (int i = 1; i <= s; i++) monitor[2*s + 2][st+i] = '-';
	}

}
