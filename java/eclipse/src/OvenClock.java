// 시간 문제에서는 분을 먼저 계산하고 (60분 넘을 경우 h++) 시간을 계산하자.

import java.util.Scanner;

class OvenClock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        sc.close();
        
        int tmpH = Math.floorDiv(t, 60);
        int tmpM = Math.floorMod(t, 60);
        
        if (m + tmpM >= 60) {
            m = m + tmpM - 60;
            h++;
            
            if (h + tmpH >= 24) {
                h = h + tmpH - 24;
            } else {
                h = h + tmpH;
            }
        } else {
            m = m + tmpM;
            
            if (h + tmpH >= 24) {
                h = h + tmpH - 24;
            } else {
                h = h + tmpH;
            }
        }
        
        System.out.println(h + " " + m);
    }
}