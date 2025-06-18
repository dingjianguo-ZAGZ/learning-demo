package string;

public class E41dynamicPassword {
    public String dynamicPassword(String password, int target) {
        return password.substring(target,password.length())+password.substring(0,target);
    }
}
