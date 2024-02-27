package org.HumanFriends;

import org.HumanFriends.Model.Cats;
import org.HumanFriends.Model.Horses;

public class Main {
    public static void main(String[] args) {


        System.out.println("Hello world!");
        Cats cat1 = new Cats("Муся", 10);
        Horses horse1 = new Horses("Мaria", 12);
        System.out.println(cat1.displayInfo());
        System.out.println(horse1.displayInfo());
        System.out.println("Hello world!");
    }
}