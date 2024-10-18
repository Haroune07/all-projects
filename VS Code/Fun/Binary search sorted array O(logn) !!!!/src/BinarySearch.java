import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) throws Exception {

        int[] nums = { 1, 2, 5, 7, 9, 10, 12, 15, 19, 20, 6, 17, 22 };
        Arrays.sort(nums);

        int result = binarySearch(nums, 6);

        System.out.println(result);

    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            else if (nums[mid] < target) {
                left = mid + 1;
            }

            else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }
}
