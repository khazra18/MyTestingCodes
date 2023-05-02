package generics;

public class GenericsMethodDemo {

    public static void main(String[] args) {

        GenClassDemo myGDemo = new GenClassDemo();
        myGDemo.genDemoMethod(5);
        myGDemo.genDemoMethod("Krishanu");

        System.out.println(myGDemo.getDemoMethod(55));

    }

}

class GenClassDemo{

    public <T> void genDemoMethod(T data){
        System.out.println("Generic Method : " + data);
    }

    public <T> T getDemoMethod(T data){
        return data;
    }

}