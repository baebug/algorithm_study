/**

 어떤 부서의 업무 조직은 완전이진트리 모양이다. 즉, 부서장이 루트이고 부서장 포함 각 직원은 왼쪽과 오른쪽의 부하 직원을 가진다. 부하 직원이 없는 직원을 말단 직원이라고 부른다.
 모든 말단 직원은 부서장까지 올라가는 거리가 동일하다. 조직도 트리의 높이는 H이다.
 업무는 R일 동안 진행된다. 처음에 말단 직원들만 각각 K개의 순서가 정해진 업무를 가지고 있다. 각 업무는 업무 번호가 있다. 각 날짜에 남은 업무가 있는 경우, 말단 직원은 하나의 업무를 처리해서 상사에게 올린다. 다른 직원들도, 대기하는 업무가 있는 경우 업무를 올라온 순서대로 하나 처리해서 상사에게 올린다. 단, 홀수 번째 날짜에는 왼쪽 부하 직원이 올린 업무를, 짝수 번째 날짜에는 오른쪽 부하 직원이 올린 업무를 처리한다.
 부서장이 처리한 일은 완료된 것이다. 업무를 올리는 것은 모두 동시에 진행한다. 따라서 그날 올린 업무를 상사가 처리하는 것은 그 다음날에야 가능하다.
 부서의 조직과 대기하는 업무들을 입력 받아 처리가 완료된 업무들의 번호의 합을 계산하는 프로그램을 작성하라.

 제약 조건 :
    1 ≤ H ≤ 10
    1 ≤ K ≤ 10
    1 ≤ R ≤ 1,000

 input :
    첫 줄에 조직도의 높이 H, 말단에 대기하는 업무의 개수 K, 업무가 진행되는 날짜 수 R이 주어진다.
    그 다음 줄부터 각각의 말단 직원에 대해 대기하는 업무가 순서대로 주어진다.
    제일 왼쪽의 말단 직원부터 순서대로 주어진다.

    1 3 2 \n 9 3 7 \n 5 11 2

 output :
    완료된 업무들의 번호 합을 정수로 출력한다.

    5

 */

package basic;

import java.util.*;
import java.io.*;

public class ST_업무처리 {

    static class Node {
        public Deque<Integer> left;
        public Deque<Integer> right;

        public Node() {
            this.left = new ArrayDeque<Integer>();
            this.right = new ArrayDeque<Integer>();
        }
    }

    public static void main(String args[]) throws Exception
    {
        StringTokenizer stk;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        stk = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int R = Integer.parseInt(stk.nextToken());

        // 0 은 dummy
        int worker = (int) Math.pow(2, H+1);
        Node[] member = new Node[worker];

        for (int i=1; i<worker; i++) {
            member[i] = new Node();
        }

        // 말단 직원에게 업무 할당
        for (int i=worker/2; i<worker; i++) {
            stk = new StringTokenizer(br.readLine());
            while (stk.hasMoreTokens()) {
                member[i].left.addLast(Integer.parseInt(stk.nextToken()));
            }
        }

        int answer = 0;

        // R 일 동안 업무 진행
        for (int d=1; d<=R; d++) {

            // 부서장부터 시작
            if ((d&1) == 0) {
                // 짝수날에는 오른쪽 부하 직원이 올린 업무를 처리한다.
                if (!member[1].right.isEmpty()) answer += member[1].right.removeFirst();
            } else {
                if (!member[1].left.isEmpty()) answer += member[1].left.removeFirst();
            }

            // 직원들이 일을 위로 올림 (위에서부터)
            int start = 2;

            while (start < worker) {
                for (int cur=start; cur<start*2; cur++) {
                    // 말단 직원이면
                    if (cur >= worker/2) {
                        // 짝수 번호면 (왼쪽)
                        if ((cur&1) == 0) {
                            // 상사의 left 에 업무를 넣는다.
                            if (!member[cur].left.isEmpty()) member[cur/2].left.addLast(member[cur].left.removeFirst());
                        } else {
                            // 상사의 right 에 업무를 넣는다.
                            if (!member[cur].left.isEmpty()) member[cur/2].right.addLast(member[cur].left.removeFirst());
                        }
                    }
                    // 일반 직원이면
                    else {
                        // 짝수 날이면
                        if ((d&1) == 0) {
                            // 짝수 번호면 (왼쪽)
                            if ((cur&1) == 0) {
                                // 상사의 left 에 right 업무를 넣는다.
                                if (!member[cur].right.isEmpty()) member[cur/2].left.addLast(member[cur].right.removeFirst());
                            } else {
                                // 상사의 right 에 right 업무를 넣는다.
                                if (!member[cur].right.isEmpty()) member[cur/2].right.addLast(member[cur].right.removeFirst());
                            }
                        }
                        // 홀수 날이면
                        else {
                            // 짝수 번호면 (왼쪽)
                            if ((cur&1) == 0) {
                                // 상사의 left 에 left 업무를 넣는다.
                                if (!member[cur].left.isEmpty()) member[cur/2].left.addLast(member[cur].left.removeFirst());
                            } else {
                                // 상사의 right 에 left 업무를 넣는다.
                                if (!member[cur].left.isEmpty()) member[cur/2].right.addLast(member[cur].left.removeFirst());
                            }
                        }
                    }
                }
                start *= 2;
            }
        }

        System.out.print(answer);

    }
}
