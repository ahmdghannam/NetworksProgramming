// Thread class
// Runnable interface
// Callable interface

import java.util.ArrayList;
import java.util.Scanner;
//R:\\home\\CSE\\semester 10\\networks programming\\java\\NetworksProgramming\\src\\names
//R:\\home\\CSE\\semester 10\\networks programming\\java\\NetworksProgramming\\src\\grades
//R:\\home\\CSE\\semester 10\\networks programming\\java\\NetworksProgramming\\src\\date
//end

public class Threads {
    public static void main(String[] args) {
        var arr = new ArrayList<Thread>();
        welcomeStatements();
        getFilesPaths(arr);
        startThreads(arr);
    }

    private static void welcomeStatements() {
        System.out.println("welcome to file reader.");
        System.out.println("please enter the files paths, one path in each line.");
        System.out.println("once you finished write end.");
    }

    private static void getFilesPaths(ArrayList<Thread> arr) {
        var scan = new Scanner(System.in);
        while (true) {
            String path = scan.nextLine();
            if (path.equalsIgnoreCase("end")) return;
            arr.add(
                    new Thread(new ReadFile(path))
            );
        }
    }

    private static void startThreads(ArrayList<Thread> arr) {
        for (Thread thread : arr) {
            thread.start();
        }
    }
}
