package lv.tele2.javacourses;

import asg.cliche.Shell;
import asg.cliche.ShellFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Notebook commands = new Notebook();
        Shell shell = ShellFactory.createConsoleShell(
                "cmd",
                "My Notebook",
                commands);
        shell.commandLoop();
    }
}
