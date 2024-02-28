package org.HumanFriends.Console;

public enum AnimalType {
    Cats, Dogs, Hamsters, Horses, Camels, Donkeys;

    public static AnimalType getType (int typeId){
        return switch (typeId) {
            case 1 -> AnimalType.Cats;
            case 2 -> AnimalType.Dogs;
            case 3 -> AnimalType.Hamsters;
            case 4 -> AnimalType.Horses;
            case 5 -> AnimalType.Camels;
            case 6 -> AnimalType.Donkeys;
            default -> null;
        };
    }
}
