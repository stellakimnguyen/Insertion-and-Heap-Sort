import java.util.Arrays;

public class InsertionSort extends SortingDataStructure {
    private ExpandableArray content;

    // CONSTRUCTORS
    public InsertionSort() {
        this.content = new ExpandableArray();
    }

    public InsertionSort(ExpandableArray content) {
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

    @Override
    public void sort() { // insertion sort
        int size = content.getCount();

        for (int i = 1; i < size; i++) {
            SIDCEntry key = content.getArray()[i];
            int j = i - 1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            while (j >= 0 && key.getSIDCKey() < content.getArray()[j].getSIDCKey()) {
                content.getArray()[j + 1] = content.getArray()[j];
                --j;
            }

            // Place key at after the element just smaller than itself.
            content.getArray()[j + 1] = key;
        }
    }

    @Override
    public void print() {
        int n = content.getCount();
        for (int i = 0; i < n; ++i)
            System.out.print(String.format("%08d", content.getArray()[i].getSIDCKey()) + " ");
        System.out.println();
    }

    // Test Insertion Sort Algorithm
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

        InsertionSort is = new InsertionSort(data);
        is.sort();
        System.out.println("Sorted Array in Ascending Order: ");
        is.print();
    }
}
