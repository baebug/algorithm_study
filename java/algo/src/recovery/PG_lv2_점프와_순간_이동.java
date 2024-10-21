package recovery;

public class PG_lv2_점프와_순간_이동 {

    public int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if ((n&1) == 0) n /= 2;
            else {
                ans++;
                n--;
            }
        }

        return ans;
    }
}
