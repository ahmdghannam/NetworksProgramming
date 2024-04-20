package old;

import java.io.*;
import java.util.Scanner;

public class Grades {
    public static void main(String[] args) throws IOException {
        //Suppose that each line in a text file contains a name of a student
        //and his grades first, second, and final separated by spaces
        //(example: Rami 20 21 43).
        //Write a program that reads the name of the text file from the
        //keyboard and saves the names and results of passed students
        //(result >= 50) in a new file.
        //Note: Use either PrintWriter or PrintStream class.
        var scan =new Scanner(System.in);
        System.out.println("please enter the path of the file");
        String filePath=scan.nextLine();
        var fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileOutputStream fileOutputStream = new FileOutputStream("passedStudents.txt");
//        var bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        var printWriter= new PrintWriter(fileOutputStream);

        String data;
        while ((data = bufferedReader.readLine()) != null) {
            String[] splitted = data.split(" ");
            var name = splitted[0];
            int grade = findGrade(splitted);
            var res = name + " " + grade + "\n";
            if (grade >= 50) {
                System.out.println(res);
                printWriter.write(res);
//                bufferedOutputStream.write(res.getBytes());
//                bufferedOutputStream.flush();
            }
        }
        printWriter.flush();
        // printWriter.close();

    }

    private static int findGrade(String[] splitted) {
        int grade = 0;
        for (int i = 1; i < splitted.length; i++) {
            grade += Integer.parseInt(splitted[i]);
        }
        return grade ;
    }
}
