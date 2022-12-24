package datastructure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericArray<T> {
    private int size;
//    private int capacity;
//    private T[] array;
    private List<T> arrayList;

    public GenericArray() {
        this.size = 0;
//        maxHeap = (T[]) Array.newInstance(Object.class, capacity);
        arrayList = new ArrayList<>();
    }

    public void add(T data) {
        arrayList.add(size++, data);
    }

    @Override
    public String toString() {
        return "array = " + arrayList.toString();
    }

}
