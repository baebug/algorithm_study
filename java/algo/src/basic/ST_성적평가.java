/**
 https://softeer.ai/practice/info.do?idx=1&eid=1309

 현주는 N명의 인원이 참여하는 프로그래밍 스터디 그룹을 이끌고 있다.
 현주는 스터디를 위해 대회를 세 개 개최하였고, 모든 구성원이 각 대회에 참여하였다. 참가자는 각 대회에서 0 이상 1,000 이하의 정수인 점수를 얻는다. 한 대회에서 둘 이상의 참가자가 동점이 나오는 경우도 있을 수 있다.
 현주는 각 대회별 등수 및 최종 등수를 매기고 싶다. 등수는 가장 점수가 높은 사람부터 1등, 2등, ···, N등의 순서대로 붙는다. 만일 동점이 있을 경우 가능한 높은 (등수의 수가 작은) 등수를 부여한다. 즉, 점수가 내림차순으로 10,7,6,6,4의 순서일 경우, 6점을 받은 두 사람은 공동 3등이 되고, 그 다음 순서인 4점을 받은 사람은 5등이 된다. 이 규칙을 다르게 표현하면 다음과 같다: 각 사람마다 “나보다 점수가 큰 사람”의 수를 세어 1을 더한 것이 자신의 등수가 된다. 대회별 등수는 각 대회에서 얻은 점수를 기준으로 하며 최종 등수는 세 대회의 점수의 합을 기준으로 한다.
 각 참가자의 대회별 등수 및 최종 등수를 출력하는 프로그램을 작성하시오.

 제약 조건 :
    3 ≤ N ≤ 100,000

 input :
    3 \n 40 80 70 \n 50 10 20 \n 100 70 30

 output :
    3 1 2 \n 1 3 2 \n 1 2 3 \n 1 2 3

 풀이 과정 :
    N 이 10 만까지 들어오기 때문에 이중 for 문은 포기
    무식하지만 priorityQueue 를 사용해서 풀었다.
    조금이라도 시간을 단축하기 위해서 1 ~ 3번째 대회는 입력을 받음과 동시에 pq 에 넣었고, 최종 결과만 저장하여 계산하였다.

    아쉬운 점은 메소드 분리 할 여유가 없어서 코드가 너무 무식해보인다..
    또한 동점을 처리하는 부분도 깨끗하게 처리하고 싶었으나, 당장 생각나는 방법이 없어 동점자 count 를 누적하고 더해주는 식으로 해결하였다.

    모든 대회의 점수를 input 에 저장하고 for 문을 돌렸으면 총점까지 이쁘게 만들 수 있었겠지만, trade off 는 어쩔 수 없지

 */

package basic;

import java.io.*;
import java.util.*;
public class ST_성적평가 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] sumScore = new int[N+1];
        int[][] result = new int[5][N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((s1, s2) -> s2[1] - s1[1]);

        for (int i=1; i<=3; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                int score = Integer.parseInt(stk.nextToken());
                sumScore[j] += score;
                pq.add(new int[] {j, score});
            }

            int rank = 0;
            int ss = 1;
            int prev = -1;

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();

                if (cur[1] != prev) {
                    rank += ss;
                    result[i][cur[0]] = rank;
                    ss = 1;
                    prev = cur[1];
                } else {
                    result[i][cur[0]] = rank;
                    ss++;

                }
            }
        }

        for (int j=1; j<=N; j++) {
            pq.add(new int[] {j, sumScore[j]});
        }

        int rank = 0;
        int ss = 1;
        int prev = -1;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] != prev) {
                rank += ss;
                ss = 1;
                result[4][cur[0]] = rank;
                prev = cur[1];
            } else {
                result[4][cur[0]] = rank;
                ss++;
            }
        }

        for (int i=1; i<=4; i++) {
            for (int j=1; j<=N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        // 0   0   0   0
        // 0  40  80  70
        // 0  50  10  20
        // 0 100  70  30
        // 0 190 160 120

        System.out.print(sb.toString());
    }
}
