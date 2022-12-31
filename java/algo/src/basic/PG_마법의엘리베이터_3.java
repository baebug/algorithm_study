package basic;

public class PG_마법의엘리베이터_3 {

    public int solution(int storey) {
        int answer = 0;

        String num = Integer.toString(storey);
        int size = num.length();
        int[] nums = new int[size+1];
        for(int i=1; i<=size; i++) {
            nums[i] = num.charAt(i-1) - '0';
        }

        for(int i=size; i>0; i--) {
            int tmp = nums[i];
            if ((tmp == 5 && nums[i-1] >= 5) || tmp > 5) {
                answer += 10-tmp;
                nums[i-1]++;
            } else {
                answer += tmp;
            }
        }
        answer += nums[0];

        return answer;
    }


}
