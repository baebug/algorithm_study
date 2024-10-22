package recovery;

import java.util.*;
import java.util.stream.Collectors;

public class IntStream {

    int[] integerArrToIntArr() {
        Integer[] integers = new Integer[] {1, 2, 3};

        return Arrays.stream(integers).mapToInt(i -> i).toArray();
    }

    int[] integerListToIntArr() {
        // List<Integer> integers = Arrays.asList(1, 2, 3); --> 해당 방법은 immutable 한 리스트를 생성한다.
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));

        return integers.stream().mapToInt(i -> i).toArray();
    }

    List<Integer> stringListToIntegerList() {
        List<String> strings = Arrays.asList("1", "2", "3");

        return strings.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    List<Integer> integerSetToIntegerList() {
        Set<Integer> integers = new HashSet<>(Arrays.asList(1, 2, 3));

        return new ArrayList<>(integers);
    }

    int[] integerHashSetToIntArr() {
        Set<Integer> integers = new HashSet<>(Arrays.asList(1, 2, 3));

        return integers.stream().mapToInt(i -> i).toArray();
    }

    HashSet<Integer> intArrToIntegerHashSet() {
        int[] ints = new int[] {1, 2, 2, 3, 3, 4};

        return Arrays.stream(ints).boxed().collect(Collectors.toCollection(HashSet::new));
    }

    List<Integer> stringArrToIntegerList() {
        String[] strings = new String[] {"1", "2", "3"};

        return Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList());
    }

}
