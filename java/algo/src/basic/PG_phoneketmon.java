package basic;

import java.util.HashSet;

public class PG_phoneketmon {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 1, 1, 1}));
    }

    static int solution(int[] nums) {
        // n(최대 1만) 마리의 폰켓몬 종류번호가 담긴 배열 nums
        // set 에 넣고 size 갱신하기
        int N = nums.length;
        int M = N/2;

        HashSet<Integer> pkm = new HashSet<>();
        for (int n : nums) {
            pkm.add(n);
        }
        int size = pkm.size();

        return size >= M ? M : size;
    }
}
