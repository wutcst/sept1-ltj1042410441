package cn.edu.whut.sept.zuul;

import java.util.Scanner;
//Parser类中有CommandWords类对象作为成员变量，因此二者之间是组合关系；
//Parser类的方法getCommand()中有Command类作为方法的局部变量，因此二者之间是依赖关系。
public class Parser {
    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }
    /**
     * 该类是“World-of-Zuul”应用程序的解析类。
     *
     * parser类的实例，实现对命令的操作：读入命令，解析命令
     *
     * @author  ZYZ
     * @version 1.0
     */
    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

        @SuppressWarnings("resource")
		Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        if (commands.isCommand(word1)) {
            return new Command(word1, word2);
        } else {
            return new Command(null, word2);
        }
    }

    public void showCommands() {
        commands.showAll();
    }
}
