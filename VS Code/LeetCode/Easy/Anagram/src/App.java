import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        
        String a = "abc";
        String b = "bca";
        String c = "abd";

        System.out.println(isAnagram(a,c));

    }

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){return false;}

        char[] tChar = t.toCharArray();
        char[] sChar = s.toCharArray();

        Arrays.sort(tChar);
        Arrays.sort(sChar);

        for(int i = 0; i < tChar.length; i++){
            if(tChar[i] != sChar[i]){
                return false;
            }
        }

        return true;

    }
}
