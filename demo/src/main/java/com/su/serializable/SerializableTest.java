package com.su.serializable;

import java.io.*;

public class SerializableTest {
    //枚举性别类
    enum Sex {
        MALE,
        FEMALE;
    }
    //静态内部类
    static class Person implements Serializable{
        //设置序列化id
        private static final long serialVersionUID = 1L;
        private String name = null;
        private Integer age = null;
        private Sex sex;

        public Person() { }

        public Person(String name, Integer age, Sex sex) {
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
    }

    /**
     * 序列化
     * @param filename
     * @throws IOException
     */
    private static void serialize(String filename) throws IOException {
        File file = new File(filename); //定义保存路径
        OutputStream os = new FileOutputStream(file);//创建文件输出流
        ObjectOutputStream oos = new ObjectOutputStream(os); //对象输出流
        oos.writeObject(new Person("张三",18,Sex.MALE));
        //关闭资源
        os.close();
        oos.close();
    }
    /**
     * 反序列化
     * @param filename
     * @throws IOException
     */
    private static void deserialize(String filename) throws IOException, ClassNotFoundException {
        File file = new File(filename); //定义保存路径
        InputStream is = new FileInputStream(file);//创建文件输入流
        ObjectInputStream ois = new ObjectInputStream(is); //对象输入流
        Object object = ois.readObject();
        //关闭资源
        is.close();
        ois.close();
        System.out.println(object);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serialize("d:/a.txt");
        deserialize("d:/a.txt");
    }
}
