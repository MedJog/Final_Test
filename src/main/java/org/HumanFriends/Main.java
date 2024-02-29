package org.HumanFriends;

import org.HumanFriends.Console.ConsoleCreatorAnimal;
import org.HumanFriends.Model.*;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        start();
    }

// создание нового животного
    public static ConsoleCreatorAnimal CreateAnimal(){
        System.out.println("Введите данные животного");
        ConsoleCreatorAnimal newAnimal = new ConsoleCreatorAnimal();
        System.out.println(newAnimal.displayInfo());
        return newAnimal;
    }

    // показать меню
    public static void ShowMenu(){
        System.out.println("1 - Показать список животных.\n" +
                "2 - Добавить новое животное.\n" +
                "3-  Показать список команд животного.\n" +
                "4 - Обучить животное новым командам.\n" +
                "0 - Выход.");
    }

    // создание исходного списка животных
    public static LinkedList CreateNewDataBase(){
        LinkedList<Animals> animals = new LinkedList<>();
        Cats cat1 = new Cats("Муся", 2, "мурчит ест спит" );
        Cats cat2 = new Cats("Барсик", 3, "мурчит ест спит охотится" );
        Dogs dog1 = new Dogs("Шарик", 3, "голос лапа апорт" );
        Dogs dog2 = new Dogs("Дружок", 5, "голос лапа апорт" );
        Hamsters hamster1 = new Hamsters("Хома", 1, "ест спит" );
        Hamsters hamster2 = new Hamsters("Фима", 2, "ест спит" );
        Horses horse1 = new Horses("Моро", 8, "аллюр рысь шаг");
        Horses horse2 = new Horses("Луна", 5, "кентер аллюр рысь");
        Camels camel1 = new Camels("Фелиция", 5, "ест спит ходит плюёт");
        Camels camel2 = new Camels("Гаррисон", 3, "ест спит  плюёт");
        Donkeys donkey1 = new Donkeys("Иа-Иа", 4, "ест спит ходит");
        Donkeys donkey2 = new Donkeys("Фуа-Гра", 5, "ест спит ходит");
        animals.add(cat1);
        animals.add(cat2);
        animals.add(dog1);
        animals.add(dog2);
        animals.add(hamster1);
        animals.add(hamster2);
        animals.add(horse1);
        animals.add(horse2);
        animals.add(camel1);
        animals.add(camel2);
        animals.add(donkey1);
        animals.add(donkey2);
    return animals;
    }

    // вывод списка животных
    public static void showDataBase(LinkedList<Animals> animals){
        for (int i =0; i < animals.size(); i++){
            System.out.printf("Id: %s. %s\n", i, animals.get(i).displayInfo());
        }
    }

    // поиск животного
    public static Animals searchAnimal(LinkedList<Animals> animals, int index){
        for (int i = 0; i < animals.size(); i++){
            if (i == index){
                System.out.printf("Id: %s. %s\n", i, animals.get(i).displayInfo());
            }
        }
        return animals.get(index);
    }

    // обучить животное новым командам
public static String toLearnNewCommands(Animals animal){
        Scanner in = new Scanner(System.in);
        String animalsCommands = animal.getCommands();
        System.out.println(animalsCommands);
        System.out.print("Введите новые команды для животного (через пробел): ");
        String addAnimalCommands = in.nextLine();
        String newAnimalCommands = String.join(" ", animalsCommands, addAnimalCommands);
        //System.out.println(newAnimalCommands);
        return newAnimalCommands;
}

    // старт программы
    public static void start(){
        Scanner in = new Scanner(System.in);
        // создание исходной базы данных
        LinkedList dataBaseAnimals = CreateNewDataBase();
        boolean flag = true;
        int id;
        while (flag){
            ShowMenu();
            System.out.println("Выберите пункт меню: ");
            int menuItem = Integer.parseInt(in.next());
            switch (menuItem) {
                // показать список животных
                case 1 -> {
                    System.out.println("Наши животные:");
                    showDataBase(dataBaseAnimals);
                    System.out.println("**************************************************************************");
                }
                // добавить новое животное
                case 2 -> {
                    dataBaseAnimals.add(CreateAnimal());
                    //showDataBase(dataBaseAnimals);
                    System.out.println("Животное добавлено в базу данных.");
                    System.out.println("**************************************************************************");
                }
                // показать список команд животного
                case 3 -> {
                    System.out.print("Введите индекс животного (число от 0 до " + dataBaseAnimals.size() + "): ");
                    int index = in.nextInt();
                    Animals myAnimal = searchAnimal(dataBaseAnimals, index);
                    System.out.println(myAnimal.getCommands());
                    System.out.println("**************************************************************************");
                }
                // обучить животное новым командам
                case 4 -> {
                    System.out.print("Введите индекс животного (число от 0 до " + dataBaseAnimals.size() + "): ");
                    int index = in.nextInt();
                    Animals myAnimal = searchAnimal(dataBaseAnimals, index);
                    //toLearnNewCommands(myAnimal);
                    myAnimal.setCommands(toLearnNewCommands(myAnimal));
                    //System.out.println(myAnimal.displayInfo());
                    dataBaseAnimals.set(index, myAnimal);
                    System.out.println("Животное выучило новые команды");
                    System.out.println("**************************************************************************");
                }
                // выход
                case 0 -> flag = false;
                default -> System.out.println("такого варианта нет");
            }
        }
    }

}



        
      






