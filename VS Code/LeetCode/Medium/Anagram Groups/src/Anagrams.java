import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) throws Exception {

        String[] strs = { "cat", "act", "tops", "pots", "hat" };

        System.out.println("hello");

        System.out.println(groupAnagrams(strs).toString());

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> list = new HashMap<>();

        for(String s : strs){
            char[] sChar = s.toCharArray();

            Arrays.sort(sChar);

            String sorted = String.valueOf(sChar);

            if(!list.containsKey(sorted)){
                list.put(sorted, new ArrayList<>());
            }
            list.get(sorted).add(s);
        }

        return new ArrayList<>(list.values());

    }

}
