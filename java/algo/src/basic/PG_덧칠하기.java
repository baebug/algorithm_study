/**
 Programmers
 Lv.2

 한 구역에 페인트를 여러 번 칠해도 되고 다시 칠해야 할 구역이 아닌 곳에 페인트를 칠해도 되지만
 다시 칠하기로 정한 구역은 적어도 한 번 페인트칠을 해야 합니다.
 예산을 아끼기 위해 다시 칠할 구역을 정했듯 마찬가지로 롤러로 페인트칠을 하는 횟수를 최소화하려고 합니다.

 정수 n, m과 다시 페인트를 칠하기로 정한 구역들의 번호가 담긴 정수 배열 section 이 매개변수로 주어질 때
 롤러로 페인트칠해야 하는 최소 횟수를 return 하는 solution 함수를 작성해 주세요.

 input  : n=8, m=4, section=[2, 3, 6]
 output : 2

 2중 for 문 : 범위가 10만이라 안 됨

 투포인터 : 제일 많이 지우는 경우를 찾음 (그리디)
    - 무조건 많이 지운다고 최소는 아니다!
    - 반례 : 10, 6, [1, 3, 4, 7, 8, 10]

 그냥 순차적으로 앞에서 지워나가면 끝이었네... 레전드레전드

 */
package basic;

public class PG_덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int start = section[0];

        for (int idx=0; idx<section.length; idx++) {
            int tmp = section[idx] - start + 1;
            if (tmp > m) {
                answer++;
                start = section[idx];
            }
        }

        return answer+1;
    }

}
