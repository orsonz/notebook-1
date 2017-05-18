package lv.tele2.javacourses;

import asg.cliche.Command;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Alarm extends Note {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("HH:mm");
    private LocalTime time;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Command
    public void setTime(String strTime) {
        this.time = LocalTime.parse(strTime, FORMAT);
    }

    @Override
    public boolean contains(String str) {
        if (super.contains(str)) {
            return true;
        }
        String lt = time.format(FORMAT).toLowerCase();
        return lt.contains(str);
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id='" + getId() + '\'' +
                ", note='" + getNote() + '\'' +
                ", time='" + time.format(FORMAT) + '\'' +
                '}';
    }
}
