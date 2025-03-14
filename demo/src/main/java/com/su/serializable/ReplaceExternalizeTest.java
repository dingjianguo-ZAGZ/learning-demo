package com.su.serializable;

import java.io.*;

public class ReplaceExternalizeTest {
    //静态内部类
    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
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
        private void writeObject(ObjectOutputStream oos) throws IOException {
            System.out.println("调用writeObject");
            oos.defaultWriteObject();
            oos.writeInt(age);
        }
        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            System.out.println("调用readObject");
            ois.defaultReadObject();
            int age = ois.readInt();
        }
    }

    public static void main(String[] args) {
        ReplaceExternalizeTest.Person person = new ReplaceExternalizeTest.Person("jack", 25, null);
        // 序列化对象到文件
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("d:/a.txt")))) {
            oos.writeObject(person);
            System.out.println("对象已序列化到 d:/a.txt 文件");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 从文件中反序列化对象
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"))) {
            ReplaceExternalizeTest.Person deserializedPerson = (ReplaceExternalizeTest.Person) ois.readObject();
            System.out.println("对象已从 d:/a.txt 文件反序列化");
            System.out.println(deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
