package DesignPatternPractice;

public class FactoryDesignPatternDemo {

    public static void main(String[] args) {

        AnimalFactory animalFactory = new AnimalFactory();

        Animal d = animalFactory.getAnimalClass("dog");
        Animal c = animalFactory.getAnimalClass("cat");

        d.show();
        c.show();

    }

}

interface Animal{
    void show();
}

class Dog implements Animal{

    @Override
    public void show() {
        System.out.println("This is class dog");
    }
}

class Cat implements Animal{

    @Override
    public void show() {
        System.out.println("This is class cat");
    }
}

class AnimalFactory{

    public Animal getAnimalClass(String name){
        if (name == null)
            return null;

        if (name.equalsIgnoreCase("dog"))
            return new Dog();
        else if (name.equalsIgnoreCase("cat"))
            return new Cat();
        else return null;
    }

}