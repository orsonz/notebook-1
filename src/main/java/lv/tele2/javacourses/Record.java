package lv.tele2.javacourses;

public abstract class Record {
    private static int recordCount;
    private int id;

    public Record() {
        recordCount++;
        id = recordCount;
    }

    public int getId() {
        return id;
    }

    public boolean contains(String str) {
        return String.valueOf(id).contains(str);
    }

}
