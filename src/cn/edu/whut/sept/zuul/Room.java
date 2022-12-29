package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits;
    private HashMap<String, Integer> itemList;

    // 创建房间
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        itemList = new HashMap<>();
    }

    // 设置房间物品
    public void setItem(String name, int weight) {
        itemList.put(name, weight);
    }

    // 获取房间物品信息
    public String getItem() {
        String returnString = "items:";
        Set<String> keys = itemList.keySet();
        for (String exit : keys) {
            returnString += "\n" + exit + ":" + itemList.get(exit);
        }
        return returnString;
    }

    // 设置房间出口
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    // 获取房间简单描述
    public String getShortDescription() {
        return description;
    }

    // 获取房间详细描述
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    // 获取房间出口
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }
}



