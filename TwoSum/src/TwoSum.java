import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) throws Exception {
        
        int[] nums = {1, 3 , 5 , 7 , 9 ,14,19};
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        TwoSum sum = new TwoSum();
        
        int[] result = sum.twoSum(nums , target);

        if (result != null) {
            System.out.println("[ " + result[0] + " , " + result[1] + " ]");
        }

        else{
            System.out.println("Pas de solution");
        }

        scanner.close();
        
    }

    public int[] twoSum(int[] nums, int target){

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            int cur = nums[i];
            int x = target - cur;

            if (map.containsKey(x)) {
                return new int[] {map.get(x), i};
            }
            map.put(cur, i);
        }
        
        return null;
    }
}
