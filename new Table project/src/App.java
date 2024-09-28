import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {

    }

    public boolean hasDuplicate(int[] nums) {     
       
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums){
            if (set.contains(i)) {
                return true;
            }
        }

        return false;
       
    }

}
