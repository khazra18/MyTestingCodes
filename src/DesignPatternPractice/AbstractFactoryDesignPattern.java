package DesignPatternPractice;

public class AbstractFactoryDesignPattern {
    public static void main(String[] args) {

        FactoryProvider factoryProvider = new FactoryProvider();
        AbstractFactory animal = factoryProvider.getFactory("shape");
        AnimalAFD dog = (AnimalAFD) animal.createFactory("cat");
        System.out.println(dog.getAnimalName());


    }
}

interface AnimalAFD {
    String getAnimalName();

    String getAnimalSound();
}

class CatAFD implements AnimalAFD {

    @Override
    public String getAnimalName() {
        return "Cat";
    }

    @Override
    public String getAnimalSound() {
        return "Meow";
    }
}

class DogAFD implements AnimalAFD {

    @Override
    public String getAnimalName() {
        return "Dog";
    }

    @Override
    public String getAnimalSound() {
        return "Bark";
    }
}

interface Shape {
    String shapeName();
}

class Circle implements Shape {

    @Override
    public String shapeName() {
        return "Circle";
    }
}

class Rectangle implements Shape {

    @Override
    public String shapeName() {
        return "Rectangle";
    }
}

interface AbstractFactory<T> {
    T createFactory(String type);
}

class ShapeFactory implements AbstractFactory<Shape> {

    @Override
    public Shape createFactory(String type) {
        if (type.equalsIgnoreCase("Circle"))
            return new Circle();
        else if (type.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}

class AnimalFactoryAFD implements AbstractFactory<Animal> {

    @Override
    public Animal createFactory(String type) {
        if (type.equalsIgnoreCase("Cat"))
            return new Cat();
        else if (type.equalsIgnoreCase("Dog")) {
            return new Dog();
        }
        return null;
    }
}


class FactoryProvider{

    public AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("animal")){
            return new AnimalFactoryAFD();
        }else if (choice.equalsIgnoreCase("shape"))
            return new ShapeFactory();

        return null;
    }

}
