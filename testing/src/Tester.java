import ljlutils.ErrorManager;

/**
 * Created by user on 07.04.17.
 */
public class Tester {
    public static void main(String[] args) {
        int errorNumber = ljlutils.ErrorManager.registerError("Developer Message", "User Message");
        ljlutils.ErrorManager.setDevMode(false);
        ljlutils.ErrorManager.triggerError(errorNumber);
        ljlutils.ErrorManager.setDevMode(true);
        ljlutils.ErrorManager.triggerError(errorNumber);
    }
}
