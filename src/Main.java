import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Heap minHeap = new Heap();
        minHeap.addChave(3, 12);
        minHeap.addChave(4, 34);
        minHeap.addChave(1, 45);
        minHeap.addChave(6, 67);
        minHeap.addChave(2, 12);
        minHeap.printHeap();

    }
}