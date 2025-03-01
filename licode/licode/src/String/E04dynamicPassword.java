package String;

public class E04dynamicPassword {
    public String dynamicPassword(String password, int target) {
        return password.substring(target) + password.substring(0, target);

    }

    public static void main(String[] args) {
        String s = "jiubgkj";
        String substring = s.substring(0, 3);
        System.out.println(substring);
    }
}
