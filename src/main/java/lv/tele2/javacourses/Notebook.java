package lv.tele2.javacourses;

import asg.cliche.Command;

import java.util.ArrayList;
import java.util.Arrays;

public class Notebook {
    ArrayList<Record> records = new ArrayList<>();

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

}
