public class SIDCEntry {
    private long SIDCKey;
    private String[] studentInfo;

    public SIDCEntry() {
        SIDCKey = 0;
        studentInfo = new String[] {"Doe", "John", "01/01/1111"};
    }

    public SIDCEntry(long key, String[] value) {
        SIDCKey = key;
        studentInfo = value;
    }

    public long getSIDCKey() {
        return SIDCKey;
    }

    public void setSIDCKey(long SIDCKey) {
        this.SIDCKey = SIDCKey;
    }

    public String[] getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(String[] studentInfo) {
        this.studentInfo = studentInfo;
    }
}
