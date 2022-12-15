package basic;

import java.util.Arrays;
import java.util.List;

public class PG_단체사진찍기 {

    final char[] members = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    Character[] line = new Character[8];
    int ans;

    // 조합 완성 후 valid check
    public int solution(int n, String[] data) {
        ans = 0;
        comb(0, 0, n, data);
        return ans;
    }

    void comb(int cnt, int flag, int n, String[] data) {
        if (cnt == 8) {
            // valid check
            // data[i] parsing 후 idx 찾아서(List) 비교
            List<Character> list = Arrays.asList(line);
            if (isValid(list, n, data)) ans++;
            return;
        }

        for(int i=0; i<8; i++) {
            if ((flag & 1<<i) != 0) continue;
            line[cnt] = members[i];
            comb(cnt+1, flag|1<<i, n, data);
        }

    }

    boolean isValid(List<Character> list, int n, String[] data) {
        for(int i=0; i<n; i++) {
            String row = data[i];

            char from = row.charAt(0);
            int fromIdx = list.indexOf(from);
            char to = row.charAt(2);
            int toIdx = list.indexOf(to);
            char operator = row.charAt(3);
            int val = row.charAt(4) - '0';

            int diff = Math.abs(fromIdx - toIdx) - 1;

            if (operator == '<' && diff >= val) return false;
            else if (operator == '>' && diff <= val) return false;
            else if (operator == '=' && diff != val) return false;
        }

        return true;
    }

}
