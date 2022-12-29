package basic;

public class PG_푸드파이트대회_1 {
    public String solution(int[] food) {
        String answer = "";
        int size = food.length;
        int[] tmp = new int[size];

        for(int i=1; i<size; i++) {
            // i 번 음식 food[i] 개
            tmp[i] = food[i]/2;
        }

        // tmp[i] = {0, 1, 2, 3}
        for(int i=1; i<size; i++) {
            for(int k=0; k<tmp[i]; k++) {
                answer += i;
            }
        }
        answer += "0";
        for(int i=1; i<size; i++) {
            for(int k=0; k<tmp[size-i]; k++) {
                answer += size-i;
            }
        }

        return answer;
    }
}
