package Singleton;

public class Client {
    public static void main(String[] args) {
        Print p1,p2;
        p1 = Print.getInstance();
        System.out.println("--------------");
        p2 = Print.getInstance();
    }
}
