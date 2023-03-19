/**
 Programmers Lv.1
 https://school.programmers.co.kr/learn/courses/30/lessons/161990?language=java#

 컴퓨터 바탕화면의 상태를 나타내는 문자열 배열 wallpaper 가 매개변수로 주어질 때
 바탕화면의 파일들을 한 번에 삭제하기 위해 최소한의 이동거리를 갖는
 드래그의 시작점과 끝점을 담은 정수 배열을 return 하는 solution 함수를 작성하세요.

 드래그의 시작점이 (lux, luy), 끝점이 (rdx, rdy)라면
 정수 배열 [lux, luy, rdx, rdy]를 return 하면 됩니다.

 input  : [".#...", "..#..", "...#."]
 output : [0, 1, 3, 4]
 */

package basic;

public class PG_바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};

        //  [
        //      ".#...",
        //      "..#..",
        //      "...#."
        //  ]

        int wh = wallpaper.length; // 3
        int ww = wallpaper[0].length(); // 5

        int sx, sy, ex, ey;
        sx = sy = Integer.MAX_VALUE;
        ex = ey = Integer.MIN_VALUE;

        for (int i=0; i<wh; i++) {
            char[] line = wallpaper[i].toCharArray();
            for (int j=0; j<ww; j++) {
                if (line[j] == '#') {
                    // 파일 발견
                    sx = Math.min(sx, j);
                    sy = Math.min(sy, i);
                    ex = Math.max(ex, j+1);
                    ey = Math.max(ey, i+1);
                }
            }
        }

        answer = new int[] {sy, sx, ey, ex};
        return answer;
    }
}
