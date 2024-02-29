package org.HumanFriends.Model;

import java.util.List;
import java.util.ArrayList;

public  abstract class Animals {

    public String type;

    protected String name;
    protected int age;

    protected String commands;

    public Animals() {

    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setCommands(String commands) {
        this.commands = commands;
    }

    public String getCommands() {
        return commands;
    }

    public Animals(String name, int age, String commands) {
        this.name = name;
        this.age = age;
        this.commands = commands;
        this.type = this.getClass().getSimpleName();
    }



    public String displayInfo() {
        return String.format("Тип - %s. Имя - %s. Возраст - %d. Команды - %s.", getClass().getSimpleName(), name, age, commands);
    }
}
