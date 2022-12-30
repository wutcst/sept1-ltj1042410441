#我在原来有的go quit help 功能上加了back和look功能用来返回上层房间和查看房间里的信息。  

#这是我的UML类图：
![1bf57009f61ec9619471ae7a8341bbb](https://user-images.githubusercontent.com/105481140/209948635-333c1579-7053-49b4-8ae0-5726f7801b10.png)
#增加了look和back功能  
扩展游戏，使得一个房间里可以存放任意数量的物件，每个物件可以有一个描述和一个重量值，玩家进入一个房间后，可以通过“look”命令查看当前房间的信息以及房间内的所有物品信息；
在游戏中实现一个“back”命令，玩家输入该命令后会把玩家带回上一个房间；
![image](https://user-images.githubusercontent.com/105481140/210038848-7815e029-6e26-4c65-bd82-05905e56c4b2.png)
![image](https://user-images.githubusercontent.com/105481140/210038964-2dd11d6e-c137-41bb-9c40-de50b22ba3d2.png)  
#测试类test测试能否正确到达地点，且在没有该方向的时候的正确性。  
![image](https://user-images.githubusercontent.com/105481140/210039005-f187cb49-f0db-4c47-b6a5-b28e6c347fc7.png)

