package lv.tele2.javacourses;

import asg.cliche.Command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reminder extends Note implements Expirable {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private LocalDateTime time;
    private boolean dismissed;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Command
    public void setTime(String strTime) {
        this.time = LocalDateTime.parse(strTime, FORMAT);
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
        return "Reminder{" +
                "id='" + getId() + '\'' +
                ", note='" + getNote() + '\'' +
                ", time='" + time.format(FORMAT) + '\'' +
                '}';
    }

    @Override
    public boolean isExpired() {
        if (dismissed) {
            return false;
        }
        LocalDateTime currentDate = LocalDateTime.now();
        return time.isBefore(currentDate);
    }

    @Override
    public void dismiss() {
        dismissed = true;
    }
}
