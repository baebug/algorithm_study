/**

 이 클러스터에는 N대의 컴퓨터가 있으며, 각각의 성능은 ai라는 정수로 평가할 수 있다. 현지는 각각의 컴퓨터에 비용을 들여 업그레이드를 진행할 수 있다. 성능을 d만큼 향상시키는 데에 드는 비용은 d2원이다. (단, d는 자연수이다.)
 업그레이드를 하지 않는 컴퓨터가 있어도 되지만, 한 컴퓨터에 두 번 이상 업그레이드를 수행할 수는 없다.
 업그레이드를 위한 예산이 B원 책정되어 있다. 현지의 목표는 B원 이하의 총 비용으로 업그레이드를 수행하여, 성능이 가장 낮은 컴퓨터의 성능을 최대화하는 것이 목표이다. 이 최선의 최저성능을 계산하는 프로그램을 작성하시오.

 제약조건 :
    1 ≤ N ≤ 10^5 인 정수
    1 ≤ ai ≤ 10^9 인 정수
    1 ≤ B ≤ 10^18 인 정수

 input :
    첫째 줄에 컴퓨터의 수와 예산을 나타내는 정수 N과 B가 공백을 사이에 두고 주어진다.
    둘째 줄에 각 컴퓨터의 성능을 나타내는 N개의 정수 a1, a2, ..., an이 공백을 사이에 두고 주어진다.

    4 10
    5 5 6 1

 output :
    4

 */
package basic;

import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class ST_슈퍼컴퓨터_클러스터 {

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        BigInteger B = new BigInteger(stk.nextToken());

        int jump = (int) Math.pow(2, 29);

        // List<Integer> list = new ArrayList<>();
         int[] array = new int[N];
//        Map<Integer, Integer> map = new HashMap<>();

        stk = new StringTokenizer(br.readLine());

        int goal = 0;

        for (int i=0; i<N; i++) {
            int input = Integer.parseInt(stk.nextToken());
            // list.add(input);
             array[i] = input;
//            map.put(input, map.getOrDefault(input, 0)+1);
        }

        BigInteger cost;
        // PriorityQueue<Integer> pcq = new PriorityQueue<>((i1, i2) -> i1 - i2);

        int answer = 0;

        while (jump > 0) {

            cost = BigInteger.ZERO;

            // pcq.clear();
            // pcq.addAll(list);

            // while (!pcq.isEmpty() && pcq.peek() < goal) {
            // cost = cost.add(new BigInteger(Integer.toString(goal - pcq.poll())).pow(2));

            // if (B.compareTo(cost) < 0) break;
            // }

             for (int i=0; i<N; i++) {
                 int cur = array[i];
                 if (cur < goal) cost = cost.add(new BigInteger(Integer.toString(goal - cur)).pow(2));

                if (B.compareTo(cost) < 0) {
                    jump /= 2;
                    goal -= jump;
                    break;
                }
             }

             // for( Integer key : map.keySet() ){
             //     if (key < goal) {
             //         cost = cost.add(
             //                 new BigInteger(Integer.toString(goal - key))
             //                         .pow(2)
             //                         .multiply(new BigInteger(Integer.toString(map.get(key))))
             //         );
             //     }
             //     if (B.compareTo(cost) < 0) {
             //         jump /= 2;
             //         goal -= jump;
             //         break;
             //     }
             // }

            if (B.compareTo(cost) >= 0) {
                answer = goal;
                goal += jump;
            }

        }

        System.out.println(answer);

    }

}
