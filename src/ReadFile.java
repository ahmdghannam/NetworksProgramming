import java.io.*;
import java.util.Objects;

class ReadFile implements Runnable {
    String filePath;
    ReadFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = new BufferedReader(
                Objects.requireNonNull(tryGetFileReader())
        );
        BufferedWriter bufferedWriter = new BufferedWriter(
                Objects.requireNonNull(tryGetFileWriter())
        );
        fromFileToTheBuffer(bufferedReader, bufferedWriter);
        tryCloseTheBuffer(bufferedWriter);
    }

    private static void tryCloseTheBuffer(BufferedWriter bufferedWriter) {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("cannot write to the file");
        }
    }

    private static void fromFileToTheBuffer(BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        String line;
        while (true) {
            line = readFromFile(bufferedReader);
            if (line == null) break;
            writeLineToFileBuffer(bufferedWriter, line);
            System.out.println(line);
        }
    }

    private FileReader tryGetFileReader() {
        FileReader fileReader;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("file not found ");
            return null;
        }
        return fileReader;
    }

    private static String readFromFile(BufferedReader bufferedReader) {
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("error reading");
        }
        return line;
    }

    private static void writeLineToFileBuffer(BufferedWriter bufferedWriter, String data) {
        try {
            bufferedWriter.write(data + "\n");
        } catch (IOException e) {
            System.out.println("cannot write to the buffer");
        }
    }

    private static FileWriter tryGetFileWriter() {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("R:\\\\home\\\\CSE\\\\semester 10\\\\networks programming\\\\java\\\\NetworksProgramming\\\\src\\\\combined",true);
        } catch (IOException e) {
            System.out.println("cannot write to the file");
            return null;
        }
        return fileWriter;
    }
}