package old;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        FileOutputStream fileOutputStream = new FileOutputStream("info.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while (true) {
            String line = bufferedReader.readLine();
            if (line.equalsIgnoreCase("bye")) {
                break;
            }
            bufferedOutputStream.write((line + "\n").getBytes());
        }
        bufferedOutputStream.flush();
        System.out.println("----");
        System.out.println("the input insertion stopped");
    }
}