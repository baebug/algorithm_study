/*
곱셈
*/

import java.util.Scanner;

class Q2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        
        System.out.println(a * Math.floorMod(b, 10));
        System.out.println(a * Math.floorDiv(Math.floorMod(b, 100), 10));
        System.out.println(a * Math.floorDiv(Math.floorMod(b, 1000), 100));
        System.out.println(a * b);
    }
}