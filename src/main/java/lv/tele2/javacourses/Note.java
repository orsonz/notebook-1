package lv.tele2.javacourses;


import asg.cliche.Command;

public class Note extends Record {
    private String note;

    public String getNote() {
        return note;
    }

    @Command
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + getId() + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        if (super.contains(str)) {
            return true;
        }
        String low = str.toLowerCase();
        String ln = note.toLowerCase();
        return ln.contains(low);
    }
}
