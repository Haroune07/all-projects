import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateNum {
    public static void main(String[] args) throws Exception {

        int[] nums = { 1, 2, 4, 3, 5, 3 };

        System.out.println(hasDuplicate(nums));

    }

    public static boolean hasDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i : nums) {

            set.add(i);

            if (set.contains(i)) {
                return true;
            }

        }

        return false;
    }
}
