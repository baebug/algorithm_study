import basic.PG_우박수열정적분;
import basic.PG_푸드파이트대회_1;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        PG_우박수열정적분 pg = new PG_우박수열정적분();

        System.out.println(Arrays.toString(pg.solution(5, new int[][] {{0, 0}, {0, -1}, {2, -3}, {3, -3}})));
    }

}
