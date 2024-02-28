package org.HumanFriends.Console;

import java.util.Scanner;

public class ConsoleCreatorAnimal {
    private String type = String.valueOf(AnimalType.getType(Integer.parseInt(prompt("Введите тип животного \n1 - кошка " +
            "\n2 - собака " +
            "\n3 - хомяк " +
            "\n4 - лошадь " +
            "\n5 - верблюд " +
            "\n6 - осёл: " ))));
    private String name = prompt("Введите имя животного:  ");
    private int age = Integer.parseInt(prompt("Введите возраст животного: "));
    private String commands = prompt("Введите команды: ");

    public ConsoleCreatorAnimal() {
    }
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCommands() {
        return commands;
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    public String displayInfo() {
        return String.format("Тип - %s. Имя - %s. Возраст - %d. Команды - %s.", type, name, age, commands);
    }


}
