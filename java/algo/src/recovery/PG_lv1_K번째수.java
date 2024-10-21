package recovery;

import java.util.*;

public class PG_lv1_K번째수 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int[] command = commands[i];
            int[] tmp = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(tmp);
            answer[i] = tmp[command[2]-1];
        }

        return answer;
    }
}
