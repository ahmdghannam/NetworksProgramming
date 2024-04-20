package old;

import java.util.Scanner;

public class ProgLang {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        while (true) {
            String command = scan.nextLine();
            String instruction = wordAt(command, 0);
            if (commandsDetection(instruction, command)) break;

        }
        System.out.println("program ended successfully");

    }

    private static boolean commandsDetection(String instruction, String command) {
        if (instruction.equalsIgnoreCase("end")) {
            return true;
        } else if (instruction.equalsIgnoreCase("print")) {
            handlePrint(command);
        } else if (instruction.equalsIgnoreCase("wordAt")) {
            handleWordAt(command);
        } else if (instruction.equalsIgnoreCase("fac") ||
                instruction.equalsIgnoreCase("factorial")) {
            handleFactorial(command);
        }
        return false;
    }

    private static void handleFactorial(String command) {
        int number = Integer.parseInt(wordAt(command, 1));
        System.out.println(factorialOf(number));

    }
    public static int factorialOf(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    private static void handleWordAt(String command) {
        var text = command.split(" ");
        int index = Integer.parseInt(text[1]);
        String output = detectTextInSingleQuotation(command);
        System.out.println("the word you are looking for is: ");
        System.out.println(wordAt(output, index));
    }

    private static void handlePrint(String command) {
        var text = command.split(" ");
        int numberOfIterations = Integer.parseInt(text[1]);
        String output = detectTextInSingleQuotation(command);
        printTimes(numberOfIterations, output);
    }

    private static String detectTextInSingleQuotation(String text) {
        int startOfText = text.indexOf("'");
        int endOfText = text.lastIndexOf("'");
        return text.substring(startOfText + 1, endOfText);
    }

    private static void printTimes(int numberOfIterations, String output) {
        for (int i = 0; i < numberOfIterations; i++) {
            System.out.println(i+1+" : "+output);
        }
    }

    private static String wordAt(String command, int index) {
        return command.split(" ")[index];
    }
}
