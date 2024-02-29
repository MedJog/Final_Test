package org.HumanFriends;

import org.HumanFriends.Console.ConsoleCreatorAnimal;
import org.HumanFriends.Model.*;

import java.util.Scanner;

public class Main {
    public static ConsoleCreatorAnimal CreateAnimal(){
        System.out.println("Введите данные животного");
        ConsoleCreatorAnimal newAnimal = new ConsoleCreatorAnimal();
        System.out.println(newAnimal.displayInfo());
        return newAnimal;
    }
    public static void ShowMenu(){
        System.out.println("Выберите пункт меню: \n" +
                " 1 - Показать список животных. \n" +
                " 2 - Завести новое животное. \n" +
                " 3 - Показать команды животного. \n" +
                " 4 - Обучить животное новым командам. \n" +
                " 0 - Выход");
    }
    public static void start(){
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        int id;
        while (flag){
            ShowMenu();
            System.out.println("Выберите пункт меню: ");
            int menuItem = Integer.parseInt(in.next());
            switch (menuItem) {
                case 1 -> System.out.println("*");
                case 2 -> {
                    System.out.println("**");
                    CreateAnimal();
                }
                case 3 -> System.out.println("***");
                case 4 -> System.out.println("****");
                case 0 -> flag = false;
                default -> System.out.println("такого варианта нет");
            }
        }
    }



    public static void main(String[] args) {

        /* System.out.println("************************");
         Cats cat1 = new Cats("Муся", 10, "мурчит ест спит" );
        Horses horse1 = new Horses("Мaria", 12, "ест спит ходит");
        System.out.println(cat1.displayInfo());
        System.out.println(horse1.displayInfo());
        System.out.println("************************");*/
        start();




    }


}



        
      






