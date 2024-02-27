package org.HumanFriends.Model;

import java.util.List;
import java.util.ArrayList;

public  abstract class Animals {

    public String type;
    protected String name;
    protected int age;
    protected List<String> commands;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
        this.commands = new ArrayList<>();
        this.type = this.getClass().getSimpleName();
    }



    public String displayInfo() {
        return String.format("Тип - %s. Имя - %s. Возраст - %d. Команды - %s.", getClass().getSimpleName(), name, age, commands);
    }
}
