package basic;

// import java.math.BigInteger;

public class PG_크기가작은부분문자열 {
    public int solution(String t, String p) {
        int answer = 0;

        int ll = t.length();
        int sl = p.length();
        Long comp = Long.parseLong(p);
        // BigInteger comp = new BigInteger(p);

        for(int i=0; i<=ll-sl; i++) {
            Long tmp = Long.parseLong(t.substring(i, i + sl));
            if (tmp <= comp) answer++;
            // BigInteger tmp = new BigInteger(t.substring(i, i + sl));
            // if (tmp.compareTo(comp) != 1) answer++;
        }

        return answer;
    }
}
