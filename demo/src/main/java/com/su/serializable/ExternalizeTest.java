package com.su.serializable;

import java.io.*;

public class ExternalizeTest {
    //静态内部类
    static class Person implements Externalizable {
        private String name = null;
        transient private Integer age = null;
        private SerializableTest.Sex sex;

        public Person() {
            System.out.println("Call person");
        }

        public Person(String name, Integer age, SerializableTest.Sex sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        //重写 toString 方法

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(name);
            out.writeInt(age);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            name = (String) in.readObject();
            age = in.readInt();
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("jack", 20, null);
        // 序列化对象到文件
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("d:/a.txt")))) {
            person.writeExternal(oos);
            System.out.println("对象已序列化到 d:/a.txt 文件");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 从文件中反序列化对象
        Person deserializedPerson = new Person();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"))) {
            deserializedPerson.readExternal(ois);
            System.out.println("对象已从 d:/a.txt 文件反序列化");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(deserializedPerson);
    }
}
