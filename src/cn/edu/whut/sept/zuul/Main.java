package cn.edu.whut.sept.zuul;

public class Main {
//主启动类，通过 new 生成了一个 Game 类的对象，然后调用它的 play() 方法开始游戏。
//主启动类的功能实现需要 Game类的协助，Game类表现为 Main中的局部变量，因此二者是依赖关系。
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}