package Test;

import java.util.HashMap;

public class Test {

    enum color {RED,GREEN,BLUE};

    public static void main(String[] args) throws CloneNotSupportedException {

        /*HashMap<StringBuilder,Integer> map = new HashMap<>();
        StringBuilder str = new StringBuilder("Krishanu");
        map.put(str,1);
        str.append(" Hazra");

        System.out.println(map.get(str));*/

        String s1 = new String ("java");
        String s2= new String ("JAVA");
        System.out.println(s1=s2);

    }

}

class CloneTest implements Cloneable{

    private String data = "abc";

    public void method(){
        System.out.println(data);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
