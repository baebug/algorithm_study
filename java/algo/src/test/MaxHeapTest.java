package test;

import datastructure.MaxHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxHeapTest {
    MaxHeap maxHeap;

    @BeforeEach
    void init() {
        maxHeap = new MaxHeap();
        maxHeap.add(123);
        maxHeap.add(5432);
        maxHeap.add(3456);
    }

    @DisplayName("isEmpty test")
    @Test
    public void heapIsEmptyTest() throws Exception {
        assertThat(maxHeap.isEmpty()).isFalse();

        MaxHeap tmp = new MaxHeap();
        assertThat(tmp.isEmpty()).isTrue();

    }

    @DisplayName("size test")
    @Test
    public void heapSizeTest() throws Exception {
        assertThat(maxHeap.size()).isEqualTo(3);
    }

    @DisplayName("peek test")
    @Test
    public void heapPeekTest() throws Exception {
        assertThat(maxHeap.peek()).isEqualTo(5432);
    }

    @DisplayName("remove test")
    @Test
    public void heapRemoveTest() throws Exception {
        assertThat(maxHeap.remove()).isEqualTo(5432);
    }
}
