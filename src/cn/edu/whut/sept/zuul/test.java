package cn.edu.whut.sept.zuul;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class test {

	@BeforeEach
	void setUp() throws Exception {
	}
	//测试能否正确到达地点，且在没有该方向的时候的正确性。
	@Test
	public void goandbacktest() {
		Game game = new Game();
        Command command=new Command("go", "south");
        game.processCommand(command);
        command=new Command("go", "east");
        game.processCommand(command);
        command =new Command("go", "east");

        command=new Command("back","");
        game.processCommand(command);
        command=new Command("back","");
        game.processCommand(command);

	}
	public static void main(String[] args) {
		
		test t=new test();
		t.goandbacktest();
    }
}
