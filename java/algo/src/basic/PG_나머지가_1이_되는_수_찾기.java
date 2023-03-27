/**
 https://school.programmers.co.kr/learn/courses/30/lessons/87389

 */

package basic;

// 나머지가 1이 되게 하는 수 중 가장 작은 자연수
// n-1의 약수 중 1이 아닌 가장 작은 수
public class PG_나머지가_1이_되는_수_찾기 {

    public int solution(int n) {
        int answer = 0;

        int m = n-1;

        for(int i=2; i<=n; i++) {
            if (m % i == 0) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
