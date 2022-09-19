package DesignPatternPractice;

public class SingletonTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        //How to prevent clonable in singleton class
        /*Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = (Singleton) instance1.clone();

        System.out.println("Instance 1 hashcode - " + instance1.hashCode());
        System.out.println("Instance 2 hashcode - " + instance2.hashCode());*/

        //How we can use enum as single class
        EnumSingleTon enumSingleTon = EnumSingleTon.INSTANCE;

    }

}

class Singleton implements Cloneable{

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instance;
    }
}

enum EnumSingleTon implements Cloneable{
    INSTANCE;

}
