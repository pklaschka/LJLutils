package Pkutils;

public class Console {
    private static int indentionLevel;

    /**
     * Prints out Object in the console.
     *
     * @param object The Object that's to be printed
     */
    public static void print(Object object) {
        System.out.print(object);
    }

    /**
     * Prints out Object in a new line in the console.
     *
     * @param object The Object that's to be printed
     */
    public static void println(Object object) {
        System.out.println(object);
    }
}
