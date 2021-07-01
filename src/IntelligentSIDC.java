import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class IntelligentSIDC {
    public static void populateIntelligentSIDC(String filename, ExpandableArray keyArray) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data Sets/" + filename + ".txt"));
            SIDCEntry keyAtLine;
            String temp = reader.readLine();

            while (temp != null) {
                keyAtLine = new SIDCEntry(Long.parseLong(temp), new String[] {"Doe", "John", "01/01/1111"});
                keyArray.add(keyAtLine);
                temp = reader.readLine();
            }

            reader.close();
        }
        catch (IOException e) {
            System.out.println("File exception occurred.");
        }
    }

    public static int setSIDCThreshold(String filename) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data Sets/" + filename + ".txt"));
            int nbLines = 0;
            while (reader.readLine() != null) nbLines++;
            reader.close();

            return nbLines;
        }
        catch (IOException e) {
            return -1;
        }
    }

    public static long generateKey(ExpandableArray SIDCKeys) {
        Random random = new Random();
        long newKey = 10000000 + random.nextInt(90000000);

        for (int i = 0; i < SIDCKeys.getCount(); i++) {
            if (SIDCKeys.getArray()[i].getSIDCKey() == newKey) {
                System.out.println("Key " + newKey + " already exists. Generating new key.");
                return generateKey(SIDCKeys);
            }
        }

        return newKey;
    }

    public static void allKeys(SortingDataStructure SIDCKeys) {
        SIDCKeys.sort();
        SIDCKeys.print();
    }

    public static void addEntry(SortingDataStructure SIDCKeys, long key, String[] info) {
        SIDCKeys.getContent().add(new SIDCEntry(key, info));
        SIDCKeys.sort();
    }

    public static String removeEntry(SortingDataStructure SIDCKeys, long key) {
        int count = 0;

        while (count < SIDCKeys.getContent().getCount()) {
            if (SIDCKeys.getContent().getArray()[count].getSIDCKey() == key) {
                SIDCKeys.getContent().removeAt(count);
                SIDCKeys.sort();
                return ("\nEntry with key " + key + " has been removed.");
            }
            count++;
        }

        return "\nKey not found. No entries were removed.";
    }

    public static String getValues(SortingDataStructure SIDCKeys, long key) {
        int count = 0;

        while (count < SIDCKeys.getContent().getCount()) {
            if (SIDCKeys.getContent().getArray()[count].getSIDCKey() == key) {
                return ("\nKey " + key + ": has values of " + SIDCKeys.getContent().getArray()[count].getStudentInfo()[0] +
                        " " + SIDCKeys.getContent().getArray()[count].getStudentInfo()[1] + " " + SIDCKeys.getContent().getArray()[count].getStudentInfo()[2]);
            }
            count++;
        }

        return "Key not found. No entries were selected.";
    }

    public static long nextKey(SortingDataStructure SIDCKeys, long key) {
        int count = 0;

        while (count < SIDCKeys.getContent().getCount()) {
            if (SIDCKeys.getContent().getArray()[count].getSIDCKey() == key) {
                if ((count + 1) < SIDCKeys.getContent().getCount()) {
                    return (SIDCKeys.getContent().getArray()[count + 1].getSIDCKey());
                } else if (count == SIDCKeys.getContent().getCount() - 1) {
                    return (-1);
                }
            }
            count++;
        }

        return (-2);
    }

    public static long previousKey(SortingDataStructure SIDCKeys, long key) {
        int count = 0;

        while (count < SIDCKeys.getContent().getCount()) {
            if (SIDCKeys.getContent().getArray()[count].getSIDCKey() == key) {
                if (count == 0) {
                    return (-1);
                } else {
                    return (SIDCKeys.getContent().getArray()[count - 1].getSIDCKey());
                }
            }
            count++;
        }
        return (-2);
    }

    public static void rangeKey(SortingDataStructure SIDCKeys, long lowerKey, long upperKey) {
        int count = 0;

        while (count < SIDCKeys.getContent().getCount() &&
                SIDCKeys.getContent().getArray()[count].getSIDCKey() >= lowerKey && SIDCKeys.getContent().getArray()[count].getSIDCKey() <= upperKey) {
            System.out.print(String.format("%08d", SIDCKeys.getContent().getArray()[count].getSIDCKey()) + " ");
            count++;
        }
    }

    public static void main(String[] args) throws IOException {
        int SIDCThreshold = setSIDCThreshold("CSTA_test_file5");
        ExpandableArray SIDCArray = new ExpandableArray();
        SortingDataStructure data;
        Scanner keyboard = new Scanner(System.in);

        populateIntelligentSIDC("CSTA_test_file5", SIDCArray);

        if (SIDCThreshold > 1000) {
            data = new HeapSort(SIDCArray);
        } else {
            data = new InsertionSort(SIDCArray);
        }

        addEntry(data, generateKey(data.getContent()), new String[]{"Smith", "Jane", "22/04/1998"});

        System.out.println("\nEnter the key to remove.");
        long keyInput = keyboard.nextLong();
        System.out.println(removeEntry(data, keyInput));

        System.out.println("\nEnter the key for which you would like to see its values.");
        keyInput = keyboard.nextLong();
        System.out.println(getValues(data, keyInput));

        System.out.println("\nAll keys: ");
        allKeys(data);

        System.out.println("\nEnter the key for which you would like to find its successor.");
        keyInput = keyboard.nextLong();

        if (nextKey(data, keyInput) == -1) {
            System.out.println("\nInserted key is at the last position. No next key found.");
        } else if (nextKey(data, keyInput) == -2) {
            System.out.println("\nKey not found.");
        } else {
            System.out.println("\nSuccessor of " + String.format("%08d", keyInput) + " is " + String.format("%08d", nextKey(data, keyInput)) + ".");
        }

        System.out.println("\nEnter the key for which you would like to find its predecessor.");
        keyInput = keyboard.nextLong();

        if (previousKey(data, keyInput) == -1) {
            System.out.println("\nInserted key is at the first position. No previous key found.");
        } else if (previousKey(data, keyInput) == -2) {
            System.out.println("\nKey not found.");
        } else {
            System.out.println("\nPredecessor of " + String.format("%08d", keyInput) + " is " + String.format("%08d", previousKey(data, keyInput)) + ".");
        }

        System.out.println("\nEnter the key range. \nStart: ");
        long keyRangeStart = keyboard.nextLong();

        System.out.println("\nEnter the key range. \nEnd: ");
        long keyRangeEnd = keyboard.nextLong();

        System.out.println("\nAll keys in range: ");
        rangeKey(data, keyRangeStart, keyRangeEnd);
    }
}