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
public class Command
{
    private String commandWord;
    private String secondWord;

    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord()
    {
        return commandWord;
    }

    public String getSecondWord()
    {
        return secondWord;
    }

    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}