package dataStructures.heap;

public class Heap {
    private int heapSize;
    private int heap[];
    int capacity;

    public Heap(int capacity) {
        heapSize = 0;
        this.capacity = capacity;
        heap = new int[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public void MaxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l < heapSize && heap[l] > heap[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < heapSize && heap[r] > heap[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(largest, i);
            MaxHeapify(largest);
        }
    }

    public int heapMaximum() {
        return heap[0];
    }

    public int heapExtractMax() {
        if (heapSize == 0) {
            System.out.println("heap underflow");
            return Integer.MIN_VALUE;
        }
        heapSize--;
        int max = heap[0];
        heap[0] = heap[heapSize];
        MaxHeapify(0);
        return max;
    }

    public void increaseKey(int i, int key) {
        if (i >= heapSize) {
            System.out.println("invalid key");
            return;
        }
        if (heap[i] >= key) {
            System.out.println("assigned value is smaller than previous");
            return;
        }
        while (i > 0 && heap[parent(i)] < key) {
            // heap[i]=heap[parent(i)];
            swap(parent(i), i);
            i = parent(i);
        }
        heap[i] = key;
    }

    public void deleteKey(int i) {
        heapSize--;
        if (heap[i] > heap[heapSize]) {
            heap[i] = heap[heapSize];
            MaxHeapify(i);
        } else {
            increaseKey(i, heap[heapSize]);
        }
    }

    public void decreaseKey(int i, int key) {
        if (i >= heapSize) {
            System.out.println("Invalid Key");
            return;
        }
        if (heap[i] <= key) {
            System.out.println("Current key is greater than previous key");
            return;
        }
        heap[i] = key;
        MaxHeapify(i);
    }

    public void InsertKey(int key) {
        if (heapSize == capacity) {
            System.out.println("heap OverFlow");
            return;
        }
        heap[heapSize++] = Integer.MIN_VALUE;
        increaseKey(heapSize - 1, key);

    }

    public void print() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap pq = new Heap(10);
        pq.InsertKey(2);
        pq.InsertKey(3);
        pq.InsertKey(4);
        pq.InsertKey(5);
        pq.decreaseKey(0, 0);
        pq.print();
        // System.out.println(pq.heapSize);
        // pq.increaseKey(0,9);
        // pq.print();
        // System.out.println(pq.heapExtractMax());
        // pq.print();

    }
}
