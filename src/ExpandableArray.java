public class ExpandableArray {

    // create three variable array[] is a array,
    // count will deal with no of element add by you and
    // size will with size of array[]
    private SIDCEntry[] array;
    private int count;
    private int size;

    // constructor initialize value to variable
    public ExpandableArray()
    {
        array = new SIDCEntry[1]; // initialize with array of length 1
        count = 0;
        size = 1;
    }

    // GETTERS & SETTERS
    public SIDCEntry[] getArray() {
        return array;
    }
    public void setArray(SIDCEntry[] array) {
        this.array = array;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    // METHODS
    // function add an element at the end of array
    public void add(SIDCEntry data)
    {
        // check no of element is equal to size of array
        if (count == size) {
            growSize(); // make array size double
        } // insert element at end of array
        array[count] = data;
        count++;
    }

    // function makes size double of array
    public void growSize()
    {

        SIDCEntry temp[] = null;
        if (count == size) {

            // temp is a double size array of array
            // and store array elements
            temp = new SIDCEntry[size * 2];
            {
                for (int i = 0; i < size; i++) {
                    // copy all array value into temp
                    temp[i] = array[i];
                }
            }
        }

        // double size array temp initialize
        // into variable array again
        array = temp;

        // and make size is double also of array
        size = size * 2;
    }

    // function shrink size of array
    // which block unnecessary remove them
    public void shrinkSize()
    {
        SIDCEntry temp[] = null;
        if (count > 0) {

            // temp is a count size array
            // and store array elements
            temp = new SIDCEntry[count];
            for (int i = 0; i < count; i++) {

                // copy all array value into temp
                temp[i] = array[i];
            }

            size = count;

            // count size array temp initialize
            // into variable array again
            array = temp;
        }
    }
    // function add an element at given index

    public void addAt(int index, SIDCEntry data)
    {
        // if size is not enough make size double
        if (count == size) {
            growSize();
        }

        for (int i = count - 1; i >= index; i--) {

            // shift all element right
            // from given index
            array[i + 1] = array[i];
        }

        // insert data at given index
        array[index] = data;
        count++;
    }

    // function remove last element or put
    // zero at last index
    public void remove()
    {
        if (count > 0) {
            array[count - 1] = new SIDCEntry();
            count--;
        }
    }

    // function shift all element of right
    // side from given index in left
    public void removeAt(int index)
    {
        if (count > 0) {
            for (int i = index; i < count - 1; i++) {

                // shift all element of right
                // side from given index in left
                array[i] = array[i + 1];
            }
            array[count - 1] = new SIDCEntry();
            count--;
        }
    }

    // Test expandable array
    public static void main(String[] args)
    {
        ExpandableArray da = new ExpandableArray();

        // add 9 elements in array
        da.add(new SIDCEntry(10000000, new String[] {"Doe", "John", "01/01/1111"}));
        da.add(new SIDCEntry(20000000, new String[] {"Doe", "John", "01/01/1111"}));
        da.add(new SIDCEntry(30000000, new String[] {"Doe", "John", "01/01/1111"}));
        da.add(new SIDCEntry(40000000, new String[] {"Doe", "John", "01/01/1111"}));
        da.add(new SIDCEntry(50000000, new String[] {"Doe", "John", "01/01/1111"}));
        da.add(new SIDCEntry(60000000, new String[] {"Doe", "John", "01/01/1111"}));
        da.add(new SIDCEntry(70000000, new String[] {"Doe", "John", "01/01/1111"}));
        da.add(new SIDCEntry(80000000, new String[] {"Doe", "John", "01/01/1111"}));
        da.add(new SIDCEntry(90000000, new String[] {"Doe", "John", "01/01/1111"}));

        // print all array elements after add 9 elements
        System.out.println("Elements of array:");
        for (int i = 0; i < da.count; i++) {
            System.out.print(da.array[i].getSIDCKey() + " ");
        }

        System.out.println();

        // print size of array and no of element
        System.out.println("Size of array: " + da.size);
        System.out.println("No of elements in array: " +
                da.count);

        // shrinkSize of array
        da.shrinkSize();

        // print all array elements
        System.out.println("Elements of array "+
                "after shrinkSize of array:");
        for (int i = 0; i < da.count; i++) {
            System.out.print(da.array[i].getSIDCKey() + " ");
        }
        System.out.println();

        // print size of array and no of element
        System.out.println("Size of array: " + da.size);
        System.out.println("No of elements in array: " +
                da.count);

        // add an element at index 1
        da.addAt(1, new SIDCEntry(11000000, new String[] {"Doe", "John", "01/01/1111"}));

        // print Elements of array after adding an
        // element at index 1
        System.out.println("Elements of array after" +
                " add an element at index 1:");
        for (int i = 0; i < da.count; i++) {
            System.out.print(da.array[i].getSIDCKey() + " ");
        }

        System.out.println();

        // print size of array and no of element
        System.out.println("Size of array: " + da.size);
        System.out.println("No of elements in array: " +
                da.count);

        // delete last element
        da.remove();

        // print Elements of array after delete last
        // element
        System.out.println("Elements of array after" +
                " delete last element:");
        for (int i = 0; i < da.count; i++) {
            System.out.print(da.array[i].getSIDCKey() + " ");
        }

        System.out.println();

        // print size of array and no of element
        System.out.println("Size of array: " + da.size);
        System.out.println("No of elements in array: " +
                da.count);

        // delete element at index 1
        da.removeAt(1);

        // print Elements of array after delete
        // an element index 1
        System.out.println("Elements of array after"+
                " delete element at index 1:");
        for (int i = 0; i < da.count; i++) {
            System.out.print(da.array[i].getSIDCKey() + " ");
        }
        System.out.println();

        // print size of array and no of element
        System.out.println("Size of array: " + da.size);
        System.out.println("No of elements in array: " +
                da.count);
    }
}