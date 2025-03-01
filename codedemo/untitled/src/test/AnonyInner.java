package test;

abstract class Base {
    abstract void f();

}
public class AnonyInner{
    public static Base getBase(){
        return new Base() {
            {
                System.out.println("内部类");
            }
            @Override
            void f() {
                System.out.println("F方法");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase();
        base.f();
    }
}
