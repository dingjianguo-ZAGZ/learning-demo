package string;

public class E40pathEncryption {
    public String pathEncryption(String path) {
        char[] chars = path.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '.'){
                chars[i] = ' ';
            }
        }
        return new String(chars);
    }
}
