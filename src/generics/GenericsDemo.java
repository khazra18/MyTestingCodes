package generics;

public class GenericsDemo {

    public static void main(String[] args) {

        GenericClassDemo<String> myGeneric = new GenericClassDemo<>("Krishanu");
        System.out.println(myGeneric.getData());

    }

}

class GenericClassDemo<T>{

    private T data;

    public GenericClassDemo(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
