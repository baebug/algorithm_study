package datastructure;

import java.util.Arrays;

public class MaxHeap {
    private int heapSize;
    private int capacity;
    private int[] maxHeap;

    public MaxHeap() {
        this.capacity = 11;
        maxHeap = new int[capacity];
    }

    public void add(int data) {
        if (heapSize == capacity - 1) {
            capacity *= 2;
            int[] tmp = new int[capacity];
            System.arraycopy(this.maxHeap, 0, tmp, 0, heapSize + 1);
            this.maxHeap = tmp;
        }

        maxHeap[++heapSize] = data;

        // 재정렬 : 끝에 넣었으니 부모와 비교하면서 더 크면 swap
        for(int i=heapSize; i>1; i/=2) {
            if (maxHeap[i] > maxHeap[i/2]) swap(i, i/2);
        }
    }

    public int remove() {
        if (isEmpty()) return -1;

        int maxValue = maxHeap[1];
        maxHeap[1] = maxHeap[heapSize];
        maxHeap[heapSize--] = 0;    // 가져온 자리의 값은 0 으로 바꿔준다. (사실 heapSize 가 줄어들기 때문에 그렇게 중요한건 아닌듯?)

        // 재정렬 : root 에 임의의 값이 들어왔으니 자식과 비교하면서 더 작으면 swap, 두 자식보다 크면 stop
        // 마지막의 마지막까지 가더라도 기존의 값이 있던 곳은 크기가 할당되어 있으니 OOR 안뜬다.
        for(int i=1; i*2<=heapSize;) {
            if (maxHeap[i] > maxHeap[i*2] && maxHeap[i] > maxHeap[i*2+1]) break;
            // 왼쪽이든 오른쪽이든 이동해야 하는 상황 --> 왼쪽, 오른쪽을 비교해서 더 큰 애가 올라온다.
            else if (maxHeap[i*2] > maxHeap[i*2+1]) {
                swap(i, i*2);
                i = i*2;
            }
            else {
                swap(i, i*2+1);
                i = i*2+1;
            }
        }

        return maxValue;
    }

    public int size() {
        return heapSize;
    }

    public boolean isEmpty() {
        return heapSize == 0 ? true : false;
    }

    public int peek() {
        if (isEmpty()) return -1;
        else return maxHeap[1];
    }

    @Override
    public String toString() {
        if (heapSize == 0) return "MaxHeap = []";

        String out = Integer.toString(maxHeap[1]);
        for(int i=2; i<=heapSize; i++) {
            out += ", " + maxHeap[i];
        }
        return "MaxHeap = [" + out + "]";
    }

    private void swap(int from, int to) {
        int tmp = maxHeap[from];
        maxHeap[from] = maxHeap[to];
        maxHeap[to] = tmp;
    }
}
