package DesignPatternPractice;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializableSingletonTest {

    public static void main(String[] args) {
        try {
            EnumSerializableSingleton instance1 = EnumSerializableSingleton.INSTANCE;
            Path path = Paths.get("file.text");
            ObjectOutput out = new ObjectOutputStream(Files.newOutputStream(path));
            out.writeObject(instance1);
            out.close();

            // deserialize from file to object
            ObjectInput in = new ObjectInputStream(Files.newInputStream(path));

            EnumSerializableSingleton instance2 = (EnumSerializableSingleton) in.readObject();
            in.close();

            System.out.println("instance1 hashCode:- " + instance1.hashCode());
            System.out.println("instance2 hashCode:- " + instance2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class SerializableSingleton implements Serializable {

    public static SerializableSingleton instance = new SerializableSingleton();

    private SerializableSingleton() {

    }

    protected Object readResolve(){
        return instance;
    }

}

enum EnumSerializableSingleton{
    INSTANCE;
}
