package recovery;

public class PG_lv1_없는_숫자_더하기 {

    static int[] numbers;

    public static int solution(int[] numbers) {
        int answer = 45;

        for (int n : numbers) {
            answer -= n;
        }

        return answer;
    }

    public static void init() {
        numbers = new int[] {1, 2, 3, 4, 6, 7, 8, 0};
    }

    public static void main(String[] args) {
        init();
        System.out.println(solution(numbers));
    }
}
