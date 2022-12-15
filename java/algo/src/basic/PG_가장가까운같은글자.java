package basic;

public class PG_가장가까운같은글자 {
    public int[] solution(String s) {
        int size=s.length();
        int[] answer = new int[size];
        int[] visited = new int[26];

        for(int i=0; i<size; i++) {
            char cur = s.charAt(i);
            int idx = s.indexOf(cur, visited[cur-'a']);
            if (idx >= i) {
                answer[i] = -1;
            } else {
                visited[cur-'a'] = i;
                answer[i] = i - idx;
            }
        }

        return answer;
    }
}
