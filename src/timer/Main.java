package timer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    Map timers = new HashMap<String, Timer>();

    public void startTimerThread(String name) {
        Timer timer = new Timer(name);
        (new Thread(timer)).start();
        timers.put(name, timer);
    }

    public void stopTimerThread(String name) {
        Timer timer = (Timer) timers.get(name);
        timer.isRunning = false;
        timers.put(name, timer);
    }

    public static void main(String[] args) {
        Main program = new Main();
        //System.out.println(program.getCommand());
        while (true) {
            program.eval(program.getCommand());
        }
    }

    public String getCommand() {
        System.out.printf("Command? ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void eval(String command) {
        String[] tokens = command.split(" ");
        String operation = null;
        String arg = null;
        switch (tokens.length) {
            case 0:
                break;
            case 1:
                operation = tokens[0];
                break;
            case 2:
                operation = tokens[0];
                arg = tokens[1];
                break;
            default:
                break;
        }
        switch (operation) {
            case "start":
                startTimerThread(arg);
                break;
            case "stop":
                stopTimerThread(arg);
                break;
            case "check":
                printData();
                break;
            case "":
                break;
            default:
                System.out.println("Command not found: " + operation);
        }
    }

    public void printData() {
        for (Object object: timers.keySet()) {
            String key = (String) object;
            //Thread thread = (Thread) timers.get(key);
            
            Timer timer = (Timer) timers.get(key);

            System.out.println(timer.toString());
        }
    }

}
