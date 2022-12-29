/**
 /**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 *
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 *
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

import java.util.ArrayList;
import java.util.Stack;

public class Game {
    private Parser parser;
    private Room currentRoom;
    private Stack<Room> path;
    private ArrayList<Room> rooms;

    /**
     * 创建游戏并初始化内部数据和解析器.
     */
    public Game() {
        parser = new Parser();
        path = new Stack<Room>();
        rooms = new ArrayList<Room>();
        createRooms();

    }

    /**
     * 创建所有房间对象并连接其出口用以构建迷宫.
     */
    private void createRooms() {
        Room outside, theater, pub, lab, office, random;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        random = new Room("in the random room ");
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setItem("pc", 1);
        outside.setItem("watch", 1);

        theater.setExit("west", outside);
        theater.setExit("east", random);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside; // start game outside

        // 把房间添加到rooms
        rooms.add(outside);
        rooms.add(theater);
        rooms.add(pub);
        rooms.add(lab);
        rooms.add(office);
        rooms.add(random);
    }

    /**
     * 游戏主控循环，直到用户输入退出命令后结束整个程序.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop. Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * 向用户输出欢迎信息.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * 执行用户输入的游戏指令.
     * 
     * @param command 待处理的游戏指令，由解析器从用户输入内容生成.
     * @return 如果执行的是游戏结束指令，则返回true，否则返回false.
     */
    boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        } else if (commandWord.equals("look")) {
            lookItem();
        } else if (commandWord.equals("back")) {
            backRoom();
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * 执行help指令，在终端打印游戏帮助信息.
     * 此处会输出游戏中用户可以输入的命令列表
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * 执行go指令，向房间的指定方向出口移动，如果该出口连接了另一个房间，则会进入该房间，
     * 否则打印输出错误提示信息.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else if (nextRoom == rooms.get(5)) {
            randomToRoom();
        } else {
            path.push(currentRoom);
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private void lookItem() {

        System.out.println(currentRoom.getLongDescription());
        System.out.println(currentRoom.getItem());
    }

    private void backRoom() {
        currentRoom = path.peek();
        path.pop();
        System.out.println("go back successful!");
        System.out.println(currentRoom.getLongDescription());
    }

    private void randomToRoom() {
        currentRoom = rooms.get(5);
        System.out.println(currentRoom.getLongDescription());
        while (true) {
            int randomNumber = (int) Math.floor(Math.random() * 10);
            if (randomNumber < 5) {
                currentRoom = rooms.get(randomNumber);
                path.push(currentRoom);
                System.out.println("random to other room successful!");
                System.out.println(currentRoom.getLongDescription());
                break;
            }
        }

    }

    /**
     * 执行Quit指令，用户退出游戏。如果用户在命令中输入了其他参数，则进一步询问用户是否真的退出.
     * 
     * @return 如果游戏需要退出则返回true，否则返回false.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true; // signal that we want to quit
        }
    }
}