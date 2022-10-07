package ssafy;

import java.util.*;
import java.io.*;

public class BJ_스도쿠_2239_bit_clone {
	
	static StringBuilder sb = new StringBuilder();
	static int[][] input;
	static int cnt;
	static List<int[]> el;
	static boolean isCom;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int[] vr = new int[9];	// 행
		int[] vc = new int[9];	// 열
		int[][] vs = new int[3][3];
		el = new ArrayList<>();
		
		input = new int[9][9];
		for(int i=0; i<9; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<9; j++) {
				int tmp = line[j] - '0';
				vr[i] |= 1<<tmp;
				vc[j] |= 1<<tmp;
				vs[i/3][j/3] |= 1<<tmp;
				if (tmp == 0) el.add(new int[] {i, j});
				input[i][j] = tmp;
			}
		}
		
		cnt = el.size();
		
		solve(0, vr, vc, vs);
		
		System.out.println(sb);
	}
	
	static void solve(int idx, int[] vr, int[] vc, int[][] vs) {
		if (isCom) return;
		if (idx == cnt) {
			isCom = true;
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(input[i][j]);
				}
				sb.append('\n');
			}
			return;
		}
		
		int row = el.get(idx)[0];
		int col = el.get(idx)[1];
		
		for(int i=1; i<=9; i++) {
			if ((vr[row]&1<<i)!=0 || (vc[col]&1<<i)!=0 || (vs[row/3][col/3]&1<<i)!=0) continue;
			int[] nvr = vr.clone();
			int[] nvc = vc.clone();
			int[][] nvs = new int[3][];
			for(int k=0; k<3; k++) {
				nvs[k] = vs[k].clone();
			}
			nvr[row] |= 1<<i;
			nvc[col] |= 1<<i;
			nvs[row/3][col/3] |= 1<<i;
			input[row][col] = i;
			solve(idx+1, nvr, nvc, nvs);
		}
	}
	
	
	
}