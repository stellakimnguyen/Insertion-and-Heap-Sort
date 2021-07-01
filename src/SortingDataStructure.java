public abstract class SortingDataStructure {
    protected ExpandableArray content;

    // GETTERS & SETTERS
    public abstract ExpandableArray getContent();
    public abstract void setContent(ExpandableArray content);

    /**
     * Sort the data structure
     */
    public abstract void sort();

    /**
     * Print the data structure
     */
    public abstract void print();
}