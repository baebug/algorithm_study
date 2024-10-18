package recovery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayAndList {

    static String[] arrInput;
    static List<String> listInput;
    static int[] tarr = {3, 4, 5};
    static List<Integer> tlist = Arrays.asList(3, 4, 5);

    private static void init() {
        arrInput = new String[]{"8 2", "10", "3 3", "0 0", "3 2 5"};
        listInput = Arrays.stream(arrInput).collect(Collectors.toList());
    }

    private static void solution() {
        /**
         * ["8 2", "10", "3 3", "0 0", "3 2 5"]
         * 가 들어왔을 때,
         * ["8 /", "X", "3 6", "-", "3 5 /"]
         * 우선 뭐 대충 이렇게 만들기
         */

        System.out.println("arr input\t:\t" + Arrays.toString(arrInput));
        System.out.println("list input\t:\t" + listInput);


        List<List<Integer>> arrOutput = Arrays.stream(arrInput)
                .map(s -> s.split(" "))
                .map(arr -> Arrays.stream(arr)
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                )
                .collect(Collectors.toList());

        List<List<Integer>> listOutput = listInput.stream()
                .map(
                        s -> Arrays.stream(s.split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                )
                .collect(Collectors.toList());

        System.out.println("arr output\t:\t" + arrOutput);
        System.out.println("arr output\t:\t" + listOutput);

        System.out.println(Arrays.stream(tarr).sum());
        System.out.println(Arrays.stream(tarr).min().getAsInt());
        System.out.println(Arrays.stream(tarr).max().getAsInt());
        System.out.println(tlist.stream().mapToInt(Integer::intValue).sum());
        System.out.println(tlist.stream().mapToInt(Integer::intValue).min().getAsInt());
        System.out.println(tlist.stream().mapToInt(Integer::intValue).max().getAsInt());

    }

    public static void main(String[] args) {
        init();
        solution();
    }
}
