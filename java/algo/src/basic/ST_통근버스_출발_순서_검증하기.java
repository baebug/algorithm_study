/**
 임의의 자연수 i < j < k에 대해서, ai < aj이고 ai > ak인 경우가 하나라도 있으면 정렬이 불가능하다는 것이 증명되어 있다.
 즉, 버스들의 번호가 a1, a2, …, an와 같이 주어질 때, 이와 같은 (i, j, k)의 사례가 있다면, (오름차순) 순서대로 스택 정렬이 불가능하다.

 연구소에서 개발자로 일하고 있는 당신은, 연구소 주차장에 주차되어 있는 버스들이 임시 주차장을 활용하여 번호 순서대로(오름차순) 출발할 수 있는지 알아보는 프로그램을 만들어보려고 한다.
 버스들이 번호 순서대로 출발하는 것이 불가능한 지 알아보기 위해, 그것을 증명할 수 있는 서로 다른 (i, j, k)의 케이스들을 몇 개나 찾을 수 있는 지 출력하여라.
 (만약, 출력값이 0이라면 버스들이 위의 과정을 통해, 순서대로 출발할 수 있음을 의미한다.)

 제약조건 :
    3 ≤ N ≤ 5,000 인 정수
    버스 번호는 서로 중복되지 않는다.

 input :
    첫 번째줄에 수열의 크기 N이 주어진다.
    두 번째줄에 1부터 N까지의 정수가 재배열된 수열이 공백을 사이에 두고 주어진다.

    3
    2 3 1

 output :
    문제에서 주어진 조건을 만족하는 서로 다른 (i, j, k) 순서쌍의 개수를 출력한다.

    1

 */

package basic;

import java.util.*;
import java.io.*;

public class ST_통근버스_출발_순서_검증하기 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[][] input = new int[N+1][N+1];

        for (int i=1; i<=N; i++) {
            int cur = Integer.parseInt(stk.nextToken());
            input[0][i] = cur;
            for (int j=1; j<i; j++) {
                input[cur][j] = 1;
            }
        }
        // 0 4 2 5 3 1
        // 0 1 1 1 1 0
        // 0 1 0 0 0 0
        // 0 1 1 1 0 0
        // 0 0 0 0 0 0
        // 0 1 1 0 0 0

        for (int i=2; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                input[i][j] += input[i-1][j];
            }
        }
        // 0 4 2 5 3 1
        // 0 1 1 1 1 0
        // 0 2 1 1 1 0
        // 0 3 2 2 1 0
        // 0 3 2 2 1 0
        // 0 4 3 2 1 0

        long answer = 0;

        for (int i=1; i<=N; i++) {
            int cur = input[0][i];
            for (int j=i; j<=N; j++) {
                if (input[0][j] > cur) {
                    answer += input[cur][j];
                }
            }
        }

        // for(int i=0; i<=N; i++) {
        //     System.out.println(Arrays.toString(input[i]));
        // }

        System.out.println(answer);

    }
}
