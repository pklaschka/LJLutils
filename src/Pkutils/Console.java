package Pkutils;

import java.util.ArrayList;

public class Console {
    private static int indentionLevel = 0;
    private static boolean isPrintingToConsole;
    private static String consoleText;
    private static ArrayList<ConsoleObserver> observers;

    /**
     * Prints out Object in the console.
     *
     * @param object The Object that's to be printed
     */
    public static void print(Object object) {
        consoleText += object.toString();
        if (isPrintingToConsole) {
            System.out.print(object);
        }
        for (ConsoleObserver observer : observers) {
            observer.notifyConsoleChange(consoleText);
        }
    }

    /**
     * Prints out Object in a new line in the console.
     *
     * @param object The Object that's to be printed
     */
    public static void println(Object object) {
        print("\n" + object);
    }

    /**
     * Prints the Object on a new line with the saved indention level.
     * @param object The Object that's to be printed
     */
    public static void printlnIndented(Object object) {
        printlnIndented(object, getIndentionLevel());
    }

    /**
     * Prints the Object on a new line with the indention level set in the parameters.
     *
     * @param object         The Object that's to be printed
     * @param indentionLevel The indention level (corresponding to the count of '\t' before the content
     */
    public static void printlnIndented(Object object, int indentionLevel) {
        print("\n");
        for (int i = 0; i < indentionLevel; i++) {
            print("\t");
        }
        print(object);
    }

    public static int getIndentionLevel() {
        return indentionLevel;
    }

    public static void setIndentionLevel(int indentionLevel) {
        Console.indentionLevel = Math.max(0, indentionLevel);
    }

    /**
     * Increases the indention level by 1
     *
     * @return The new indention level
     */
    public static int increaseIndentionLevel() {
        setIndentionLevel(getIndentionLevel() + 1);
        return getIndentionLevel();
    }

    /**
     * Decreases the indention level by 1
     *
     * @return The new indention level
     */
    public static int decreaseIndentionLevel() {
        setIndentionLevel(getIndentionLevel() - 1);
        return getIndentionLevel();
    }
}
