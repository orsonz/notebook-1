package lv.tele2.javacourses;

import asg.cliche.Command;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Notebook implements ShellDependent {
    private final ArrayList<Record> records = new ArrayList<>();
    private Shell parentShell;

    @Command
    public ArrayList<Record> list() {
        return records;
    }

    @Command
    public Record createPerson(String firstName, String lastName, String... phone) {
        Person result = new Person();
        result.setFirstName(firstName);
        result.setLastName(lastName);
        result.setPhone(new ArrayList<>(Arrays.asList(phone)));
        records.add(result);
        return result;
    }

    @Command
    public Record createNote(String note) {
        Note result = new Note();
        result.setNote(note);
        records.add(result);
        return result;
    }

    @Command
    public Record createReminder(String note, String time) {
        Reminder result = new Reminder();
        result.setNote(note);
        result.setTime(time);
        records.add(result);
        return result;
    }

    @Command
    public Record createAlarm(String note, String time) {
        Alarm result = new Alarm();
        result.setNote(note);
        result.setTime(time);
        records.add(result);
        return result;
    }

    @Command
    public Record edit(int id) throws IOException {
        Record r = find(id);
        if (r != null) {
            Shell shell = ShellFactory.createSubshell("#" + id, parentShell, "Editing record #" + id, r);
            shell.commandLoop();
        }
        return r;
    }

    private Record find(int id) {
        for (Record r : records) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    @Command
    public List<Record> find(String str) {
        ArrayList<Record> result = new ArrayList<>();
        for (Record r : records) {
            if (r.contains(str)) {
                result.add(r);
            }
        }
        return result;
    }

    @Command
    public List<Record> listExpired() {
        ArrayList<Record> result = new ArrayList<>();
        for (Record r : records) {
            if (r instanceof Expirable) {
                Expirable e = (Expirable) r;
                if (e.isExpired()) {
                    result.add(r);
                }
            }
        }
        return result;
    }

    @Command
    public void dismiss(int id) {
        Record r = find(id);
        if (r != null && r instanceof Expirable) {
            Expirable e = (Expirable) r;
            e.dismiss();
        } else {
            System.out.println("this isn't an expirable");
        }
    }

    @Override
    public void cliSetShell(Shell theShell) {
        this.parentShell = theShell;
    }
}
