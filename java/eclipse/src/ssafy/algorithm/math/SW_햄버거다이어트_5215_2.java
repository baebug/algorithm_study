package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

public class SW_햄버거다이어트_5215_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T,N,L;
    static int dp[];
    
    static void go(int score, int cal) {
        for(int i = L; i > cal; i--) {
        	if(dp[i] < score + dp[i-cal]) {
        		dp[i] = score + dp[i-cal];
        	}
        }
    }
    
    static void input() throws IOException{
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(' ');
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            dp = new int[L+1];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());
                go(score, cal);
            }
            sb.append(dp[L]).append('\n');
        }
        System.out.println(sb.toString());  
    }
    
    public static void main(String[] args) throws IOException { 
        input();
    }
}
