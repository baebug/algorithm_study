package basic;

public class PG_문자열나누기 {
    public int solution(String s) {
        int answer = 0;
        char cur = s.charAt(0);
        int cnt1 = 0, cnt2 = 0;

        for(int i=0, size=s.length(); i<size; i++) {
            char tmp = s.charAt(i);
            if (tmp == cur) cnt1++;
            else cnt2++;

            if (cnt1 > 0 && cnt1 == cnt2) {
                answer++;
                cur = s.charAt((i+1)%size);
                cnt1 = cnt2 = 0;
            }
        }

        if (cnt1 > 0) answer++;

        return answer;
    }
}
