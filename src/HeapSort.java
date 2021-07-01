public class HeapSort extends SortingDataStructure {
    private ExpandableArray content;

    // CONSTRUCTORS
    public HeapSort() {
        this.content = new ExpandableArray();
    }

    public HeapSort(ExpandableArray content) {
        this.content = content;
    }

    // GETTERS & SETTERS
    @Override
    public ExpandableArray getContent() {
        return content;
    }
    @Override
    public void setContent(ExpandableArray content) {
        this.content = content;
    }

    // METHODS
    @Override
    public void sort() {
        int n = content.getCount();

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            SIDCEntry temp = content.getArray()[0];
            content.getArray()[0] = content.getArray()[i];
            content.getArray()[i] = temp;

            // Heapify root element
            heapify(i, 0);
        }
    }

    void heapify(int n, int i) {
        // Find largest among root, left child and right child
        int largest = i; // root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && content.getArray()[left].getSIDCKey() > content.getArray()[largest].getSIDCKey())
            largest = left;

        if (right < n && content.getArray()[right].getSIDCKey() > content.getArray()[largest].getSIDCKey())
            largest = right;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            SIDCEntry swap = content.getArray()[i];
            content.getArray()[i] = content.getArray()[largest];
            content.getArray()[largest] = swap;

            heapify(n, largest);
        }
    }

    // Function to print an array
    @Override
    public void print() {
        int n = content.getCount();
        for (int i = 0; i < n; ++i)
            System.out.print(String.format("%08d", content.getArray()[i].getSIDCKey()) + " ");
        System.out.println();
    }

    // Test Heap Sort Algorithm
    public static void main(String args[]) {
        ExpandableArray data = new ExpandableArray();

        data.add(new SIDCEntry(10000000, new String[] {"Doe", "John", "01/01/1111"}));
        data.add(new SIDCEntry(20000000, new String[] {"Doe", "John", "01/01/1111"}));
        data.add(new SIDCEntry(30000000, new String[] {"Doe", "John", "01/01/1111"}));
        data.add(new SIDCEntry(40000000, new String[] {"Doe", "John", "01/01/1111"}));
        data.add(new SIDCEntry(50000000, new String[] {"Doe", "John", "01/01/1111"}));
        data.add(new SIDCEntry(60000000, new String[] {"Doe", "John", "01/01/1111"}));
        data.add(new SIDCEntry(70000000, new String[] {"Doe", "John", "01/01/1111"}));
        data.add(new SIDCEntry(80000000, new String[] {"Doe", "John", "01/01/1111"}));
        data.add(new SIDCEntry(90000000, new String[] {"Doe", "John", "01/01/1111"}));

        HeapSort hs = new HeapSort(data);
        hs.sort();
        System.out.println("Sorted Array in Ascending Order: ");
        hs.print();
    }
}