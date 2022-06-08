package dataStructures.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Maxheap {
    int[] heap;
    int heapSize;
    int capacity;

    public Maxheap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        this.heapSize = 0;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void insert(int key) {
        if (heapSize == 0) {
            heap[0] = key;
        } else {
            heap[heapSize] = key;
            int i = heapSize;
            while (i > 0) {
                int parent = parent(i);
                if (heap[parent] < key) {
                    // swap(parent,i);
                    i = parent;
                } else {
                    break;
                }
            }
        }
        heapSize++;
    }

    void delete(int i) {

    }

    public void MaxHeapify(int[] arr, int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l < heapSize && arr[l] > arr[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < heapSize && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(arr, largest, i);
            MaxHeapify(arr, largest, heapSize);
        }
    }

    public void BuildHeap(int[] arr, int heapSize) {
        // assumin whole array has to be build
        // its o(n) operation.

        int n = heapSize;
        for (int i = n / 2 - 1; i >= 0; i--) {
            MaxHeapify(arr, i, heapSize);
        }
    }

    public void heapSort(int[] arr) {
        BuildHeap(arr, arr.length);
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            // here avoid using i-1, because i started already with n-1.
            MaxHeapify(arr, 0, i);
        }

    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 17, 10, 84, 19, 6, 22, 9};
        Maxheap m = new Maxheap(4);
        //m.MaxHeapify(arr,2);
        //m.BuildHeap(arr,arr.length);
        m.heapSort(arr);
        System.out.println(Arrays.toString(arr));
        // PriorityQueue<Integer> pd= new PriorityQueue<>();

    }

}
