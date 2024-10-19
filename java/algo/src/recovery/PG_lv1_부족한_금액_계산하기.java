package recovery;

public class PG_lv1_부족한_금액_계산하기 {

    static int price, money, count;

    public static long solution(int price, int money, int count) {
        long answer = -1;

        answer = Math.max(price * ((long) count * (count+1) / 2) - money, 0);

        return answer;
    }

    static void init() {
        price = 3;
        money = 20;
        count = 4;
    }

    public static void main(String[] args) {
        init();
        System.out.println(solution(price, money, count));
    }
}
