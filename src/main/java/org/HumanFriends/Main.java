package org.HumanFriends;

import org.HumanFriends.Console.ConsoleCreatorAnimal;
import org.HumanFriends.Model.*;

public class Main {



    public static void main(String[] args) {

        System.out.println("************************");
         Cats cat1 = new Cats("Муся", 10, "мурчит ест спит" );
        Horses horse1 = new Horses("Мaria", 12, "ест спит ходит");
        System.out.println(cat1.displayInfo());
        System.out.println(horse1.displayInfo());
        System.out.println("************************");

        System.out.println("Введите данные животного");
        ConsoleCreatorAnimal newAnimal = new ConsoleCreatorAnimal();
        System.out.println(newAnimal.displayInfo());

            }
        }



        
      






