package Pkutils;

public class Console {
    private static int indentionLevel = 0;

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

    /**
     * @param object The Object that's to be printed
     */
    public static void printlnIndented(Object object) {
        System.out.print("\n");
        for (int i = 0; i < getIndentionLevel(); i++) {
            System.out.print("\t");
        }
        System.out.print(object);
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
