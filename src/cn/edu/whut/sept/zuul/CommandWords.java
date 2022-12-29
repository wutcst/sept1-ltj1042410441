package cn.edu.whut.sept.zuul;
/**
 * 该类是“World-of-Zuul”应用程序的词法类。
 *
 *
 * Command类的实例将创建并实现对命令的操作：判断命令合法，显示所有的命令
 *
 * @author  ZYZ
 * @version 1.0
 */
public class CommandWords {
    private static final String[] validCommands = {
            "go", "quit", "help", "look", "back"
    };

    public CommandWords() {
        // nothing to do at the moment...
    }

    public boolean isCommand(String aString) {
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].equals(aString))
                return true;
        }
        return false;
    }

    public void showAll() {
        for (String command : validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}